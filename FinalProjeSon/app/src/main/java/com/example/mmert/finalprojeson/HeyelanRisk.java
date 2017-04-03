package com.example.mmert.finalprojeson;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.PercentFormatter;

import java.util.ArrayList;

public class HeyelanRisk extends AppCompatActivity {
    EditText tasinanVeri;
    private RelativeLayout heyelanLayout;
    private PieChart mChart;
    private float[] yData = {5,10,15,30,40};
    private String[] xData = {"Oldukça Hafif Heyelan Riski","Orta Şiddetli Heyelan Riski","Kuvvetli Heyelan Riski","Yoğun Heyelan Riski","Çok Yoğun Heyelan Riski"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heyelan_risk);

        tasinanVeri = (EditText)findViewById(R.id.edt_text);

        tasinanVeri.setText(getIntent().getExtras().getString("veri"));

        double num = Double.parseDouble(tasinanVeri.getText().toString());

        heyelanLayout = (RelativeLayout)findViewById(R.id.heyelanLayout);
        mChart = new PieChart(this);

        //heyelanLayout'a pie chart'ı ekleme
        heyelanLayout.addView(mChart);
        heyelanLayout.setBackgroundColor(Color.LTGRAY);

        mChart.setUsePercentValues(true);


        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColorTransparent(true);
        mChart.setHoleRadius(7);
        mChart.setTransparentCircleRadius(10);

        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);

        //pie chartın herhangi bir dilimi seçildiğinde olacaklar
        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {
                if (entry == null)
                    return;
                Toast.makeText(HeyelanRisk.this, xData[entry.getXIndex()] + "=" + entry.getVal() + "%", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        addData();

        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);


    }

    private void addData() {
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();
        for(int i=0; i<yData.length; i++)
            yVals1.add(new Entry(yData[i],i));
        ArrayList<String> xVals = new ArrayList<String>();
        for(int i=0; i<xData.length; i++)
            xVals.add(xData[i]);

        PieDataSet dataSet = new PieDataSet(yVals1, "Eğim Oranları");
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);

        ArrayList<Integer> colors = new ArrayList<Integer>();


        for(int c : ColorTemplate.VORDIPLOM_COLORS)
        colors.add(c);

        for(int c : ColorTemplate.JOYFUL_COLORS)
        colors.add(c);

        for(int c : ColorTemplate.COLORFUL_COLORS)
        colors.add(c);

        for(int c : ColorTemplate.LIBERTY_COLORS)
        colors.add(c);

        for(int c : ColorTemplate.PASTEL_COLORS)
        colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);

        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(13f);
        data.setValueTextColor(Color.GRAY);

        mChart.setData(data);
        mChart.highlightValues(null);

        mChart.invalidate();

    }

}



 /* if(num>=12)
            Toast.makeText(HeyelanRisk.this, "Çok Dik Eğim", Toast.LENGTH_LONG).show();
        else if(num>=8)
            Toast.makeText(HeyelanRisk.this, "Dik Eğim", Toast.LENGTH_LONG).show();
        else if(num>=5)
            Toast.makeText(HeyelanRisk.this, "Kuvvetli Eğim", Toast.LENGTH_LONG).show();
        else if(num>=3)
            Toast.makeText(HeyelanRisk.this, "Orta Eğim", Toast.LENGTH_LONG).show();
        else if (num>=1)
            Toast.makeText(HeyelanRisk.this, "Oldukça Eğim", Toast.LENGTH_LONG).show();
        else if (num>=0)
            Toast.makeText(HeyelanRisk.this, "Oldukça Düz Eğim", Toast.LENGTH_LONG).show();*/