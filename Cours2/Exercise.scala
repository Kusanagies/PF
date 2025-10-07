object ListOperations {
  // Renvoie les deux premiers éléments de la liste
  def firstTwo(list: List[String]): List[String] = {
    list.take(2)
  }

  // Renvoie les deux derniers éléments de la liste
  def lastTwo(list: List[String]): List[String] = {
    list.drop(list.length - 2)
  }

  // Déplace les deux premiers éléments à la fin de la liste
  def movedFirstTwoToTheEnd(list: List[String]): List[String] = {
    val (firstTwo, rest) = list.splitAt(2)
    rest ::: firstTwo
  }

  // Insère une chaîne avant le dernier élément de la liste
  def insertedBeforeLast(list: List[String], elem: String): List[String] = {
    list match {
      case Nil => Nil
      case x :: Nil => List(x) // Cas où la liste n'a qu'un seul élément
      case init :+ last => init ::: List(elem, last)
    }
  }
}

@main 
def main(): Unit = {
  firstTwo(List("a", "b", "c")) // List("a", "b")
  lastTwo(List("a", "b", "c")) // List("b", "c")
  movedFirstTwoToTheEnd(List("a", "b", "c")) // List("c", "a", "b")
  insertedBeforeLast(List("a", "b"), "c") // List("a", "c", "b")

}