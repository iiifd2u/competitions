fun maxWeight(n:Int, m:Int, weights:List<Int>):Int{
    val table = MutableList(m+1) { false }
    table[0] = true

    for (w in weights){
        if (m-w<=0) {continue}
        for(i in m-w downTo 0){
            if ((!table[i+w]) && (table[i])){
                table[i+w] = true
            }
        }
    }
    for (i in m downTo 0){
        if (table[i]) {return i}
    }
    return 0
}

fun main(){
    val (n, m) = readln().split(" ").map { it.toInt() }
    val weights = readln().split(" ").map{ it.toInt() }
    println(maxWeight(n, m, weights))
}