import scala.math.sqrt

object Zahlenfolen {
  def primeStream(): Stream[Int] = {
    return null
  }

  def distanceNumberStream(): Stream[Int] = {
    //val stream: Stream[Int] = 1 #:: stream.scan(x => x)
    return null
  }

  def gcd(a: BigInt, b: BigInt): BigInt = {
    if (b == 0) {
      a.abs
    } else {
      gcd(b, a % b)
    }
  }

  def mangoldtExpStream(): Stream[Int] = {
    return null
  }
}
