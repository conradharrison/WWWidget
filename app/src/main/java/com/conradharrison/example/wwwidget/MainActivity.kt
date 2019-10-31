package com.conradharrison.example.wwwidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.appwidget.AppWidgetManager
import android.content.Intent
import android.app.Activity
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
