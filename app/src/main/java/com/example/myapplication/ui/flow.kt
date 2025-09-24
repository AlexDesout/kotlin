import android.R
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val res = compute1()
        .map { it * 3 }
        .filter { it % 2 == 0 }
        .fold(0) { acc, value -> acc + value  }

    println(res)

    println("Utilisation de ZIP:")
    alphabet().zip(chiffre()) { lettre, nombre ->
        "($lettre, $nombre)"
    }.collect { resultatCombine ->
        println(resultatCombine)
    }

    println("Utilisation de COMBINE:")
    alphabet().combine(chiffre()) { lettre, nombre ->
        "($lettre, $nombre)"
    }.collect { resultatCombine ->
        println(resultatCombine)
    }

    val numbers = oneToTen().take(10).takeWhile { it <= 5 }

    numbers.collect() {
        println(it)
    }

}

fun compute1(): Flow<Int> {
    return flow {
        for (i in 1..10) {
            emit(i)
            delay(200L)
        }
    }
}

fun alphabet(): Flow<String> {
    return flow {
        emit("A")
        delay(200L)
        emit("B")
        delay(200L)
        emit("C")
    }
}

fun chiffre(): Flow<Int> {
    return flow {
        for (i in 1..3) {
            emit(i)
            delay(300L)
        }
    }
}

fun oneToTen(): Flow<Int> {
    return flow {
        for (i in 1..10) {
            emit(i)
            delay(200L)
        }
    }
}

fun oneToThree(): Flow<Int> {
    return flow {
        for (i in 1..3) {
            emit(i)
            delay(200L)
        }
    }
}

fun fourToSix(): Flow<Int> {
    return flow {
        for (i in 4..6) {
            emit(i)
            delay(200L)
        }
    }
}


