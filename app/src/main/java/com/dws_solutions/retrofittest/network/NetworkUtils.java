package com.dws_solutions.retrofittest.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Project: RetrofitTest
 *
 * @package: com.dws_solutions.retrofittest.network
 * <p>
 * Created by Sven on 14.11.2016..
 * DwS-Solutions.com - All rights reserved  - Copyright (c) 2016
 */
public class NetworkUtils {
    /**
     * Check netowork connection
     * Add <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" /> to
     * your Android Manifest file
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
