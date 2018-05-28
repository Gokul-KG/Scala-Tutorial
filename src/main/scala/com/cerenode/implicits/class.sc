
implicit class StringUtil(s:String){
  def shrink: String = {
    s.take(5)
  }
}
