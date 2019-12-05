package com.example.home

import android.R
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class lpemula : AppCompatActivity() {

    internal var videoView: VideoView
    //deklarasi objek

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lpemula)

        videoView = findViewById(R.id.vlpemula) as VideoView
        //inisialisasi object videoView
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.c))
        //digunakan untuk mengidentifikasi resource seperti lokasi video
        videoView.setMediaController(MediaController(this))
        //menampilkan media controller video
        videoView.start()
        //memulai video
    }
}