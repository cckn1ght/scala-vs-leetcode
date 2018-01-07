object Solution {
  def judgeCircle(moves: String): Boolean = {
    var vertical = 0 // 记录上下方向上的步数
    var horizontal = 0 // 记录左右方向上的步数
    for (c <- moves) {
      c match {
        case 'U' => horizontal += 1
        case 'D' => horizontal -= 1
        case 'L' => vertical -= 1
        case 'R' => vertical += 1
      }
    }
    horizontal == 0 && vertical == 0
  }
}