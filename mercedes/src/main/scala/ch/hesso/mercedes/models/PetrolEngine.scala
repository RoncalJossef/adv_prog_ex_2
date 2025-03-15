package ch.hesso.mercedes.models

import ch.hesso.mercedes.traits.Engine
import ch.hesso.mercedes.enums.FuelType

case class PetrolEngine(val engineSize: Double) extends Engine:
    val fuelType: FuelType = FuelType.Petrol

    override def toString: String = 
        s"(FuelType: Petrol, Size: ${engineSize})"