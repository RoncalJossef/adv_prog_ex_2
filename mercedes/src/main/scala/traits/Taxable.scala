trait Taxable :
    val tax: Option[Int]

    override def toString(): String = 
        tax match 
            case Some(t) => s"Taxe: $t"
            case None => "Taxe: Not available"