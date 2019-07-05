package com.stupid.dalamsyah.activity.anggit;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {

    static final String USERNAME = "USERNAME";
    static final String STATUS_USER = "STATUS_USER";

    private static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setUsername(Context context, String username){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(USERNAME, username);
        editor.apply();
    }

    public static String getUsername(Context context){
        return getSharedPreference(context).getString(USERNAME,"");
    }

    public static void setStatusUser(Context context, String statusUser){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(STATUS_USER, statusUser);
        editor.apply();
    }

    public static String getStatusUser(Context context){
        return getSharedPreference(context).getString(STATUS_USER,"");
    }

}
