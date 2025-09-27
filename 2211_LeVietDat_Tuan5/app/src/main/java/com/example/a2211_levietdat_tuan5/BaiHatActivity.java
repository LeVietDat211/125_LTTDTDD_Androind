package com.example.a2211_levietdat_tuan5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BaiHatActivity extends AppCompatActivity {
    Button btnBackBaiHat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baihat);

        TextView tv = findViewById(R.id.tvBaiHat);
        tv.setText("Đây là trang Quản lý Bài Hát");

        btnBackBaiHat = findViewById(R.id.btnBackBaiHat);
        btnBackBaiHat.setOnClickListener(v -> {
            Intent intent = new Intent(BaiHatActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}


