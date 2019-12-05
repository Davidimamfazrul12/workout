package com.example.home

import android.R.attr.start
import android.R
import android.media.MediaPlayer
import android.widget.Toast
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context


class AlarmReceiver : BroadcastReceiver() {
    internal var player: MediaPlayer

    fun onReceive(context: Context, intent: Intent) {
        // TODO Auto-generated method stub
        Toast.makeText(context, "Alarm aktif!", Toast.LENGTH_LONG).show()
        player = MediaPlayer.create(context, R.raw.alarm)
        player.start()
    }

}