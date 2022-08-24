package smithy4s.example

import smithy4s.schema.Schema.int
import smithy4s.Hints
import smithy4s.ShapeId
import smithy4s.schema.Schema.bijection
import smithy4s.example.refined.Age
import smithy4s.Newtype
import smithy4s.example.refined.Age.provider._
import smithy4s.Schema

object PersonAge extends Newtype[Age] {
  val id: ShapeId = ShapeId("smithy4s.example", "PersonAge")
  val hints : Hints = Hints.empty
  val underlyingSchema : Schema[Age] = int.refined[smithy4s.example.refined.Age](smithy4s.example.AgeFormat()).withId(id).addHints(hints)
  implicit val schema : Schema[PersonAge] = bijection(underlyingSchema, asBijection)
}