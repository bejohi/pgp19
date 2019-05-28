import scala.math.sqrt

object Zahlenfolen {
  def primeStream(): Stream[Int] = {
    // TODO
  }

  def distanceNumberStream(): Stream[Int] = {
    val stream: Stream[Int] = 1 #:: stream.scan(x => x)
  }

  def gcd(a: BigInt, b: BigInt): BigInt = {
    if (b == 0) {
      a.abs
    } else {
      gcd(b, a % b)
    }
  }

  def mangoldtExpStream(): Stream[Int] = {
    // TODO
  }
}
