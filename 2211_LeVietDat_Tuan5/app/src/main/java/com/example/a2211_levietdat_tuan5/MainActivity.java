package com.example.a2211_levietdat_tuan5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnPhong, btnBaiHat, btnHoaDon, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPhong = findViewById(R.id.btnPhong);
        btnBaiHat = findViewById(R.id.btnBaiHat);
        btnHoaDon = findViewById(R.id.btnHoaDon);
        btnLogout = findViewById(R.id.btnLogout);

        btnPhong.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PhongActivity.class)));
        btnBaiHat.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, BaiHatActivity.class)));
        btnHoaDon.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, HoaDonActivity.class)));
        btnLogout.setOnClickListener(v -> finish());
    }
}

