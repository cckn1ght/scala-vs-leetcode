
// no ac scala. Exceed Time limit 
object Solution {
  def isIdealPermutation(A: Array[Int]): Boolean = {
    !A.zipWithIndex.exists(cur => {
      val curVal = cur._1
      val curInx = cur._2
      A.drop(curInx + 2).exists(_ < curVal)
    })
  }
}

// Java Solution
class Solution {
    public boolean isIdealPermutation(int[] A) {
      for (int i = 0; i < A.length; i++) {
        if (A[i] > i + 1) return false;
        if (A[i] == i + 1 && i < A.length - 1) {
          if (A[i + 1] != A[i] - 1) return false;
          else i++;
        }
      }
      return true;
    }
}

// ac scala
object Solution {
  def isIdealPermutation(A: Array[Int]): Boolean = {
    !(Range(0, A.size).exists(index => math.abs(A(index) - index) > 1))
  }
}

// no ac scala. Time limit
object Solution {
  def isIdealPermutation(A: Array[Int]): Boolean = {
    !(A.zipWithIndex.exists(el => math.abs(el._1 - el._2) > 1))
  }
}