package com.conradharrison.example.wwwidget

import android.app.Activity
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.Intent
import android.os.Bundle
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_widget_configure.*
import java.text.SimpleDateFormat
import java.util.*

class WWWidgetConfigure : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Expand Preference Fragment in to the Configure Activity
        supportFragmentManager
            .beginTransaction()
            .add(R.id.config_view, WWWidgetPreferenceFragment())
            .commit()

        setContentView(R.layout.activity_widget_configure)

        // TODO Configure; default=read_from_store; Finally, write to store

        val appWidgetId = Intent().extras?.getInt(
            AppWidgetManager.EXTRA_APPWIDGET_ID,
            AppWidgetManager.INVALID_APPWIDGET_ID
        ) ?: AppWidgetManager.INVALID_APPWIDGET_ID

        val context = applicationContext
        val views = RemoteViews(context.packageName, R.layout.widget_layout)

        // Register callback for widget configuration
        val intent = Intent()
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        views.setOnClickPendingIntent(R.id.wwtext, pendingIntent)

        // One-time update to widget
        views.setTextViewText(R.id.wwtext, SimpleDateFormat("hh:mm:ss", Locale.getDefault()).format(Date()))

        val appWidgetManager: AppWidgetManager = AppWidgetManager.getInstance(context)
        appWidgetManager.updateAppWidget(appWidgetId, views)

        val resultValue = Intent().apply {
            putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        }
        setResult(Activity.RESULT_OK, resultValue)
        finish()
    }
}
