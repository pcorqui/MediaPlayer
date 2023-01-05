package com.example.mediaplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private var mediaPlayer:MediaPlayer? = null
    private var position: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.ai_2)
        mediaPlayer?.start();

        Log.i("LifeCicle","Oncreate");
    }

    override fun onStart() {
        super.onStart()
        mediaPlayer?.start();
        Log.i("LifeCicle","OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecicle","OnResume")
    }

    override fun onPause() {
        super.onPause()
        //se le pone el ? para acceder a sus propiedas
        mediaPlayer?.pause()
        Log.i("LifeCycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LifeCycle","onStop")
    }
}