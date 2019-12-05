package com.example.home

import android.R.attr.start
import android.R
import android.net.Uri
import sun.invoke.util.VerifyAccess.getPackageName
import android.widget.VideoView
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity


class oppemula : AppCompatActivity() {

    internal var videoView: VideoView
    //deklarasi objek

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.oppemula)

        videoView = findViewById(R.id.voppemula) as VideoView
        //inisialisasi object videoView
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.a))
        //digunakan untuk mengidentifikasi resource seperti lokasi video
        videoView.setMediaController(MediaController(this))
        //menampilkan media controller video
        videoView.start()
        //memulai video
    }
}