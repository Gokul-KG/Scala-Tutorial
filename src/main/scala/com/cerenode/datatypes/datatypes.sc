//val b: Byte = 1
//
////val b2: Byte = 128              // invalid
//
val short: Short = -129
//
val integer = 12345               //  type inference
//
//val newInt = short                // valid
//
////val newShort: Short = integer   // invalid
//
//val c: Char = 97
//
//val d: Char = 'b'
//
//val longInteger = 2012342434445l
//
val gravity = 9.8f
//
val pi = 3.1415
//
//val bool = true
//
//var anyValVariable: Any = 13
//
//val name: String = "Gravity"
//
//val bigString = s"""asdasd
//                    asdasd
//                    asdasd
//                  """

println(s"This is an integer variable $integer")

println(s"result of integer + short = ${integer + short}")

val p = f"value of pi = $pi%.1f"

val g = f"value of gravity = $gravity%.2f"

val s = raw"abc\ndef"

println(s)