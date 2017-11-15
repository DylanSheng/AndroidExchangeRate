package com.dylansheng.android.exchangerate.Functions;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.dylansheng.android.exchangerate.Activity.MainActivity;
import com.dylansheng.android.exchangerate.Currency.Currency;
import com.dylansheng.android.exchangerate.CustomizedAdapter.ExchangeRateVerticalAdaptor;
import com.dylansheng.android.exchangerate.DataProcessing.FixerIO;
import com.dylansheng.android.exchangerate.DataProcessing.ParseJSON;
import com.dylansheng.android.exchangerate.Decoration.DividerItemDecoration;
import com.dylansheng.android.exchangerate.Listener.ClickListener;
import com.dylansheng.android.exchangerate.Listener.RecyclerTouchListener;
import com.dylansheng.android.exchangerate.R;

import org.json.JSONObject;

/**
 * Created by sheng on 2017-11-15.
 */

public class ExchangeRateLayout {
    public static void SetExchangeRateLayout(Activity activity){
        String[] data = {"AUD","BGN","BRL","CAD","CHF","CNY","CZK","DKK","GBP","HKD","HRK","HUF","IDR","ILS","INR","JPY","KRW","MXN","MYR","NOK","NZD","PHP","PLN","RON","RUB","SEK","SGD","THB","TRY","USD","ZAR" };

        ExchangeRateVerticalAdaptor adapter1 = new ExchangeRateVerticalAdaptor(data);
        RecyclerView recyclerView1 = (RecyclerView) activity.findViewById(R.id.ex_rate_scroll_grid_control_1);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(activity.getApplicationContext());
        recyclerView1.setLayoutManager(mLayoutManager1);
        recyclerView1.setAdapter(adapter1);
        recyclerView1.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.VERTICAL, 16));
        recyclerView1.addOnItemTouchListener(new RecyclerTouchListener(activity.getApplicationContext(), recyclerView1, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                //Toast.makeText(activity.getApplicationContext(), " is selected!", Toast.LENGTH_SHORT).show();
            }
        }));

        ExchangeRateVerticalAdaptor adapter2 = new ExchangeRateVerticalAdaptor(data);
        RecyclerView recyclerView2 = (RecyclerView) activity.findViewById(R.id.ex_rate_scroll_grid_control_2);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(activity.getApplicationContext());
        recyclerView2.setLayoutManager(mLayoutManager2);
        recyclerView2.setAdapter(adapter2);

        ExchangeRateVerticalAdaptor adapter3 = new ExchangeRateVerticalAdaptor(data);
        RecyclerView recyclerView3 = (RecyclerView) activity.findViewById(R.id.ex_rate_scroll_grid_control_3);
        RecyclerView.LayoutManager mLayoutManager3 = new LinearLayoutManager(activity.getApplicationContext());
        recyclerView3.setLayoutManager(mLayoutManager3);
        recyclerView3.setAdapter(adapter3);

        ExchangeRateVerticalAdaptor adapter4 = new ExchangeRateVerticalAdaptor(data);
        RecyclerView recyclerView4 = (RecyclerView) activity.findViewById(R.id.ex_rate_scroll_grid_control_4);
        RecyclerView.LayoutManager mLayoutManager4 = new LinearLayoutManager(activity.getApplicationContext());
        recyclerView4.setLayoutManager(mLayoutManager4);
        recyclerView4.setAdapter(adapter4);
    }

    public class MyThread implements Runnable {
        public void run() {
            try {
                String response = FixerIO.GetReferenceRates("https://api.fixer.io/latest");
                JSONObject obj = new JSONObject(response);
                Currency currency = ParseJSON.ParseFixerIOReferenceRate(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
