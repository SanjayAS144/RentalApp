package com.bmsit.rentalapp.UserInfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bmsit.rentalapp.MainActivity;
import com.bmsit.rentalapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UserInfoActivity extends AppCompatActivity {

    EditText userName,userMail;
    TextView userPhone;
    FirebaseAuth mAuth;
    RelativeLayout connect;
    String user_name,user_mail,user_phone,user_id;
    DatabaseReference RootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        userName = findViewById(R.id.user_name_text);
        userMail = findViewById(R.id.user_mail_text);
        userPhone = findViewById(R.id.user_phone);
        connect =findViewById(R.id.connect);
        mAuth = FirebaseAuth.getInstance();
        user_phone = mAuth.getCurrentUser().getPhoneNumber();
        userPhone.setText(user_phone);
        user_id = mAuth.getCurrentUser().getUid();
        RootRef = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name = userName.getText().toString().trim();
                user_mail = userMail.getText().toString().trim();

                if(TextUtils.isEmpty(user_name)){
                    Toast.makeText(UserInfoActivity.this, "Please enter a valid name", Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(user_mail)){
                    Toast.makeText(UserInfoActivity.this, "Please enter a valid email Id", Toast.LENGTH_SHORT).show();
                }else{

                    HashMap<String, Object> user_map = new HashMap<>();
                    user_map.put("user_name", user_name);
                    user_map.put("email", user_mail);
                    user_map.put("phone", user_phone);

                    RootRef.setValue(user_map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }

                        }
                    });


                }

            }
        });
    }
}