import kotlin.math.*

fun C(m:Int, a:List<Int>):Int{
    val aval = mutableListOf(Pair(a[0], 1));
    for (i in 1..<30){
        if (a[i]/(2.0.pow(i).toInt()) > aval.last().first / aval.last().second){
            aval.add(Pair(a[i], 2.0.pow(i).toInt()))
        }
    }
    aval.reverse()

    val n = aval.size
    var coins = (m / aval.first().first * aval.first().second)
    var tail = m % aval.first().first
    var i = 0

    while ((tail>0) && (i+1<n)){
        val temp = ceil(tail.toDouble()/aval[i+1].first) + aval[i+1].second
        if (temp>aval[i].second){
            return coins + aval[i].second
        } else {
            coins += (floor(tail.toDouble()/aval[i+1].first)*aval[i+1].second).toInt()
            tail %= aval[i+1].first
        }
        i+=1
    }
    if (tail>0){
        coins += (ceil(tail.toDouble()/ aval.last().first)*aval.last().second).toInt()
    }
    return coins
}



fun main(){
    val M:Int = readln().toInt()
    val minutes = readln().split(" ").map { it.toInt() }
    val coins = C(M, minutes)
    println(coins)
}


/*
11
1 1 10 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
*/