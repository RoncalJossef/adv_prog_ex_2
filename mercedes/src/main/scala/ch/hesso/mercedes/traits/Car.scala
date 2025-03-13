package ch.hesso.mercedes.traits

import ch.hesso.mercedes.enums.{Transmission}
import ch.hesso.mercedes.traits.Engine

trait Car[T <: Engine]:
    def brand: String
    def engine: T
    // Here, parameterized type seems pertinnent to allow us to create functions that could be override for each fuel type
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
        s"Brand: ${brand}, Model: ${model}, Engine: ${engine}, Transmission: ${transmission.toString}"
    

