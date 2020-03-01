package com.example.desafio_android_edson_ferreira.utils

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.desafio_android_edson_ferreira.R
import java.util.*

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

    fun loadImage(
        view: ImageView,
        url: String?,
        progressDrawable: CircularProgressDrawable?
    ) {
        val options: RequestOptions = RequestOptions()
            .placeholder(progressDrawable)
            .error(R.mipmap.ic_launcher_round)
        Glide.with(view.context)
            .setDefaultRequestOptions(options)
            .load(url)
            .into(view)
    }

    fun getProgressDrawable(context: Context?): CircularProgressDrawable? {
        val progressDrawable = CircularProgressDrawable(context!!)
        progressDrawable.strokeWidth = 10f
        progressDrawable.centerRadius = 50f
        progressDrawable.start()
        return progressDrawable
    }
}