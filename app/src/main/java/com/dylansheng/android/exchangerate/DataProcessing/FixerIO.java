package com.dylansheng.android.exchangerate.DataProcessing;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by sheng on 2017-11-11.
 */

public class FixerIO {
    public static String GetReferenceRates(String url) throws Exception {
        URL Url = new URL(url);
        URLConnection yc = Url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        String str = new String();
        while ((inputLine = in.readLine()) != null)
        {
            str = str.concat(inputLine);
        }
        JSONObject obj = new JSONObject(str);


        return str;
    }
}
