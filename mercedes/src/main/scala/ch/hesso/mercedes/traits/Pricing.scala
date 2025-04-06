package ch.hesso.mercedes.traits

trait Pricing :
    val price: Option[Int]

    override def toString(): String = 
        price match 
            case Some(p) => s"Price: $p"
            case None => "Price: Not available"

object Pricing:

    def getTotalValue(pricings: List[Pricing]): Int =
        // FlatMap and Sum allows us to create a report on the total price of the priceable things
        pricings
        .flatMap(_.price)
        .sum
        
