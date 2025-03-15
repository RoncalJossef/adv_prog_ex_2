package ch.hesso.mercedes.traits

import ch.hesso.mercedes.models.{DieselEngine, HybridEngine, PetrolEngine, OtherEngine}

trait Engine:
    val engineSize: Double

object Engine:
    def createEngine(engineType: String, engineSize: Double): Engine = 
        engineType.toLowerCase match
            case "Petrol" => PetrolEngine(engineSize)
            case "Hybrid" => HybridEngine(engineSize)
            case "Diesel" => DieselEngine(engineSize)
            case "Other"  => OtherEngine(engineSize)
            case _        => OtherEngine(engineSize)  // Default case for any unmatched string
