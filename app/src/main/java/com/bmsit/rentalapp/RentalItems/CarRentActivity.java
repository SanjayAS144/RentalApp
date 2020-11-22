package com.bmsit.rentalapp.RentalItems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bmsit.rentalapp.Adapter.ProductAdapter;
import com.bmsit.rentalapp.Adapter.carAdapter;
import com.bmsit.rentalapp.Model.ProductDetailsClass;
import com.bmsit.rentalapp.R;

import java.util.ArrayList;
import java.util.List;

public class CarRentActivity extends AppCompatActivity {
    RecyclerView houseview;
    List<ProductDetailsClass> newproductlist;
    carAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_rent);

        houseview = findViewById(R.id.houseview);
        houseview.setLayoutManager(new LinearLayoutManager(this));
        Additemtonewproductlist();
        adapter = new carAdapter(newproductlist,this);
        houseview.setAdapter(adapter);

    }
    public void Additemtonewproductlist() {
        newproductlist = new ArrayList<>();
        newproductlist.add(new ProductDetailsClass(R.drawable.carimage5, "25000 Rs /","Lexus ES"));
        newproductlist.add(new ProductDetailsClass(R.drawable.carimage6, "20000 Rs /","Audi"));
        newproductlist.add(new ProductDetailsClass(R.drawable.carimage7, "30000 Rs /","Hyundai"));
        newproductlist.add(new ProductDetailsClass(R.drawable.carimage8, "40000 Rs /","Hyundai Tucson "));
        newproductlist.add(new ProductDetailsClass(R.drawable.carimage9, "50000 Rs /","Creta"));


    }
}