package com.conradharrison.example.wwwidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_view, WWWidgetPreferenceFragment())
            .commit()
        setContentView(R.layout.activity_main)
    }
}
