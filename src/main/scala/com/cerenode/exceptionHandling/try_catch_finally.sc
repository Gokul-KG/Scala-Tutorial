import java.io._
import scala.io.Source

def readTextFile(filename: String): String = {
  Source.fromFile(filename).getLines.mkString("\n")
}

def readAndWreite = {
  val file = new File("/Users/gokulkg/test/newGene")
  val bw = new BufferedWriter(new FileWriter(file))
  try{
    bw.write(readTextFile("/Users/gokulkg/test/gene.n3"))
  }
  catch {
    case e: IOException => { println(e) }
          // log exception
  }
  finally {
    bw.close()
  }
}

readAndWreite


