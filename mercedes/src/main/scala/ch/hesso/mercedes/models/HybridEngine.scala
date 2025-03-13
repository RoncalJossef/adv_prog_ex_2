package ch.hesso.mercedes.models

import ch.hesso.mercedes.enums.FuelType
import ch.hesso.mercedes.traits.Engine

case class HybridEngine(val engineSize: Double) extends Engine:
    val fuelType: FuelType = FuelType.Hybrid