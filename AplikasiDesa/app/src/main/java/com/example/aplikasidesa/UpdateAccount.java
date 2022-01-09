package com.example.aplikasidesa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateAccount extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private String mSharedPrefFile = "account";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_account);
        TextView result = findViewById(R.id.greetings);

        mPreferences = getSharedPreferences(mSharedPrefFile,
                MODE_PRIVATE);

        result.setText(mPreferences.getString("username",null));
    }

    public void logout(View view) {
        Preferences.clearLoggedInUser(getBaseContext());
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
    @Override

    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }



}
