

def double(value:Long)(implicit by: Int) = value * by





double(2)(4)


implicit val xxx:Int = 2




//implicit val multiplier3:Int = 3

double(2)





double(2)(3)




def printVals(implicit a:Char, b:String):Unit = println( a + b)

{
  implicit val x:Char = 'a'
  implicit val y = "bcd"
  printVals

  {
    implicit val z = "yzx"
    //printVals
  }

}
