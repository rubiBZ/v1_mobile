package com.example.Dbtime_Mobile;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText   userFirstNameEdt, userLastNameEdt,passwordEdt,confirmPwdEdt,email,phone,id;
    private TextView loginTV;
    private Button registerBtn;
    private ProgressBar loadingPB;
    private DatabaseReference mDatabase;
    public String TAG = "Rubi";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userFirstNameEdt = findViewById(R.id.FirstName);
        userLastNameEdt = findViewById(R.id.LastName);
        passwordEdt = findViewById(R.id.Password);
        confirmPwdEdt = findViewById(R.id.ConfirmPassword);
        email = findViewById(R.id.Email);
        phone = findViewById(R.id.Phone);
        id = findViewById(R.id.UserId);
        registerBtn = findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();
        loadingPB = findViewById(R.id.progressBar);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userFirstName = userFirstNameEdt.getText().toString();
                String userLastName = userLastNameEdt.getText().toString();
                String password = passwordEdt.getText().toString();
                String confirmPassword = confirmPwdEdt.getText().toString();
                String userEmail = email.getText().toString();
                String userPhone = phone.getText().toString();
                String userId = id.getText().toString();
                Boolean full = true;
                if( TextUtils.isEmpty(userFirstNameEdt.getText())){
                    Log.d(TAG,"#4");
                    userFirstNameEdt.setError( "???? ???????????? ???? ????????" );
                    full = false;}
                if( TextUtils.isEmpty(userLastNameEdt.getText())){
                    userLastNameEdt.setError( "???? ???????????? ???? ??????????" );
                    full = false;}
                if( TextUtils.isEmpty(passwordEdt.getText())){
                    passwordEdt.setError( "???? ???????????? ??????????" );
                    full = false;}
                if( TextUtils.isEmpty(email.getText())){
                    email.setError( "???? ???????????? ?????????? ????????????" );
                    full = false;}
                if( TextUtils.isEmpty(confirmPwdEdt.getText())){
                    confirmPwdEdt.setError( "???? ???????? ??????????" );
                    full = false;}
                else{
                    if(!password.equals(confirmPassword)){
                        confirmPwdEdt.setError( "?????????? ???? ??????" );
                        full = false;}
                }
                if( TextUtils.isEmpty(phone.getText())){
                    phone.setError( "???? ???????????? ??????????" );
                    full = false;}
                if( TextUtils.isEmpty(id.getText())){
                    id.setError( "???? ???????????? ?????????? ????????" );
                    full = false;}
                if(full ==true) {

                writeNewUser(userFirstName,userLastName,password,
                        userEmail,userPhone,userId);
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                 }
            }
        });
    }

    public void writeNewUser(String userFirstName,String userLastName,String password,
                             String userEmail,String userPhone,String userId) {
        loadingPB.setVisibility(View.VISIBLE);
        Map<String, Object> user = new HashMap<>();
        user.put("first", userFirstName);
        user.put("last", userLastName);
        user.put("pw", password);
        user.put("phone", userPhone);
        user.put("mail", userEmail);

        //=========
        mAuth.createUserWithEmailAndPassword(userEmail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                // on below line we are checking if the task is success or not.
                if (task.isSuccessful()) {

                    // in on success method we are hiding our progress bar and opening a login activity.
                    loadingPB.setVisibility(View.GONE);
                    Toast.makeText(RegisterActivity.this, "User Registered..", Toast.LENGTH_LONG).show();
                   // Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                  //  startActivity(i);
                    finish();
                } else {

                    // in else condition we are displaying a failure toast message.
                    loadingPB.setVisibility(View.GONE);
                    Toast.makeText(RegisterActivity.this, "Fail to register user..", Toast.LENGTH_LONG).show();
                }
            }
        });

        //========

        db.collection("users").document(userId)
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }

    @IgnoreExtraProperties
    public static class User {

        public String userFirstName;
        public String userLastName;
        public String password;
        public String userEmail;
        public String userPhone;
        public String userId;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(com.example.login.HomeActivity.User.class)
        }

        public User(String userFirstName,String userLastName,String password,
                    String userEmail,String userPhone,String userId) {
            this.userFirstName = userFirstName;
            this.userLastName = userLastName;
            this.password = password;
            this.userEmail = userEmail;
            this.userPhone = userPhone;
            this.userId = userId;
        }

    }
}