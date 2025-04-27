package ch.hesso.mercedes.services

import ch.hesso.mercedes.models.Mercedes
import cats._
import cats.implicits._

//Monadic implementation
object MercedesCatalog:

    private var cars: List[Mercedes[_]] = List.empty

    def addCar(car: Mercedes[_]): Unit =
        cars = cars :+ car
    
    def addAllCars(newCars: List[Mercedes[_]]): Unit =
        cars = cars |+| newCars

    // Searching for a car might fail -> Option Monad
    def findByModelName(name: String): Option[Mercedes[_]] =
        cars.find(_.model.equalsIgnoreCase(name))

    def combineCatalogs(catalogs: List[List[Mercedes[_]]]): List[Mercedes[_]] =
        // Monoid composition
        // Monoid[List[A]] is already provided by Cats
        // Combine catalogs (lists of Mercedes cars)
        catalogs.combineAll

    def getAllCars: List[Mercedes[_]] = cars
