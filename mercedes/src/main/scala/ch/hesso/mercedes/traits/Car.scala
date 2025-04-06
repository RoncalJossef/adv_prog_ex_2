package ch.hesso.mercedes.traits

import ch.hesso.mercedes.enums.{Transmission}
import ch.hesso.mercedes.traits.Engine
import ch.hesso.mercedes.enums.FuelType

// Using covariance will allow us to treat Mercedes[PetrolEngine] as a subtype of Car[PetrolEngine]
trait Car[+T <: Engine]:
    def brand: String
    val engine: T
    // Here, parameterized type seems pertinent to allow us to create functions that could be override for each fuel type with type safety
    // We expect that each kind of Engine will have a different behaviour
    // def startEngine(): Unit
    // def accelerate(speed: Int): Unit
    // def brake(speed: Int): Unit
    val model: String
    val year: Int
    val transmission: Transmission
    val mileage: Int
    val mpg: Double

    override def toString: String = 
        s"Brand: ${brand}, Model: ${model}, Engine: ${engine}, Transmission: ${transmission.toString}, Year: ${year}"


object Car:

    def carsPerYear(cars: List[Car[_]]): Map[Int, Int] =
        // Using group by and maps allows us to get all the cars by year in order to do report about it.
        cars
        .groupBy(_.year)
        .mapValues(_.length)
        .toSeq
        .sortBy(_._1)
        .toMap

    def carsByEngineType(cars: List[Car[_]]): Map[FuelType, Int] =
        // Using group by and maps allows us to get all the cars by fueltype.
        cars
        .groupBy(_.engine.fuelType)
        .mapValues(_.length)
        .toMap


    

