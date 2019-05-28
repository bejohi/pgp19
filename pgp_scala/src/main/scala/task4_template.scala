object Task4 {

  /**
  a) Implementieren Sie die Funktion applyFuncs(fList: List[Double => Double], arg : Double),
  die eine Liste mit Funktionen fList entgegennimmt und die Verkettung dieser Funktionsaufrufe auf das Argumente arg
  anwendet. Sollte die Liste leer sein wird die Identitätsfunktion auf das Argument angewendet - sprich der Argumentwert
  zurückgegeben. Bsp: applyFuncs((List(x => x * 2, x => x * 3), 4) gibt den Wert 24 zurück
    */
  def applyFuncs(fList: List[Double => Double], arg: Double): Double = {
    fList match {
      case head :: tail => applyFuncs(tail,head(arg))
      case Nil => arg
    }
  }


  /**
  b) Implementieren Sie nun die Funktion applyFuncsReverse(fList: List[Double => Double], arg : Double), die die
  Funktionen in umgekehrter Reihenfolge verknüpft und auf das Argument arg anwendet.
    */
	def applyFuncsReverse(fList: List[Double => Double], arg: Double): Double = {
    val reversedList = fList.reverse
    applyFuncs(reversedList,arg)
  }

  /**
  c) Implementieren Sie die Funktion applyFuncsArgs(fList : List[Double => Double], args : List[Double]), die zwei
  gleichlange Listen entgegennimmt. Die Liste fList besteht dabei aus einstelligen Funktionen, die List args aus
  Argumenten für diese Funktionen (hier Double). Bei jedem Schritt erstellt die Funktion applyFuncsArgs die Verkettung
  der Funktionen vom Index 0 bis zum aktuellen Index in der Liste fList i und berechnet den Funktionswert die
  verketteten Funktion für das Argument an der Stelle i in der Liste args. Als Ergebnis liefert es die Liste der
  berechneten Funktionen. Bsp: applyFuncsArgs(List(x => x + 1, x => x - 2, x => x * 3),List(1,2,3)) gibt List(1,2,6)
  zurück.
    */
  def applyFuncsArgs(fList: List[Double => Double], args: List[Double]): List[Double] = {
    _applyFuncsArgs(fList,args,0,0)
  }

  def _applyFuncsArgs(fList: List[Double => Double], args: List[Double],index_outer:Int,index_inner:Int): List[Double] = {
    if(index_inner >= fList.length && index_outer >= fList.length){

    }

    return null
  }
  
  def main(Args: Array[String]) = {
    val f = (x: Double) => 2 + x
    val f2 = (x: Double) => 4 * x
    val fList = List(
    	f,
      f2
    )
    println(applyFuncs(fList, 2))
    println(applyFuncsReverse(fList, 2))
    println(applyFuncsArgs(fList, List(1,2)))
  }
}
