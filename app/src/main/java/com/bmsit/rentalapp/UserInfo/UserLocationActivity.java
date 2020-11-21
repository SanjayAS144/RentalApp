package com.bmsit.rentalapp.UserInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bmsit.rentalapp.R;

public class UserLocationActivity extends AppCompatActivity {

    String mapBoxApi = "pk.eyJ1Ijoic2FuamF5NDMwIiwiYSI6ImNraHJmZ3B1YTFmbnkzMms2czRuOGliNXEifQ.H4b77DL9jFTl2fGIkPdskQ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_location);
    }
}