package com.example.home

import android.R
import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import java.util.*

class pengingat : Activity() {

    internal var myTimePicker: TimePicker? = null
    internal var buttonstartSetDialog: Button
    internal var textAlarmPrompt: TextView

    internal var timePickerDialog: TimePickerDialog

    internal var onTimeSetListener: TimePickerDialog.OnTimeSetListener =
        TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            val calNow = Calendar.getInstance()
            val calSet = calNow.clone() as Calendar

            calSet.set(Calendar.HOUR_OF_DAY, hourOfDay)
            calSet.set(Calendar.MINUTE, minute)
            calSet.set(Calendar.SECOND, 0)
            calSet.set(Calendar.MILLISECOND, 0)

            if (calSet.compareTo(calNow) <= 0) {
                // Today Set time passed, count to tomorrow
                calSet.add(Calendar.DATE, 1)
                Log.i("hasil", " =<0")
            } else if (calSet.compareTo(calNow) > 0) {
                Log.i("hasil", " > 0")
            } else {
                Log.i("hasil", " else ")
            }

            setAlarm(calSet)
        }

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pengingat)

        textAlarmPrompt = findViewById(R.id.alarmprompt) as TextView

        buttonstartSetDialog = findViewById(R.id.startSetDialog) as Button
        buttonstartSetDialog.setOnClickListener(object : DialogInterface.OnClickListener() {

            fun onClick(v: View) {
                textAlarmPrompt.text = ""
                openTimePickerDialog(false)

            }
        })

    }

    private fun openTimePickerDialog(is24r: Boolean) {
        val calendar = Calendar.getInstance()

        timePickerDialog = TimePickerDialog(
            this@MainActivity,
            onTimeSetListener, calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE), true
        )
        timePickerDialog.setTitle("Set Alarm Time")

        timePickerDialog.show()

    }

    private fun setAlarm(targetCal: Calendar) {

        textAlarmPrompt.text = ("***\n" + "Alarm set on " + targetCal.getTime()
                + "\n***")

        val intent = Intent(baseContext, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            baseContext, RQS_1, intent, 0
        )
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(
            AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
            pendingIntent
        )

    }

    companion object {

        internal val RQS_1 = 1
    }

}