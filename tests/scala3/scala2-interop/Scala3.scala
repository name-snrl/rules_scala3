package scala3

extension [T, R](value: T)
  inline infix def |>(f: T => R): R = f(value)

extension [T, R](f: T => R)
  inline infix def <|(value: T): R = f(value)

object Scala3:
  def h(x: String): Unit = println(x)

  @main def test() =
    "Hi Scala 3!" |> println

    h <| "wow!"
