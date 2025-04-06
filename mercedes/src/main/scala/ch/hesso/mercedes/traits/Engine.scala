package ch.hesso.mercedes.traits

import ch.hesso.mercedes.models.{DieselEngine, HybridEngine, PetrolEngine, OtherEngine}
import ch.hesso.mercedes.enums.FuelType

trait Engine:
    val engineSize: Double
    val fuelType: FuelType

object Engine:
    def createEngine(engineType: String, engineSize: Double): Engine = 
        engineType.toLowerCase match
            case "petrol" => PetrolEngine(engineSize)
            case "hybrid" => HybridEngine(engineSize)
            case "diesel" => DieselEngine(engineSize)
            case "other"  => OtherEngine(engineSize)
            case _        => OtherEngine(engineSize)  // Default case for any unmatched string
