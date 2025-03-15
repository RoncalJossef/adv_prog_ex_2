package ch.hesso.mercedes.models

import ch.hesso.mercedes.traits.Engine
import ch.hesso.mercedes.enums.FuelType

case class DieselEngine(val engineSize: Double) extends Engine:
    val fuelType: FuelType = FuelType.Diesel

    override def toString: String = 
        s"(FuelType: Diesel, Size: ${engineSize})"

