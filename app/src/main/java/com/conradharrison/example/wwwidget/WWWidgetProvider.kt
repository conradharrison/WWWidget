package com.conradharrison.example.wwwidget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.widget.RemoteViews
import android.app.PendingIntent
import android.content.Intent
import android.content.Context
import android.util.Log
import java.text.DateFormat.getDateInstance
import java.text.SimpleDateFormat
import java.util.*

class WWWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        val N = appWidgetIds.size

        Log.i("WWWidget", "Updating widgets " + Arrays.asList(appWidgetIds))

        // Perform this loop procedure for each App Widget that belongs to this
        // provider
        for (i in 0 until N) {
            val appWidgetId = appWidgetIds[i]

            val views = RemoteViews(context.packageName, R.layout.widget_layout)
            update_content(views)

            // Tell the AppWidgetManager to perform an update on the current app
            // widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }

    fun update_content(views: RemoteViews) {
        views.setTextViewText(R.id.wwtext, SimpleDateFormat("hh:mm:ss", Locale.getDefault()).format(Date()))
    }
}