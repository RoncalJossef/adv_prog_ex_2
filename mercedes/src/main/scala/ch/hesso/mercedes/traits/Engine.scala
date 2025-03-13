package ch.hesso.mercedes.traits

import ch.hesso.mercedes.enums.FuelType
import ch.hesso.mercedes.models.{DieselEngine, HybridEngine, PetrolEngine, OtherEngine}

trait Engine:
    def fuelType: FuelType
    val engineSize: Double

    override def toString: String = 
        s"(FuelType: ${fuelType.toString}, Size: ${engineSize})"

object Engine:
    def createEngine(engineType: String, engineSize: Double): Engine = 
        engineType.toLowerCase match
            case "Petrol" => PetrolEngine(engineSize)
            case "Hybrid" => HybridEngine(engineSize)
            case "Diesel" => DieselEngine(engineSize)
            case "Other"  => OtherEngine(engineSize)
            case _        => OtherEngine(engineSize)  // Default case for any unmatched string