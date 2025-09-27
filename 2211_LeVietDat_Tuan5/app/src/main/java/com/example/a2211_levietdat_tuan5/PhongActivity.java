package com.example.a2211_levietdat_tuan5;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PhongActivity extends AppCompatActivity {
    Button btnBackPhong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong);

        TextView tv = findViewById(R.id.tvPhong);
        tv.setText("Đây là trang Quản lý Phòng");

        btnBackPhong = findViewById(R.id.btnBackPhong);
        btnBackPhong.setOnClickListener(v -> {
            Intent intent = new Intent(PhongActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // đóng trang hiện tại
        });
    }
}


