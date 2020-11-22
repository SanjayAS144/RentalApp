package com.bmsit.rentalapp.RentalItems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bmsit.rentalapp.R;
import com.google.android.material.button.MaterialButton;

public class ProductDescriptionActivity extends AppCompatActivity {

    MaterialButton interested;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);

        interested = findViewById(R.id.interested);

        interested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LessorActivity.class));
            }
        });
    }
}