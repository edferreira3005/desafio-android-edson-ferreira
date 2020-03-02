package com.example.desafio_android_edson_ferreira.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio_android_edson_ferreira.R
import com.example.desafio_android_edson_ferreira.model.Characters
import com.example.desafio_android_edson_ferreira.screens.characterhq.FragmentCharacterHQ
import com.example.desafio_android_edson_ferreira.screens.characterinfo.FragmentCharacterInfo
import com.example.desafio_android_edson_ferreira.screens.listmavelcharacters.FragmentListCharacters
import com.example.desafio_android_edson_ferreira.screens.listmavelcharacters.adapter.ListCharactersAdapter
import com.example.desafio_android_edson_ferreira.utils.Constants

class MainActivity : AppCompatActivity(), ListCharactersAdapter.OnClickCharacter, FragmentCharacterInfo.onClickHQ  {

    lateinit var characters : Characters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame, FragmentListCharacters(), Constants.TAG_LIST_CHARACTERS)
            .disallowAddToBackStack()
            .commit()
    }

    override fun onClick(characters: Characters) {
        this.characters = characters
        openCharacterInfo()
    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.frame)
        if (currentFragment is FragmentListCharacters)
            finish()
        else if(currentFragment is FragmentCharacterInfo) {
            removeFragments()
            supportFragmentManager.beginTransaction()
                .add(R.id.frame, FragmentListCharacters(), Constants.TAG_CHARACTER_INFO)
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_to_left,R.anim.slide_from_right)
                .commit()
        }else if(currentFragment is FragmentCharacterHQ){
            openCharacterInfo()
        }

    }

    fun removeFragments(){
        for (fragment in supportFragmentManager.fragments) {
            supportFragmentManager.beginTransaction().remove(fragment).commit()
        }
    }

    override fun onClickHQ(id: Int) {
        val bundle = Bundle()
        val fragment = FragmentCharacterHQ()

        bundle.putInt("id", id)
        fragment.arguments = bundle

        removeFragments()
        supportFragmentManager.beginTransaction()
            .add(R.id.frame, fragment, Constants.TAG_CHARACTER_HQ)
            .disallowAddToBackStack()
            .setCustomAnimations(R.anim.slide_from_right,R.anim.slide_to_left)
            .commit()
    }

    private fun openCharacterInfo(){
        val bundle = Bundle()
        val fragment = FragmentCharacterInfo()

        bundle.putSerializable("character", characters)
        fragment.arguments = bundle

        removeFragments()
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.slide_from_right,R.anim.slide_to_left)
            .add(R.id.frame, fragment, Constants.TAG_CHARACTER_INFO)
            .disallowAddToBackStack()
            .commit()
    }
}
