package ch.hesso.mercedes.models

import ch.hesso.mercedes.traits.Engine
import ch.hesso.mercedes.enums.FuelType

case class OtherEngine(val engineSize: Double) extends Engine:
    val fuelType: FuelType = FuelType.Other

    override def toString: String = 
        s"(FuelType: Other, Size: ${engineSize})"