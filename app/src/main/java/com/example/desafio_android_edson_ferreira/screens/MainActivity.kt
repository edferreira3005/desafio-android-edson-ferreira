package com.example.desafio_android_edson_ferreira.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio_android_edson_ferreira.R
import com.example.desafio_android_edson_ferreira.screens.listmavelcharacters.FragmentListCharacters

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame, FragmentListCharacters(), FragmentListCharacters().TAG)
            .disallowAddToBackStack()
            .commit();
    }
}
