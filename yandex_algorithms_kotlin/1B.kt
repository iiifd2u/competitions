fun splitLineOnK(line:List<Int>, n:Int):Pair<Int, MutableList<Int>>{
    var i = 0
    val lens = mutableListOf<Int>()
    var minVal = line[0]
    var last = 0

    while(i<n){
        if (minVal > line[i]) {minVal = line[i]}
        if (minVal <(i-last+1)){
            minVal = line[i]
            lens.add(i-last)
            last = i
        }
        i++
    }
    lens.add(i - last)
    return Pair(lens.size, lens)
}

fun main(){
    val t = readln().toInt()
    for (i in 0..<t){
        val n = readln().toInt()
        val line = readln().split(" ").map { it.toInt() }
        val (l, lens) = splitLineOnK(line, n)
        println(l)
        println(lens.joinToString(" "))
    }
}