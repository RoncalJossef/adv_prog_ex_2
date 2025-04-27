package ch.hesso.mercedes.traits

import cats._
import cats.implicits._

trait Displayable[A]:
    def display(a: A): String

//Extension method
// Add the ability to "show" properly a class
object Displayable:
    extension [A](a: A)(using d: Displayable[A])
        def show: String = d.display(a)
