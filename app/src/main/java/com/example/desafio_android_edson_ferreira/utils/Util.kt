package com.example.desafio_android_edson_ferreira.utils

import java.util.HashMap

object Util {
    @Throws(Exception::class)
    fun retornaHashJson(type: String, vararg params: Any): HashMap<String, String> {
        val mHash = HashMap<String, String>()

        if (params.isNotEmpty()) {
            for (`object` in params) {
                val key = (`object` as String).split(type.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                if (key.size >= 2)
                    mHash[key[0]] = key[1]

            }
        }
        return mHash
    }
}