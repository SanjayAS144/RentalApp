package com.bmsit.rentalapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bmsit.rentalapp.MainActivity;
import com.bmsit.rentalapp.Model.ProductDetailsClass;
import com.bmsit.rentalapp.R;
import com.bmsit.rentalapp.RentalItems.ProductDescriptionActivity;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    List<ProductDetailsClass> productlist;
    private Context context;

    public ProductAdapter(List<ProductDetailsClass> productlist, Context context) {
        this.productlist = productlist;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productlayout,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {

        ProductDetailsClass productDetailsClass = productlist.get(position);
        holder.imageView.setImageResource(productDetailsClass.getImage());
        holder.textView.setText(productDetailsClass.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              holder.itemView.getContext().startActivity(new Intent(context, ProductDescriptionActivity.class));

            }
        });

    }

    @Override
    public int getItemCount() {
        return productlist.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.productimage);
            textView = itemView.findViewById(R.id.productprice);
        }
    }
}
