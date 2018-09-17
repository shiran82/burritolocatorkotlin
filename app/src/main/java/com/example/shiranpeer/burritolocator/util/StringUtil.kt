package com.example.shiranpeer.burritolocator.util

object StringUtil {
    fun dollarBuilder(priceLevel: Int): String {
        val dollars = StringBuilder()
        for (i in 0 until priceLevel) {
            dollars.append("$")
        }

        return dollars.toString()
    }
}
