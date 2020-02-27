package dev.kodorebi.realmtypesafe

import android.util.Log

sealed class Benchmark {
    companion object {
        private const val TAG = "BENCHMARK"

        fun <T> measure(label: String, block: () -> T) : T {
            val startTime = System.currentTimeMillis()
            val result = block.invoke()
            val endTime = System.currentTimeMillis()
            val time = endTime - startTime

            Log.d(TAG, "${label}: ${time}ms")

            return result
        }
    }
}