import scala.io.Source
import scala.util.{Try,Success,Failure}


def readTextFile(filename: String): Try[List[String]] = {
    Try(Source.fromFile(filename).getLines.toList)
}
val filename = "/Users/gokulkg/test/gene.n3sxsa"

readTextFile(filename) match {
    case Success(lines) => lines.foreach(println)
    case Failure(f) => println(f)
}


def toInt(s: String): Try[Int] = Try {
  Integer.parseInt(s)
}
