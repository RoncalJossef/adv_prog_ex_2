import scala.io.Source

case class Mercedes(
    model: String,
    year: Int,
    price: Double,
    transmition: Transmission,
    mileage: Int,
    fuelType: FuelType,
    tax: Int,
    mpg: Double,
    engineSize: Double) extends Car {
    val brand: String = "Mercedes"
}

object Mercedes {
    def createFromCSV(filename: String): List[Mercedes] = {
        val file = getClass.getResource(filename)
        if (file != null) {
            val source = Source.fromURL(file)
            val lines = source.getLines().drop(1)
            lines.map { line =>
                val columns = line.split(",")
                Mercedes(
                    columns(0), //model
                    columns(1).toInt, // year
                    columns(2).toDouble,  // price
                    Transmission.safeValueOf(columns(3)), 
                    columns(4).toInt, // mileage
                    FuelType.safeValueOf(columns(5)), 
                    columns(6).toInt, // tax
                    columns(7).toDouble,  // mpg
                    columns(8).toDouble) // engineSize
            }.toList
        } else {
            List.empty[Mercedes]
        }
    }
}