package com.example.janhavi.reactsense;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int[] percentage=new int[7];

    private String emotion[] ={"Happy","Sad","Surprised","Angry","Neutral","Disgust","Fear"};

    private boolean isFirebaseSelected;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupPieChart();
        connectFirebase();

        Button button=(Button) findViewById(R.id.dataButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment=new LineGraph();
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainActivity,fragment);

                fragmentTransaction.commit();

            }
        });


    }
    private int key;
    private int value;

    private void connectFirebase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reference = database.getReference("/CompanyName");
        reference.child("/videoName/").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
             key=Integer.parseInt(dataSnapshot.getKey());
             value=(int) dataSnapshot.getValue();
             percentage[key]=value;

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void setupPieChart(){

        List<PieEntry> pieEntries=new ArrayList<>();
        for(int i=0; i<percentage.length;i++)
        {
            pieEntries.add(new PieEntry(percentage[i],emotion[i]));

        }

        PieDataSet pieDataSet=new PieDataSet(pieEntries,"Emotion");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData=new PieData(pieDataSet);

        PieChart pieChart= (PieChart) findViewById(R.id.pieChart);
        pieChart.setData(pieData);
        pieData.setValueTextSize(10f);
        pieChart.animateX(1000);
        pieChart.invalidate();



    }

}
