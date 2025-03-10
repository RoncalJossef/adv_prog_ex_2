//jpc: could use packages to organize this code

enum FuelType:
    case Petrol, Hybrid, Diesel, Other

//jpc: we can do without those curly braces
object FuelType :
  def safeValueOf(str: String): FuelType = 
    str match 
      case "Petrol" => Petrol
      case "Hybrid" => Hybrid
      case "Diesel" => Diesel
      case "Other"  => Other
      case _        => Other  // Default case for any unmatched string
