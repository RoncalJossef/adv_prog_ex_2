trait Pricing {
    val price: Option[Int]

    override def toString(): String = {
        price match {
            case Some(p) => s"Price: $p"
            case None => "Price: Not available"
        }
    }
}