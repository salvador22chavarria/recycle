package com.example.recycle

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
//en esta activity se conecta el videoview en donde aparece el creador de la aplicacion este se alija en una carpeta raw

class creador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creador)
        val presentacion: VideoView =findViewById(R.id.video)
        presentacion.setVideoURI(Uri.parse("android.resource://"+packageName+"/"+R.raw.chamba))
        presentacion.start()
    }
}