package com.example.fileprocessing2

import android.os.Bundle
import androidx.preference.EditTextPreference
import androidx.preference.PreferenceFragmentCompat

class MySettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        val sigPreference:EditTextPreference? = findPreference("signature")
        sigPreference?.isVisible = true
        sigPreference?.title = "Title changed"
    }
}