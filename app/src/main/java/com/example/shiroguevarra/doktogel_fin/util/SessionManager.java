package com.example.shiroguevarra.doktogel_fin.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by shiro.guevarra on 5/8/2017.
 */

public class SessionManager {

    private SharedPreferences preferences;

    public SessionManager(Context context) {
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void set(String name, String value) {
        this.preferences.edit().putString(name, value);
    }

    public String get(String name) {
        return this.preferences.getString(name, null);
    }
}
