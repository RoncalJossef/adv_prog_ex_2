package ch.hesso.mercedes.models

import scala.io.Source
import scala.util.{Try, Success, Failure}
import ch.hesso.mercedes.enums.Transmission
import ch.hesso.mercedes.traits.{Car, Engine, Pricing, Taxable}

case class Mercedes[+T <: Engine](
  model: String,
  engine: T,
  year: Int,
  price: Option[Int],
  transmission: Transmission,
  mileage: Int,
  tax: Option[Int],
  mpg: Double)
  extends Car[T] with Pricing with Taxable :
    val brand = "Mercedes"

    override def toString: String =
        s"${super[Car].toString}, ${super[Pricing].toString}, ${super[Taxable].toString}"

// alias allows us to simplify the syntax
type GenericMercedes = Mercedes[_]

object Mercedes :
  def createFromCSV(filename: String): Either[String, List[GenericMercedes]] = 
    val file = Option(getClass.getResource(filename))

    file match
      case Some(file) =>
        val source = Source.fromURL(file)
        val lines = source.getLines().drop(1)
        val mercedesList = lines.map { line =>
          val columns = line.split(",")
          val engine = Engine.createEngine(columns(5), columns(8).toDouble)
          Mercedes(
            columns(0), //model
            engine, // engine
            columns(1).toInt, // year
            Some(columns(2).toInt),  // price
            Transmission.safeValueOf(columns(3)),
            columns(4).toInt, // mileage
            Some(columns(6).toInt), // tax
            columns(7).toDouble,  // mpg
            ) // engineSize
        }.toList
        Right(mercedesList)
      case None => Left("File not found.")    
