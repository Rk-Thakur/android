package com.example.android.basketballcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int scorea=0;
    int scoreb=0;
    public void threea(View view){
        scorea= scorea +3;
        displaya(scorea);
    }
    public void twoa(View view){
        scorea= scorea +2;
        displaya(scorea);
    }
    public void onea(View view){
        scorea= scorea + 1;
        displaya(scorea);
    }
    public void displaya(int number){
        TextView display = (TextView) findViewById(R.id.scorea);
        display.setText(" "+number);
    }
//for team b
    public void threeb(View view){
        scoreb= scoreb +3;
        displayb(scoreb);
    }
    public void twob(View view){
        scoreb= scoreb +2;
        displayb(scoreb);
    }
    public void oneb(View view){
        scoreb= scoreb +1;
        displayb(scoreb);
    }
    public void displayb(int number){
        TextView display = (TextView) findViewById(R.id.scoreb);
        display.setText(" "+number);
    }
    public void reset(View view){
        scorea=0;
        scoreb=0;
        displaya(scorea);
        displayb(scoreb);
        if(scorea == scoreb){
            Toast.makeText(this,"DRAW",Toast.LENGTH_SHORT).show();
        }else if(scorea > scoreb){
            Toast.makeText(this,"Team A WINNER!!",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Team B WINNER!!",Toast.LENGTH_SHORT).show();
        }
    }
}