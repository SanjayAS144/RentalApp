package com.bmsit.rentalapp.RentalItems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bmsit.rentalapp.Adapter.ProductAdapter;
import com.bmsit.rentalapp.Model.ProductDetailsClass;
import com.bmsit.rentalapp.R;

import java.util.ArrayList;
import java.util.List;

public class HouseRentActivity extends AppCompatActivity {

    RecyclerView houseview;
    List<ProductDetailsClass> newproductlist;
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_rent);


        houseview = findViewById(R.id.houseview);
        houseview.setLayoutManager(new LinearLayoutManager(this));
        Additemtonewproductlist();
        adapter = new ProductAdapter(newproductlist,this);
        houseview.setAdapter(adapter);

    }

    public void Additemtonewproductlist() {
        newproductlist = new ArrayList<>();
        newproductlist.add(new ProductDetailsClass(R.drawable.houseimage7, "25000 Rs"));
        newproductlist.add(new ProductDetailsClass(R.drawable.houseimage6, "20000 Rs"));
        newproductlist.add(new ProductDetailsClass(R.drawable.houseimage5, "30000 Rs"));
        newproductlist.add(new ProductDetailsClass(R.drawable.houseimage8, "40000 Rs"));
        newproductlist.add(new ProductDetailsClass(R.drawable.houseimage9, "50000 Rs"));
        newproductlist.add(new ProductDetailsClass(R.drawable.houseimage10, "55000 Rs"));


    }
}