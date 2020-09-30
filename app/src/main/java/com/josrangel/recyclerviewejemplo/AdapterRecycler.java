package com.josrangel.recyclerviewejemplo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.RecViewHolder> {

    Context context;
    String[] titulos;


    AdapterRecycler(Context context, String [] titulos){
        this.context = context;
        this.titulos = titulos;
    }

    @Override
    public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);

        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecViewHolder holder, int position) {
        String texto = titulos[position];
        TextView textView = holder.itemView.findViewById(R.id.textView);
        textView.setText(texto);
    }

    @Override
    public int getItemCount() {
        return titulos.length;
    }

    class RecViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public RecViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
