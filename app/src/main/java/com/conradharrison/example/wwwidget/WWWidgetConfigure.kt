package com.conradharrison.example.wwwidget

import android.app.Activity
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.RemoteViews

class WWWidgetConfigure : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("WWWidgetConfigure/onCreate", "Called")

        // setup a RESULT_CANCELED result, in case this config activity is prematurely closed
        setResult(RESULT_CANCELED)

        // Expand Preference Fragment in to the Configure Activity
        supportFragmentManager
            .beginTransaction()
            .add(R.id.config_view_pref_container, WWWidgetPreferenceFragment())
            .commit()
        setContentView(R.layout.activity_widget_configure)
    }

    fun closeSettings(v: View) {
        Log.i("WWWidgetConfigure/closeSettings", "Called")

        val appWidgetId = getIntent().extras?.getInt(
            AppWidgetManager.EXTRA_APPWIDGET_ID,
            AppWidgetManager.INVALID_APPWIDGET_ID
        ) ?: AppWidgetManager.INVALID_APPWIDGET_ID

        // TODO Configure; default=read_from_store; Finally, write to store

        val appWidgetManager: AppWidgetManager = AppWidgetManager.getInstance(this)
        val pendingIntent: PendingIntent = Intent(this, WWWidgetConfigure::class.java)
            .let { intent ->
                PendingIntent.getActivity(this, 0, intent, 0)
            }
        RemoteViews(this.packageName, R.layout.widget_layout).also { views->
            views.setOnClickPendingIntent(R.id.wwtext, pendingIntent)
            updateWWContent(views)
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }

        val resultValue = Intent().apply {
            putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        }
        setResult(Activity.RESULT_OK, resultValue)
        finish()
    }
}
