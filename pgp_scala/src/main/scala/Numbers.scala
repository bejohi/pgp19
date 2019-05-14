object Numbers {


  def relativePrimes_Rec(n: Int, k: Int): Unit ={
    if(k == 0){
      return
    }
    if(gcd(n,k) == 1){
      println(k)
    }
    relativePrimes_Rec(n,k-1)

  }

  def relativePrimes(n: Int): Unit = {
    relativePrimes_Rec(n,n)
  }

  def gcd(n: Int, k: Int): Int = {
    if(n == 0 || k == 0){
      return 0
    }
    if(n == k){
      return n
    }

    if(n > k){
      return gcd(n-k,k)
    }

    gcd(n,k-n)
  }

  def main(args:Array[String]) {
    assert(gcd(10,15) == 5)
    assert(gcd(1,1) == 1)
    assert(gcd(6,18) == 6)
    assert(gcd(17,18) == 1)
    assert(gcd(24,26) == 2)
    relativePrimes(10)
  }  
}