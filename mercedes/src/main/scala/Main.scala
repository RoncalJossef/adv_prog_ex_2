object Main extends App {
  val filename = "/data/04-MercedesCars.csv"
  val result = Mercedes.createFromCSV(filename)
  result match {
    case Right(mercedesCars) => {
      println("There are " + mercedesCars.length + " mercedes cars imported.")
      println(mercedesCars(0))
      println(mercedesCars(1))
      println(mercedesCars(2))
      println(mercedesCars(mercedesCars.length - 1))
    }
    case Left(errorMessage) => {
      println(s"Failed to read the file: $errorMessage")
    }
  }

  val testOptionMercedes = List(
    Mercedes("S Class", 2025, None, Transmission.Automatic, 100, FuelType.Diesel, Some(100), 130.0, 200.0),
    Mercedes("GLS", 2018, Some(50022), Transmission.Automatic, 150, FuelType.Petrol, None, 130.0, 200.0),
    Mercedes("SLS AMG", 2016, None, Transmission.Automatic, 150, FuelType.Petrol, None, 150.0, 250.0)
  ).foreach(println)
}