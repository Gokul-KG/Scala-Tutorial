// generic function to wraps and html with a prefix and
// suffix

def wrap(prefix: String, html: String, suffix: String) = {
  prefix + html + suffix
}

// create partially applied function for this wrap function