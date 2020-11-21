package com.bmsit.rentalapp.StartUpPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bmsit.rentalapp.MainActivity;
import com.bmsit.rentalapp.R;
import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    // Page 1
    private EditText userNumber;
    private LinearLayout phoneNoRelativeLayout;
    ImageView backbtn;
    private MaterialButton nextPage,verifyBtn;

    // Page 2
    private PinView otpPinView;
    private TextView resendBtn;
    private int RC_SIGN_IN = 1;

    private LinearLayout otpPageRelativeLayout;
    CountryCodePicker ccp;


    ImageView googleSignIn;
    public int counter;
    private String verificationCodeBySystem;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private FirebaseAuth mAuth;
    private String mVerificationId;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks;
    private String phoneNo;
    String countrycode="+91";
    String getno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNumber = findViewById(R.id.phone_no_input_edit_text);
        nextPage = findViewById(R.id.send_otp_button);
        phoneNoRelativeLayout = findViewById(R.id.InputLayout);
        otpPageRelativeLayout = findViewById(R.id.VerifyLayout);
        verifyBtn = findViewById(R.id.VerifyBtn);
        otpPinView = findViewById(R.id.pin_text);
        resendBtn = findViewById(R.id.didnt_get_otp_button);
        ccp = findViewById(R.id.ccp);
        mAuth = FirebaseAuth.getInstance();
        resendBtn.setEnabled(false);
        ccp.registerCarrierNumberEditText(userNumber);


        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                phoneNo = userNumber.getText().toString().trim();
                if(!phoneNo.isEmpty()){
                    phoneNoRelativeLayout.setVisibility(View.GONE);
                    otpPageRelativeLayout.setVisibility(View.VISIBLE);
                    getno = ccp.getFullNumberWithPlus().replace(" "," ");


                    callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

                        @Override
                        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                            signInWithPhoneAuthCredential(phoneAuthCredential);
                        }

                        @Override
                        public void onVerificationFailed(@NonNull FirebaseException e) {
                            Toast.makeText(LoginActivity.this, "Invalid Phone No.! Please enter correct Country Code", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken Token) {
                            mVerificationId = verificationId;
                            mResendToken = Token;
                            Toast.makeText(LoginActivity.this, "Verification Code has been sent ", Toast.LENGTH_SHORT).show();
                            counter = 0;
                            CountDownTimer();
                        }
                    };

                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            getno,         // Phone number to verify
                            60,                 // Timeout duration
                            TimeUnit.SECONDS,   // Unit of timeout
                            LoginActivity.this,               // Activity (for callback binding)
                            callbacks);      // OnVerificationStateChangedCallbacks
                }else{
                    Toast.makeText(LoginActivity.this, "Enter Valid Phone Number", Toast.LENGTH_SHORT).show();

                }

            }
        });

        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pin =otpPinView.getText().toString();

                if(TextUtils.isEmpty(pin)){
                    Toast.makeText(LoginActivity.this, "Please Input Verification Code first ", Toast.LENGTH_SHORT).show();
                }else{

                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, pin);
                    signInWithPhoneAuthCredential(credential);
                }
            }
        });

        resendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        getno,        // Phone number to verify
                        60,                 // Timeout duration
                        TimeUnit.SECONDS,   // Unit of timeout
                        LoginActivity.this,               // Activity (for callback binding)
                        callbacks);
            }
        });
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "You have been Logged In", Toast.LENGTH_SHORT).show();
                            sendUserToMainActivity();
                        }
                        else {
                            String message = Objects.requireNonNull(task.getException()).toString();
                            Toast.makeText(LoginActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void CountDownTimer() {
        final TextView countTime =  findViewById(R.id.Timer_otp);
        countTime.setVisibility(View.VISIBLE);
        new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String timeLeft = String.valueOf(counter) + " sec";
                countTime.setText(timeLeft);
                counter++;
            }
            @Override
            public void onFinish() {
                countTime.setVisibility(View.INVISIBLE);
                resendBtn.setEnabled(true);
            }
        }.start();
    }

    private void sendUserToMainActivity() {

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
        Toast.makeText(LoginActivity.this, "Phone is Successfully Verified", Toast.LENGTH_SHORT).show();
    }
}