package ch.hesso.mercedes

import ch.hesso.mercedes.models.{Mercedes, GenericMercedes, PetrolEngine, DieselEngine}
import ch.hesso.mercedes.enums.Transmission
import ch.hesso.mercedes.services.TechnicalService
import ch.hesso.mercedes.traits.{Car, CarWithWarranty, Warranty, Pricing}
import ch.hesso.mercedes.enums.FuelType

def processResult(result: Either[String, List[GenericMercedes]]): Unit =
  result match
    case Right(mercedesCars) if mercedesCars.nonEmpty =>
      println(s"There are ${mercedesCars.length} Mercedes cars imported.")
      mercedesCars.take(3).zipWithIndex.foreach { case (car, index) =>
        println(car)
      }
      println(s"Last car: ${mercedesCars.last}")

      val carsPerYear = Car.carsPerYear(mercedesCars)
      println(s"We have ${carsPerYear(2010)} from 2010 and ${carsPerYear(2011)} from 2011.")

      val globalPrice = Pricing.getTotalValue(mercedesCars)
      println(s"The total value of all available cars is $globalPrice.")

      val carsByEngine = Car.carsByEngineType(mercedesCars)
      println(s"We have ${carsByEngine(FuelType.Diesel)} diesel cars, that we have to sell before severe legislation.")      
      
      val technicalService = TechnicalService()
      technicalService.processCars(mercedesCars, car => car.engine.fuelType == FuelType.Diesel && car.year <= 1990)
      // Applying technical service for diesel cars older than 1990

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

 


    
