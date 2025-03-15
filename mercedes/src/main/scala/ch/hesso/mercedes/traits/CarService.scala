package ch.hesso.mercedes.traits

// Adding contravariance allows all subtypes of Car
trait CarService[-T]:
    def process(car: T): Unit