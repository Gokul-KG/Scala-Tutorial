// inheritance

class Foo
class Bar extends Foo
class Baz extends Bar

val foo = new Foo
val bar = new Bar
val baz = new Baz

println("foo.isInstanceOf[Foo]: " + foo.isInstanceOf[Foo])
println("bar.isInstanceOf[Foo]: " + bar.isInstanceOf[Foo])
println("baz.isInstanceOf[Foo]: " + baz.isInstanceOf[Foo])


class Drawable {
  def draw() { }
}

trait Cowboy extends Drawable {
  override def draw() { println("Bang!") }
}

trait Artist extends Drawable {
  override def draw() { println("A pretty painting") }
}

class CowboyArtist extends Artist with Cowboy

val goldy = new CowboyArtist

goldy.draw()

