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