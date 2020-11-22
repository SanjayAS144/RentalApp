package com.bmsit.rentalapp.RentalItems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bmsit.rentalapp.Adapter.bikeadapter;
import com.bmsit.rentalapp.Adapter.carAdapter;
import com.bmsit.rentalapp.Model.ProductDetailsClass;
import com.bmsit.rentalapp.R;

import java.util.ArrayList;
import java.util.List;

public class BikeRentActivity extends AppCompatActivity {

    RecyclerView houseview;
    List<ProductDetailsClass> newproductlist;
    bikeadapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_rent);

        houseview = findViewById(R.id.houseview);
        houseview.setLayoutManager(new LinearLayoutManager(this));
        Additemtonewproductlist();
        adapter = new bikeadapter(newproductlist,this);
        houseview.setAdapter(adapter);
    }

    public void Additemtonewproductlist() {
        newproductlist = new ArrayList<>();
        newproductlist.add(new ProductDetailsClass(R.drawable.bikeimage5, "25000 Rs /","Lexus ES"));
        newproductlist.add(new ProductDetailsClass(R.drawable.bikeimage6, "20000 Rs /","Audi"));
        newproductlist.add(new ProductDetailsClass(R.drawable.bikeimage7, "30000 Rs /","Hyundai"));
        newproductlist.add(new ProductDetailsClass(R.drawable.bikeimage8, "40000 Rs /","Hyundai Tucson "));
        newproductlist.add(new ProductDetailsClass(R.drawable.bikeimage9, "50000 Rs /","Creta"));


    }
}