// inheritance

class Foo {
  private val kl = 10
  val k = 9
}
class Bar extends Foo
class Baz extends Bar

val foo = new Foo
val bar = new Bar
val baz = new Baz


println("foo.isInstanceOf[Foo]: " + foo.isInstanceOf[Foo])
println("bar.isInstanceOf[Foo]: " + bar.isInstanceOf[Foo])
println("baz.isInstanceOf[Foo]: " + baz.isInstanceOf[Foo])

// other example

abstract class Drawable {
  def draw()
}

trait Cowboy extends Drawable {
  override def draw() { println("Bang!") }
}

trait Artist extends Drawable {
  override def draw() { println("A pretty painting") }
}

class CowboyArtist extends Artist with Cowboy {
  def pr(): Unit = {
    println("hihi")
    super.draw()
    super[Artist].draw()
  }
}

val goldy = new CowboyArtist

goldy.draw()

goldy.pr()
