package com.conradharrison.example.wwwidget

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class WWWidgetPreferenceFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(
            R.xml.widget_settings
            , rootKey
        )
    }
}
