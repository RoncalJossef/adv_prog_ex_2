package ch.hesso.mercedes.enums

enum Transmission:
    case Automatic, SemiAuto, Manual, Other

object Transmission :
  def safeValueOf(str: String): Transmission = 
    str match 
      case "Manual"     => Manual
      case "Automatic"  => Automatic
      case "Semi-Auto"  => SemiAuto
      case "Other"      => Other
      case _            => Other  // Default case for any unmatched string
  