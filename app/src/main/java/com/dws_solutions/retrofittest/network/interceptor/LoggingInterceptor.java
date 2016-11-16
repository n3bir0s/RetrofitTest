package com.dws_solutions.retrofittest.network.interceptor;

import android.os.Environment;
import android.util.Log;

import com.dws_solutions.retrofittest.AppConfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Project: RetrofitTest
 *
 * @package: com.dws_solutions.retrofittest.network.interceptor
 * <p>
 * Created by Sven on 16.11.2016..
 * DwS-Solutions.com - All rights reserved  - Copyright (c) 2016
 */
public class LoggingInterceptor implements Interceptor {

    private final static String mLogFilename = "app_network.log";
    private final static String TAG = "app_Network";

    private static final Charset UTF8 = Charset.forName("UTF-8");


    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        long t1 = System.nanoTime();
        Log.d("Retrofit",String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()));

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();
        Log.d("Retrofit", String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        // TODO Log request and response to file
        ResponseBody responseBody = response.body();

        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();
        Charset charset = UTF8;

        String logMessage = "------------------------------------------------------------------\n";

        if(AppConfig.LOG_NETWORK_FULL) {
            logMessage += "Request: " + String.format("Sending request %s on %s%n%s \n",
                    request.url(), chain.connection(), request.headers());

            logMessage += "Response: " + String.format("Received response for %s in %.1fms%n%s \n",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers());

        } else {
            logMessage += "Request:  " + request.url() +"\n";
            logMessage += "Response: " + buffer.clone().readString(charset) + "\n";
        }


        if(AppConfig.LOG_NETWORK){
            logToFile(logMessage);
        }


        return response;
    }

    public static void logToFile(String logMessage) {
        try {
            File logFile = new File(Environment.getExternalStorageDirectory(),  mLogFilename);
            //File logFile = new File(Environment.getExternalStorageDirectory() + "/NetLog/",  mLogFilename);
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.write(String.format("%1s [%2s]:%3s\r\n", new Object[]{getDateTimeStamp(), TAG, logMessage}));
            writer.close();
        } catch (IOException e) {
            Log.e(TAG, "Unable to log exception to file." + e.toString());
        }
    }

    private static String getDateTimeStamp() {
        return DateFormat.getDateTimeInstance(3, 3, Locale.US).format(Calendar.getInstance().getTime());
    }

}
