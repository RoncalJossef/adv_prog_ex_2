import scala.io.Source

object Main extends App {
  // val filename = "/data/04-MercedesCars.csv"
  // val file = getClass.getResource(filename)
  // if (file != null) {
  //   val source = Source.fromURL(file)
  //   val lines = source.getLines().toList
  //   source.close()

  //   // Process the data here
  //   println(lines.mkString("\n"))
  // } else {
  //   println("File not found!")
  // }

  val m = new Mercedes("SLK", 2005, 5200, Transmission.Automatic, 63000, FuelType.Petrol, 325, 32.1, 1.8)
  print(m)
}