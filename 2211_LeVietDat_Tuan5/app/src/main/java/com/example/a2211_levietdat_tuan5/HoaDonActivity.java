package com.example.a2211_levietdat_tuan5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HoaDonActivity extends AppCompatActivity {
    Button btnBackHoaDon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoadon);

        TextView tv = findViewById(R.id.tvHoaDon);
        tv.setText("Đây là trang Quản lý Hóa Đơn");

        btnBackHoaDon = findViewById(R.id.btnBackHoaDon);
        btnBackHoaDon.setOnClickListener(v -> {
            Intent intent = new Intent(HoaDonActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

