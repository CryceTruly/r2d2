package com.crycetruly.r2d2.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Elia on 10/12/2017.
 */

public class UserPreferences {
    private static final String TAG = "UserPreferences";

    //------------------GETS THIS VALUE AS PASSED IN FROM THE LOCATION ACTIVITY--------------------------------//
    public static String userHome(Activity a) {
        SharedPreferences preferences = a.getSharedPreferences("user_locality", Context.MODE_PRIVATE);
        String locality = preferences.getString("locality", "");
        Log.d(TAG, "userHome: User is in " + locality);

        return locality;
    }

    public static String getUserSearchByPrefence(Context context) {
        String searchChoice = "";
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String choice = preferences.getString("search_key", "");
//        switch (choice){
//            case "Event Title":
//                searchChoice= "title";
//                break;
//            case "Pace Name":
//                searchChoice= "place";
//                break;
//            case "Event Date":
//                searchChoice= "date";
//                break;
//
//        }
//        Log.d(TAG, "getUserSearchByPrefence: "+searchChoice);
        Log.d(TAG, "getUserSearchByPrefence: Choice " + choice);
        return choice;


    }



    public static String getNoticationStatus(Context context) {
        String status = " ";
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        Boolean isnotificationson = preferences.getBoolean("notifications_new_message", false);

        if (isnotificationson) {
            status = "Notifications on";
        } else {
            status = "Notifications off";
        }
        Log.d(TAG, "getNoticationStatus: " + status);
        return status;

    }
}
