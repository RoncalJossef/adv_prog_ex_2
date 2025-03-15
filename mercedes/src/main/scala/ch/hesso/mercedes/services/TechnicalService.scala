package ch.hesso.mercedes.services

import ch.hesso.mercedes.traits.{CarService, Engine, Car}

class TechnicalService extends CarService[Car[Engine]]:
    def process(car: Car[Engine]): Unit =
        println(s"Technical service for ${car.model}, ${car.engine}")