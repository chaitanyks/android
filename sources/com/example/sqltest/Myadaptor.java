package com.example.sqltest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class Myadaptor extends RecyclerView.Adapter<MyviewHolder> {
    Context context;
    int[] images;
    String[] names;

    public Myadaptor(Context ct, String[] s1, int[] img) {
        this.context = ct;
        this.names = s1;
        this.images = img;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyviewHolder(LayoutInflater.from(this.context).inflate(R.layout.recview, parent, false));
    }

    public void onBindViewHolder(MyviewHolder holder, int position) {
        holder.textView.setText(this.names[position]);
        holder.imageView.setImageResource(this.images[position]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.images.length;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public MyviewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.catName);
            this.imageView = (ImageView) itemView.findViewById(R.id.catImage);
        }
    }
}
