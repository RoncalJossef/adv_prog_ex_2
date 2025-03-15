package ch.hesso.mercedes

import ch.hesso.mercedes.models.{Mercedes, GenericMercedes, PetrolEngine, DieselEngine}
import ch.hesso.mercedes.enums.Transmission
import ch.hesso.mercedes.services.TechnicalService
import ch.hesso.mercedes.traits.{CarWithWarranty, Warranty}

def processResult(result: Either[String, List[GenericMercedes]]): Unit =
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
    Mercedes("S Class", DieselEngine(200.0), 2025, None, Transmission.Automatic, 100, Some(100), 130.0),
    Mercedes("GLS", PetrolEngine(200.0), 2018, Some(50022), Transmission.Automatic, 150, None, 130.0),
    Mercedes("SLS AMG", DieselEngine(250.0), 2016, None, Transmission.Automatic, 150, None, 150.0)
  )

  testOptionMercedes.foreach(println)
  val technicalService = TechnicalService()
  testOptionMercedes.foreach(technicalService.process)

  val carWithWarranty: CarWithWarranty = new Mercedes("S Class", DieselEngine(200.0), 2025, None, Transmission.Automatic, 100, Some(100), 130.0) with Warranty:
    def warrantyYears: Int = 6

  println(s"Warranty years for ${carWithWarranty.model}: ${carWithWarranty.warrantyYears}")

  technicalService.process(carWithWarranty)

    
