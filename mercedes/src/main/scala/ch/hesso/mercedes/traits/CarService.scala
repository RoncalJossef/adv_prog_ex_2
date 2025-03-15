package ch.hesso.mercedes.traits

trait CarService[-T]:
    def process(car: T): Unit