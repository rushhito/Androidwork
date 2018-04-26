package com.example.rush.preferecefragmenttest;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class FragmentPreferences extends PreferenceFragment {
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

}
