package com.example.android.quotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.android.quotesapp.Adapter.quotesadapter;
import com.example.android.quotesapp.Model.quoteslist;
import com.example.android.quotesapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    RecyclerView r1 ;
    quotesadapter qoad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        List<quoteslist> quote = new ArrayList<>();
        quote.add(new quoteslist(R.drawable.one,"One"));
        quote.add(new quoteslist(R.drawable.two,"Two"));
        quote.add(new quoteslist(R.drawable.three,"Three"));
        quote.add(new quoteslist(R.drawable.four,"Four"));
        quote.add(new quoteslist(R.drawable.five,"Five"));
        quote.add(new quoteslist(R.drawable.six,"Six"));
        quote.add(new quoteslist(R.drawable.seven,"Seven"));
        quote.add(new quoteslist(R.drawable.eight,"Eight"));
        quote.add(new quoteslist(R.drawable.one,"One"));
        quote.add(new quoteslist(R.drawable.two,"Two"));

        qoad = new quotesadapter(quote,this);
        r1 = findViewById(R.id.recyclerview);
        r1.setAdapter(qoad);
        r1.setLayoutManager(new GridLayoutManager(this,2));



    }
}