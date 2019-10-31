package com.conradharrison.example.wwwidget

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.widget.RemoteViews
import android.app.PendingIntent
import android.content.Intent
import android.content.Context
import android.util.Log
import java.util.Arrays.asList

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Arrays
import java.util.Date

public class WWWidgetProvider : AppWidgetProvider() {

    var df: DateFormat = SimpleDateFormat("hh:mm:ss")

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        val N = appWidgetIds.size

        Log.i("WWWidget", "Updating widgets " + Arrays.asList(appWidgetIds))

        // Perform this loop procedure for each App Widget that belongs to this
        // provider
        for (i in 0 until N) {
            val appWidgetId = appWidgetIds[i]

            // Create an Intent to launch ExampleActivity
            val intent = Intent(context, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            val views = RemoteViews(context.getPackageName(), R.layout.wwwidget_layout)
            views.setOnClickPendingIntent(R.id.button, pendingIntent)

            // To update a label
            views.setTextViewText(R.id.widget1label, df.format(Date()))

            // Tell the AppWidgetManager to perform an update on the current app
            // widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}