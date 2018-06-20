package com.example.janhavi.reactsense;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;


public class LineGraph extends Fragment implements OnChartGestureListener, OnChartValueSelectedListener  {
    // TODO: Rename parameter arguments, choose names that match

    private float[] data={3,4,5,2,4,5,6};
    private float[] data2={4,3,4,5,6,5,1};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //setupLine();

        View view=inflater.inflate(R.layout.fragment_line_graph, container, false);

        GraphView graphView=(GraphView) view.findViewById(R.id.line);
        LineGraphSeries <DataPoint> series=new LineGraphSeries<>(getdatapoint());
        graphView.addSeries(series);

        return view;

    }



    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartLongPressed(MotionEvent me) {

    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {

    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {

    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    public DataPoint[] getdatapoint() {
        {
            DataPoint[] dataPoint=new DataPoint[]{
                    new DataPoint(data2[0],data[0]),
                    new DataPoint(data2[1],data[1]),
                    new DataPoint(data2[2],data[2]),
                    new DataPoint(data2[3],data[3]),
                    new DataPoint(data2[4],data[4]),
                    new DataPoint(data2[5],data[5]),
                    new DataPoint(data2[6],data[6]),
                };
            return (dataPoint);
        }

    }

}
