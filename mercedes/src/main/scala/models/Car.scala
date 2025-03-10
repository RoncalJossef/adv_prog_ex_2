//jpc: why an abstract class? better to use a trait
abstract class Car (
    brand: String,
    model: String,
    year: Int,
    transmission: Transmission,
    mileage: Int,
    fuelType: FuelType,
    mpg: Double,
    engineSize: Double) :

    override def toString: String = 
        s"Brand: ${brand}, Model: ${model}, Year: ${year}, Transmission: ${transmission.toString}"
    

