

def double(value:Long)(implicit by: Int) = value * by


double(4)(2)


//implicit val multiplier:Int = 2


//double(2)







def concate(implicit a:Char, b:String):Unit = println( a + b)

{
  implicit val x:Char = 'a'
  implicit val y = "bcd"
  concate

  {
    implicit val z = "yzx"
    //concate
  }

}
