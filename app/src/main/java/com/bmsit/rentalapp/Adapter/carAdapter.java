package com.bmsit.rentalapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bmsit.rentalapp.Model.ProductDetailsClass;
import com.bmsit.rentalapp.R;

import java.util.List;

public class carAdapter extends RecyclerView.Adapter<carAdapter.CarViewHolder> {

    List<ProductDetailsClass> productlist;
    private Context context;

    public carAdapter(List<ProductDetailsClass> productlist, Context context) {
        this.productlist = productlist;
        this.context = context;
    }
    @NonNull
    @Override
    public carAdapter.CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carproductlayout,parent,false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull carAdapter.CarViewHolder holder, int position) {

        ProductDetailsClass productDetailsClass = productlist.get(position);
        holder.imageView.setImageResource(productDetailsClass.getImage());
        holder.textView.setText(productDetailsClass.getName());
        holder.price.setText(productDetailsClass.getPrice());

    }

    @Override
    public int getItemCount() {
        return productlist.size();
    }
    public class CarViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView,price;
        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.carimage);
            textView = itemView.findViewById(R.id.carproductname);
            price = itemView.findViewById(R.id.price);
        }
    }
}
