package com.example.android.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMIactivity extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;

    TextView nbmidisplay,mbmicateggory,mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float  intbmi;
    String height,weight;
    float intheight ,intweight;

    RelativeLayout mbackground;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_iactivity);


        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color = \"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent = getIntent();
        nbmidisplay=findViewById(R.id.bmidisplay);
        mbmicateggory = findViewById(R.id.bmicategory);
         mgender = findViewById(R.id.genderdisplay);
         mbackground = findViewById(R.id.contentlayout);
         mimageview = findViewById(R.id.imageview);
         mrecalculatebmi = findViewById(R.id.recalculatebmi);

        height= intent.getStringExtra("height");
        weight  = intent.getStringExtra("weight");
        intheight = Float.parseFloat(height);
        intweight  = Float.parseFloat(weight);

        intheight = intheight/100;
        intbmi = intweight /(intheight * intheight);

        mbmi = Float.toString(intbmi);


        if(intbmi < 16){
            mbmicateggory.setText("Severe Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        }
        else if(intbmi < 16.9 && intbmi > 16 ){
            mbmicateggory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi < 18.4 && intbmi > 17 ){
            mbmicateggory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi < 25 && intbmi > 18.4 ){
            mbmicateggory.setText("Normal");
//            mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.ok);
        }
        else if(intbmi < 29.4 && intbmi > 25 ){
            mbmicateggory.setText("Over Weight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else {
            mbmicateggory.setText("Obese Class I ");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }

        mgender.setText(intent.getStringExtra("gender"));
        nbmidisplay.setText(mbmi);



        getSupportActionBar().hide();
        mrecalculatebmi= findViewById(R.id.recalculatebmi);
        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BMIactivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }



}