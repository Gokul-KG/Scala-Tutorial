val k = 1 to 100

val t = k.map { el =>
  if(el % 21 == 0)
    Some(el)
  else
    None
}

t foreach println