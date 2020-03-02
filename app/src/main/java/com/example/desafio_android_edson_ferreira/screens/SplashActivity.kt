package com.example.desafio_android_edson_ferreira.screens

import android.os.Bundle
import android.os.Handler
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.desafio_android_edson_ferreira.R
import com.example.desafio_android_edson_ferreira.utils.SendIntent
import kotlinx.android.synthetic.main.layout_splash_activity.*


class SplashActivity : AppCompatActivity(), Runnable {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_splash_activity)

        YoYo.with(Techniques.Pulse)
            .duration(1000)
            .repeat(2)
            .onEnd { Handler().postDelayed(this, 100) }
            .playOn(logoMarvel)
    }

    override fun run() {
        SendIntent.with()
            .mClassFrom(this)
            .mClassTo(MainActivity::class.java)
            .mType(R.integer.slide_from_right)
            .go()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK)
            return false
        return super.onKeyDown(keyCode, event)
    }
}