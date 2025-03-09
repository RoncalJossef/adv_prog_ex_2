object Main extends App {
  val filename = "/data/04-MercedesCars.csv"
  val mercedesCars = Mercedes.createFromCSV(filename)
  println("There are " + mercedesCars.length + " mercedes cars imported.")
  println(mercedesCars(0))
  println(mercedesCars(1))

}