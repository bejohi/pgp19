/**
a) Schreiben Sie eine Funktion flatten2(cooList: List[Any]): List[Any], die eine beliebige Liste bestehend aus
Listen der Verschachtelungstiefe 2 oder weniger besteht in eine Liste ohne interne Listen umwandelt.

Bsp: Wird aus List(List("Pale Lager", "Dark Lager"), "Pilsner") ===> List("Pale Lager", "Dark Lager", "Pilsner")

b) Schreiben Sie nun eine Funkktion flatten(coolList: List[Any]): List[Any], die eine beliebige Liste bestehend aus
Listen beliebiger Verschachtelungstiefe in eine Liste ohne interne Listen umwandelt.

Bsp: wird aus List(List("Brown ale", "Scotch ale", List("India Pale Ale", "Amercian Pale Ale", "West Coast Pale Ale",
"Island Pale Ale")), List("Pale Lager", "Dark Lager"), "Pilsner") ===> List("Brown ale", "Scotch ale", "India Pale Ale",
"Amercian Pale Ale", "West Coast Pale Ale", "Island Pale Ale", "Pale Lager", "Dark Lager", "Pilsner")
  */

object Task5 {

  // From https://stackoverflow.com/questions/28074640/how-to-check-if-a-variable-is-a-list-in-scala-any-is-list
  def isList(variable: Any): Boolean =  variable.isInstanceOf[List[_]]

  def flatten2(coolList: List[Any]): List[Any] = {
    flatten(coolList)
  }
  
  def flatten(coolList: List[Any]): List[Any] = {
    coolList match {
      case head :: tail if isList(head) => flatten(head.asInstanceOf[List[Any]]) ++ flatten(tail)
      case head :: tail => head :: flatten(tail)
      case _ => List()
    }
  }
  
  def main(Args: Array[String]): Unit = {
    val lager = List("Pale Lager", "Dark Lager")
    val pale_ale = List("India Pale Ale", "Amercian Pale Ale", "West Coast Pale Ale", "Island Pale Ale")
    val ales = List("Brown ale", "Scotch ale", pale_ale)
    val beers = List(ales, lager, "Pilsner")
    
    println(beers)
    println(flatten(beers))
  }
}
