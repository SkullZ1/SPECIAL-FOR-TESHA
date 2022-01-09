package com.example.aplikasidesa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registrasi extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private String mSharedPrefFile = "account";
    EditText nama_lengkap, username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        nama_lengkap = findViewById(R.id.nama);
        username = findViewById(R.id.editusername);
        password = findViewById(R.id.editpassword);
    }
    public void SignUp(View view) {
        mPreferences = getSharedPreferences(mSharedPrefFile,
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString("nama", nama_lengkap.getText().toString());
        editor.putString("username", username.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.commit();
        Toast.makeText(getApplicationContext(), "Berhasil Simpan",
                Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }
    public void reset(View view) {
        nama_lengkap.setText("");
        username.setText("");
        password.setText("");
    }
    public void login(View view) {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        nama_lengkap.setText("");
        username.setText("");
        password.setText("");
    }
}