
def processResult(result: Either[String, List[Mercedes]]): Unit =
  result match
    case Right(mercedesCars) if mercedesCars.nonEmpty =>
      println(s"There are ${mercedesCars.length} Mercedes cars imported.")
      mercedesCars.take(3).zipWithIndex.foreach { case (car, index) =>
        println(car)
      }
      println(s"Last car: ${mercedesCars.last}")

    case Right(_) => 
      println("No Mercedes cars were imported.")

    case Left(errorMessage) => 
      Console.err.println(s"Failed to read the file: $errorMessage")

@main
def Main =
  val filename = "/data/04-MercedesCars.csv"
  val result = Mercedes.createFromCSV(filename)
  processResult(result)

  val testOptionMercedes = List(
    Mercedes("S Class", 2025, None, Transmission.Automatic, 100, FuelType.Diesel, Some(100), 130.0, 200.0),
    Mercedes("GLS", 2018, Some(50022), Transmission.Automatic, 150, FuelType.Petrol, None, 130.0, 200.0),
    Mercedes("SLS AMG", 2016, None, Transmission.Automatic, 150, FuelType.Petrol, None, 150.0, 250.0)
  ).foreach(println)
