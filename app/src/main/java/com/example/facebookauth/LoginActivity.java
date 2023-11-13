package com.example.facebookauth;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private TextView textViewDisplayName;
    private TextView textViewEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textViewDisplayName = findViewById(R.id.textViewDisplayName);
        textViewEmail = findViewById(R.id.textViewEmail);

        // Retrieve user data from FirebaseAuth
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            String displayName = user.getDisplayName();
            String email = user.getEmail();

            // Update UI with user data
            if (displayName != null && !displayName.isEmpty()) {
                textViewDisplayName.setText("Display Name: " + displayName);
            } else {
                textViewDisplayName.setText("Display Name: Not available");
            }

            if (email != null && !email.isEmpty()) {
                textViewEmail.setText("Email: " + email);
            } else {
                textViewEmail.setText("Email: Not available");
            }
        }
    }
}
