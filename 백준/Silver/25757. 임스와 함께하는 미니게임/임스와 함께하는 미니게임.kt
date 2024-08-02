import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val input = br.readLine().split(" ")
    val n = input[0].toInt()
    val game = input[1]
    val set = HashSet<String>()
    var cnt = 0
    var answer = 0
    
    when (game) {
        "Y" -> {
            for (i in 0 until n) {
                val tmp = br.readLine()
                if (!set.contains(tmp)) {
                    set.add(tmp)
                    cnt++
                    if (cnt == 1) {
                        cnt = 0
                        answer++
                    }
                }
            }
        }
        "F" -> {
            for (i in 0 until n) {
                val tmp = br.readLine()
                if (!set.contains(tmp)) {
                    set.add(tmp)
                    cnt++
                    if (cnt == 2) {
                        cnt = 0
                        answer++
                    }
                }
            }
        }
        "O" -> {
            for (i in 0 until n) {
                val tmp = br.readLine()
                if (!set.contains(tmp)) {
                    set.add(tmp)
                    cnt++
                    if (cnt == 3) {
                        cnt = 0
                        answer++
                    }
                }
            }
        }
    }
    bw.write("$answer")
    bw.close()
    br.close()
}