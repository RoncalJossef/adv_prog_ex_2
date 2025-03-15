package ch.hesso.mercedes.traits

import ch.hesso.mercedes.models.Mercedes

trait Warranty:
    def warrantyYears: Int

// Intersection Type to enhance cars
type CarWithWarranty = Car[Engine] & Warranty
