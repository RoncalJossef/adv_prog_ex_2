import scala.io.Source
import scala.util.{Try, Success, Failure}

case class Mercedes(
    model: String,
    year: Int,
    price: Int,
    transmission: Transmission,
    mileage: Int,
    fuelType: FuelType,
    tax: Int,
    mpg: Double,
    engineSize: Double) 
    extends Car("Mercedes", model, year, transmission, mileage, fuelType, mpg, engineSize)
    with Pricing with Taxable {
}

object Mercedes {
    def createFromCSV(filename: String): Either[String, List[Mercedes]] = {
        val file = getClass.getResource(filename)
        val returnValue = Try(Source.fromURL(file)) match {
            case Success(source) => {
                val lines = source.getLines().drop(1)
                val mercedesList = lines.map { line =>
                    val columns = line.split(",")
                        Mercedes(
                        columns(0), //model
                        columns(1).toInt, // year
                        columns(2).toInt,  // price
                        Transmission.safeValueOf(columns(3)), 
                        columns(4).toInt, // mileage
                        FuelType.safeValueOf(columns(5)), 
                        columns(6).toInt, // tax
                        columns(7).toDouble,  // mpg
                        columns(8).toDouble) // engineSize
                }.toList
                Right(mercedesList)
            }
            case Failure(ex) => {
                Left(s"Error inside Mercedes Factory: ${ex.getMessage} ")
            }
        }
        returnValue
    }
}