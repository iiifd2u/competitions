fun main(){
    val (n, m) = readln().split(" ").map { it.toInt() }
    // Добавляем преподавателя
    val groups = readln().split(" ").map { it.toInt() }.map { it+1 }.toList()
    val enumGroups  = ArrayList<Pair<Int, Int>>()
    groups.forEachIndexed{i, el ->
        enumGroups.add(Pair(i, el))
    }
    val classes = readln().split(" ").map { it.toInt() }.toList()
    val enumClasses = ArrayList<Pair<Int, Int>>()
    classes.forEachIndexed{i, el ->
        enumClasses.add(Pair(i, el))
    }

    enumGroups.sortBy { it.second }
    enumClasses.sortBy { it.second }

    var i = 0
    var j = 0
    var total = 0
    val answ = Array(n) {0}.toMutableList()

    while( (i < n) && (j < m)){
        while ((j < m) && (enumGroups[i].second > enumClasses[j].second) ){
            j += 1
        }
        if (j < m){
            answ[enumGroups[i].first] = enumClasses[j].first + 1
            total ++
        }
        i++
        j++
    }
    println(total)
    println(answ.joinToString(" "))

}



/*
4 4
3 4 5 8
4 2 5 9
*/
