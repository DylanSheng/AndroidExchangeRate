package com.dylansheng.android.exchangerate.DataProcessing;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by sheng on 2017-11-11.
 */

public class FixerIO {
    public static String GetReferenceRates(String url) throws Exception {
        String content = null;
        URLConnection connection = null;
        try {
            connection =  new URL(url).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }

        return content;
    }
}
