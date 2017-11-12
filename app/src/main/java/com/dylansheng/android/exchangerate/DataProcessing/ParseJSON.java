package com.dylansheng.android.exchangerate.DataProcessing;

import com.dylansheng.android.exchangerate.Currency.Currency;

import org.json.JSONObject;

/**
 * Created by sheng on 2017-11-12.
 */

public class ParseJSON {
    public static Currency ParseFixerIOReferenceRate (JSONObject rawJSON) throws Exception{
        Currency currency = new Currency();
        currency.Base = rawJSON.getString("base");
        currency.Rates.AUD = rawJSON.getJSONObject("rates").getDouble("AUD");
        return currency;
    }
}
