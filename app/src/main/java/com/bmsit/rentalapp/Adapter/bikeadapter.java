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

public class bikeadapter extends RecyclerView.Adapter<bikeadapter.BikeViewHolder>{

    List<ProductDetailsClass> productlist;
    private Context context;

    public bikeadapter(List<ProductDetailsClass> productlist, Context context) {
        this.productlist = productlist;
        this.context = context;
    }
    @NonNull
    @Override
    public BikeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bikelayout,parent,false);
        return new BikeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BikeViewHolder holder, int position) {

        ProductDetailsClass productDetailsClass = productlist.get(position);
        holder.imageView.setImageResource(productDetailsClass.getImage());
        holder.textView.setText(productDetailsClass.getName());
        holder.price.setText(productDetailsClass.getPrice());
    }

    @Override
    public int getItemCount() {
        return productlist.size();
    }

    public class BikeViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,price;
        public BikeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.productimage);
            textView = itemView.findViewById(R.id.productname);
            price = itemView.findViewById(R.id.productprice);
        }
    }
}
