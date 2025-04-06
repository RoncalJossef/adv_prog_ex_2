package ch.hesso.mercedes.services

import ch.hesso.mercedes.traits.{CarService, Engine, Car}

class TechnicalService extends CarService[Car[_]]:
    def process(car: Car[_]): Unit =
        println(s"Technical service for ${car.model}, ${car.engine}, ${car.year}")

    def processCars(cars: List[Car[_]], condition: => Car[_] => Boolean): Unit =
        // Using this Call-by-name condition allows us to create a general function 
        // to process all the cars under a certain condition coming from the external
        // environment of TechnicalService
        cars.filter(condition)
        .foreach(this.process)
