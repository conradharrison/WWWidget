package com.conradharrison.example.wwwidget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.widget.RemoteViews
import android.content.Context
import android.util.Log
import java.text.SimpleDateFormat
import android.content.Intent
import java.util.Arrays
import java.util.Locale
import java.util.Date

class WWWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        val N = appWidgetIds.size

        Log.i("WWWidgetProvider/onUpdate", "Updating widgets: " + Arrays.asList(appWidgetIds))

        // Perform this loop procedure for each App Widget that belongs to this
        // provider
        for (i in 0 until N) {
            val appWidgetId = appWidgetIds[i]
            updateWWWidget(context, appWidgetManager, appWidgetId)
        }
    }
}

fun updateWWWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
    Log.i("WWWidgetProvider/updateWWWidget", "Updating widget: " + appWidgetId)

    RemoteViews(
        context.packageName,
        R.layout.widget_layout
    ).also { views ->
        updateWWContent(views)
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
}

fun updateWWContent(views: RemoteViews) {
    views.setTextViewText(R.id.wwtext, SimpleDateFormat("hh:mm:ss", Locale.getDefault()).format(Date()))
}
