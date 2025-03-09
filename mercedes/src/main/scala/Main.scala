object Main extends App {
  val filename = "/data/04-MercedessCars.csv"
  val result = Mercedes.createFromCSV(filename)
  result match {
    case Right(mercedesCars) => {
      println("There are " + mercedesCars.length + " mercedes cars imported.")
      println(mercedesCars(0))
      println(mercedesCars(1))
    }
    case Left(errorMessage) => {
      println(s"Failed to read the file: $errorMessage")
    }
  }
}