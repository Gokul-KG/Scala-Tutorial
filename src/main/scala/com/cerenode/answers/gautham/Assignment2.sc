// generic function to wraps and html with a prefix and
// suffix

def wrap(prefix: String, html: String, suffix: String) = {
  prefix + html + suffix
}

def wrap1(prefix: String)( suffix: String)( html: String) = {
  prefix + html + suffix
}
val wrap2 = wrap1("start")("last")(_)
wrap2("middle")

// create partially applied function for this wrap function
