package com.example.kumarshashwat.Any_Do;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Kumar Shashwat on 28-Jul-16.
 */
public class MyPreferences {
    private  static  final String MY_PREFERENCES="my_preferences";
    public static boolean isFirst(Context context){
        final SharedPreferences reader=context.getSharedPreferences(MY_PREFERENCES,Context.MODE_PRIVATE);
        final boolean first=reader.getBoolean("is_first",true);
        if(first){
            final SharedPreferences.Editor editor=reader.edit();
            editor.putBoolean("is_first",false);
            editor.apply();
        }
        return first;
    }
}
