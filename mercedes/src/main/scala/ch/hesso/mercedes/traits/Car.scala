package ch.hesso.mercedes.traits

import ch.hesso.mercedes.enums.{Transmission, FuelType}

trait Car:
    def brand: String
    val model: String
    val year: Int
    val transmission: Transmission
    val mileage: Int
    val fuelType: FuelType
    val mpg: Double
    val engineSize: Double

    override def toString: String = 
        s"Brand: ${brand}, Model: ${model}, Year: ${year}, Transmission: ${transmission.toString}"
    

