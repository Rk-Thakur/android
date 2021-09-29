package com.example.android.quotesapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.quotesapp.Model.quoteslist;
import com.example.android.quotesapp.R;

import java.util.List;

public class quotesadapter extends RecyclerView.Adapter<quotesadapter.quotesholder> {

    List<quoteslist> quotes;
    Context  context;

    public quotesadapter(List<quoteslist> quotes, Context context) {
        this.quotes = quotes;
        this.context = context;
    }

    @Override
    public quotesadapter.quotesholder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater quotesflate = LayoutInflater.from(context);
        View ownquotes = quotesflate.inflate(R.layout.quotelists,parent,false);

        return new quotesholder(ownquotes);
    }

    @Override
    public void onBindViewHolder( quotesadapter.quotesholder holder, int position) {
        quoteslist model = quotes.get(position);
        holder.firstimage.setImageResource(model.getImage());
        holder.firsttext.setText(model.getText());
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public class quotesholder extends RecyclerView.ViewHolder {
        ImageView firstimage;
        TextView firsttext;
        public quotesholder( View itemView) {
            super(itemView);
            firstimage = itemView.findViewById(R.id.firstimage);
            firsttext =itemView.findViewById(R.id.firsttext);
        }
    }
}
