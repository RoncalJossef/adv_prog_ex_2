package ch.hesso.mercedes

import ch.hesso.mercedes.models.{Mercedes, GenericMercedes, PetrolEngine, DieselEngine}
import ch.hesso.mercedes.enums.Transmission
import ch.hesso.mercedes.services.TechnicalService
import ch.hesso.mercedes.traits.{Car, CarWithWarranty, Warranty, Pricing}
import ch.hesso.mercedes.enums.FuelType
import ch.hesso.mercedes.services.Helper
import ch.hesso.mercedes.traits.Displayable._
import ch.hesso.mercedes.models.given_Displayable_Mercedes
import ch.hesso.mercedes.services.MercedesCatalog

def processResult(result: Either[String, List[GenericMercedes]]): Unit =
  result match
    case Right(mercedesCars) if mercedesCars.nonEmpty =>
      println(s"There are ${mercedesCars.length} Mercedes cars imported.")
      mercedesCars.take(3).zipWithIndex.foreach { case (car, index) =>
        println(car.show)
      }
      println(s"Last car: ${mercedesCars.last.show}")

      val carsPerYear = Helper.withLog("Calculating Cars Per Year")(Car.carsPerYear(mercedesCars))
      println(s"We have ${carsPerYear(2010)} from 2010 and ${carsPerYear(2011)} from 2011.")

      val globalPrice = Helper.withLog("Calculating Total Value of Cars")(Pricing.getTotalValue(mercedesCars))
      println(s"The total value of all available cars is $globalPrice.")

      val carsByEngine = Helper.withLog("Calculating Cars per Type of Engine")(Car.carsByEngineType(mercedesCars))
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

  MercedesCatalog.addAllCars(List(
    Mercedes("S Class", DieselEngine(200.0), 2025, None, Transmission.Automatic, 100, Some(100), 130.0),
    Mercedes("GLS", PetrolEngine(200.0), 2018, Some(50022), Transmission.Automatic, 150, None, 130.0),
    Mercedes("SLS AMG", DieselEngine(250.0), 2016, None, Transmission.Automatic, 150, None, 150.0)
  ))

  MercedesCatalog.getAllCars.foreach(println)
  val technicalService = TechnicalService()
  MercedesCatalog.getAllCars.foreach(technicalService.process)

  val maybeGLS = MercedesCatalog.findByModelName("GLS")
  println(maybeGLS.map(_.show).getOrElse("Car not found"))

  val carWithWarranty: CarWithWarranty = new Mercedes("S Class", DieselEngine(200.0), 2025, None, Transmission.Automatic, 100, Some(100), 130.0) with Warranty:
    def warrantyYears: Int = 6

  println(s"Warranty years for ${carWithWarranty.model}: ${carWithWarranty.warrantyYears}")

  technicalService.process(carWithWarranty)

 


    
