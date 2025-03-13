package ch.hesso.mercedes.enums

enum FuelType:
    case Petrol, Hybrid, Diesel, Other

object FuelType :
  def safeValueOf(str: String): FuelType = 
    str match 
      case "Petrol" => Petrol
      case "Hybrid" => Hybrid
      case "Diesel" => Diesel
      case "Other"  => Other
      case _        => Other  // Default case for any unmatched string
