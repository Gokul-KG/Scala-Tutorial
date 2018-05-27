def validateName(name: String): Either[String, String] = {
  if (name.isEmpty) Left("Name cannot be empty")
  else Right(name)
}

//use

validateName("").isLeft


//use with pattern match

val nameVal = validateName("gokul") match {
  case Right(name) => name.toUpperCase()
  case Left(err) => // log(error)
                   "Default name"
}



