/*

Schreiben Sie diese Funktion so um, dass sie mittels Rekursion und somit voll funktional implementiert ist.
Diese soll dabei endrekursiv sein.


Hinweis: die swap-Methode (welche den Tausch von zwei Elementen eines arrays realisiert) muss ebenfalls implementiert
werden (alternative Umsetzung ist auch erlaubt). Weiterhin können Hilfsfunktionen des Arrays verwendet werden, solange
der Sortieralgorithmus noch als rekursiver Algorithmus umgesetzt wird


 */
object BubbleSort{
  def bubbleSort(arr : Array[Int]): Array[Int] ={

    for (n <- arr.length-1 to 0 by -1) {
      for (i <- 0 to n - 1 by 1) {
        if (arr(i) > arr(i + 1)) {
          swap(arr, i, i + 1)
        }
      }
    }
    arr
  }

  def swap(arr: Array[Int],pos1:Int,pos2:Int): Unit ={
    val tmp = arr(pos1)
    arr(pos1) = arr(pos2)
    arr(pos2) = tmp
  }

  def bubbleSortRec(arr : Array[Int],pos1:Int,pos2:Int): Array[Int] ={
    if(pos1 < 0){
      return arr
    }
    if(pos2 <= pos1-1){
      if(arr(pos2)>arr(pos2+1)){
        swap(arr,pos2,pos2+1)

      }
      return bubbleSortRec(arr,pos1,pos2+1)
    }
    bubbleSortRec(arr,pos1-1,0)
  }

  // Tests
  def main(args: Array[String]): Unit = {
    val arr1 = Array(10, 11, 5, 3, 4)

    bubbleSortRec(arr1,arr1.length-1,0)
    arr1.foreach(element => print(element + " "))
  }
}
