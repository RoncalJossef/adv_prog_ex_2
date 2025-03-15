package ch.hesso.mercedes.models

import ch.hesso.mercedes.traits.Engine
import ch.hesso.mercedes.enums.FuelType

case class HybridEngine(val engineSize: Double) extends Engine:
    val fuelType: FuelType = FuelType.Hybrid

    override def toString: String = 
        s"(FuelType: Hybrid, Size: ${engineSize})"