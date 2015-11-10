package com.bananastech.laporin.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bananastech.laporin.R;
import com.bananastech.laporin.activities.ReportIdentityActivity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by Haydar Ali Ismail on 24-Oct-15.
 */
public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        FloatingActionButton fabReport = (FloatingActionButton) view.findViewById(R.id.fragment_home_fab_report);
        fabReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ReportIdentityActivity.class);
                startActivity(intent);
            }
        });
        initShopChart(view);
        initBankChart(view);
        return view;
    }

    private void initShopChart(View view) {
        TextView tvShop = (TextView) view.findViewById(R.id.fragment_home_tv_pc_shop_description);
        tvShop.setText("Persentase penipuan berdasarkan Online Shop");
        String[] xData = { "Kaskus", "Facebook", "Lazada", "Blibli", "Lain-lain"};
        float[] yData = { 5, 10, 15, 30, 40 };
        PieChart pcShop = (PieChart) view.findViewById(R.id.fragment_home_pc_shop);
        pcShop.setHorizontalScrollBarEnabled(false);
        pcShop.setVerticalScrollBarEnabled(false);
        pcShop.setUsePercentValues(true);
        pcShop.setDescription("");
        pcShop.setDrawHoleEnabled(false);
        pcShop.setHoleColorTransparent(false);
        pcShop.setRotationEnabled(false);
        ArrayList<Entry> yVal = new ArrayList<Entry>();
        for (int i = 0; i < yData.length; i++) {
            yVal.add(new Entry(yData[i], i));
        }
        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < xData.length; i++) {
            xVals.add(xData[i]);
        }
        PieDataSet pds = new PieDataSet(yVal, "Online Shop");
        pds.setSliceSpace(1);
        pds.setSelectionShift(1);
        Legend lShop = pcShop.getLegend();
        lShop.setEnabled(false);
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);
        colors.add(ColorTemplate.getHoloBlue());
        pds.setColors(colors);
        PieData data = new PieData(xVals, pds);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.GRAY);
        pcShop.setData(data);
        pcShop.highlightValues(null);
        pcShop.invalidate();
    }

    private void initBankChart(View view) {
        TextView tvBank = (TextView) view.findViewById(R.id.fragment_home_tv_pc_bank_description);
        tvBank.setText("Persentase penipuan berdasarkan akun bank penipu");
        String[] xData = { "BCA", "Mandiri", "BNI", "CIMB Niaga", "Lain-lain"};
        float[] yData = { 15, 15, 20, 30, 30 };
        PieChart pcBank = (PieChart) view.findViewById(R.id.fragment_home_pc_bank);
        pcBank.setUsePercentValues(true);
        pcBank.setDescription("");
        pcBank.setDrawHoleEnabled(false);
        pcBank.setHoleColorTransparent(false);
        pcBank.setRotationEnabled(false);
        ArrayList<Entry> yVal = new ArrayList<Entry>();
        for (int i = 0; i < yData.length; i++) {
            yVal.add(new Entry(yData[i], i));
        }
        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < xData.length; i++) {
            xVals.add(xData[i]);
        }
        PieDataSet pds = new PieDataSet(yVal, "Bank Account");
        pds.setSliceSpace(1);
        pds.setSelectionShift(1);
        Legend lBank = pcBank.getLegend();
        lBank.setEnabled(false);
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);
        colors.add(ColorTemplate.getHoloBlue());
        pds.setColors(colors);
        PieData data = new PieData(xVals, pds);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.GRAY);
        pcBank.setData(data);
        pcBank.highlightValues(null);
        pcBank.invalidate();
    }
}
