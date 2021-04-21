package com.example.saver10;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PirmoKartoTIkrinimas {


        /**
         * Sets the boolean preference value
         *
         * @param context the current context
         * @param key     the preference key
         * @param value   the value to be set
         */
        public void setBooleanPreferenceValue(Context context, String key, boolean value) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            sp.edit().putBoolean(key, value).apply();
        }
        /**
         * Get the boolean preference value from the SharedPreference
         *
         * @param context the current context
         * @param key     the preference key
         * @return the the preference value
         */
        public  boolean getBooleanPreferenceValue(Context context, String key) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            return sp.getBoolean(key, false);
        }

    }

