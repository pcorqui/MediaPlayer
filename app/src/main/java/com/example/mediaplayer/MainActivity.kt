package com.example.mediaplayer

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.button.MaterialButton
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private var mediaPlayer:MediaPlayer? = null
    private var position: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.btnCheck).setOnClickListener{
            startActivity(Intent(this,DialogActivity::class.java))
        }

        //mediaPlayer = MediaPlayer.create(this, R.raw.ai_2)
        //mediaPlayer?.start();

        Log.i("LifeCicle","Oncreate");
    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this,R.raw.ai_2)
        //mediaPlayer?.start();
        Log.i("LifeCicle","OnStart")
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
        Log.i("Lifecicle","OnResume")
    }

    override fun onPause() {
        super.onPause()
        //se le pone el ? para acceder a sus propiedas
        mediaPlayer?.pause()
        if(mediaPlayer != null)
            position = mediaPlayer!!.currentPosition
        Log.i("LifeCycle","onPause")
    }

    //todo lo que se libera en onstop debe ser creado en onRestart
    override fun onStop() {
        super.onStop()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null;
        Log.i("LifeCycle","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LifeCycle", "onRestart")
    }
}