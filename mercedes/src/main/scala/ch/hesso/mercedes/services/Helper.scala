    
package ch.hesso.mercedes.services

object Helper:
    def withLog[A, B](description: String)(operation: => B): B =
        // Using parameter groups with call by name, allows me to log long operations
        println(s"--- Running: $description")
        val result = operation
        println(s"Result: $result")
        result