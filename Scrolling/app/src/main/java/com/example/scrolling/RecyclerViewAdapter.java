package com.example.scrolling;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        switch (position){
            case 0:
                holder.textView.setText("1");
                break;
            case 1:
                holder.textView.setText("1");
                break;
            case 2:
                holder.textView.setText("1");
                break;
            case 3:
                holder.textView.setText("1");

                break;
            case 4:
                holder.textView.setText("1");
                break;
            case 5:
                holder.textView.setText("1");
                break;

            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.item);
        }
    }
}
