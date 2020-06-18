package com.waldener.musicdog.ui.setting

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.waldener.musicdog.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}