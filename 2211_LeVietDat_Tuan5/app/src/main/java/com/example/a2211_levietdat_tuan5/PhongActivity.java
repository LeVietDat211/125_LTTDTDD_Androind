package com.example.a2211_levietdat_tuan5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhongActivity extends AppCompatActivity {

    EditText edtMaPhong, edtTenPhong, edtLoaiPhong, edtGhiChu;
    Button btnThem, btnSua, btnXoa, btnTimKiem, btnBackPhong;
    ListView listViewPhong;

    ArrayList<String> dsPhong;
    ArrayAdapter<String> adapter;
    int selectedIndex = -1; // vị trí item đang chọn

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong);

        // Ánh xạ view
        TextView tv = findViewById(R.id.tvPhong);
        edtMaPhong = findViewById(R.id.edtMaPhong);
        edtTenPhong = findViewById(R.id.edtTenPhong);
        edtLoaiPhong = findViewById(R.id.edtLoaiPhong);
        edtGhiChu = findViewById(R.id.edtGhiChu);

        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        btnTimKiem = findViewById(R.id.btnTimKiem);
        btnBackPhong = findViewById(R.id.btnBackPhong);

        listViewPhong = findViewById(R.id.listViewPhong);

        // Dữ liệu mẫu
        dsPhong = new ArrayList<>();
        dsPhong.add("P101 - Phòng Máy - Loại A");
        dsPhong.add("P102 - Phòng Học - Loại B");

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dsPhong);
        listViewPhong.setAdapter(adapter);

        // Bắt sự kiện chọn item
        listViewPhong.setOnItemClickListener((parent, view, position, id) -> {
            selectedIndex = position;
            String item = dsPhong.get(position);
            tv.setText("Đang chọn: " + item);
        });

        // Nút Thêm
        btnThem.setOnClickListener(v -> {
            String ma = edtMaPhong.getText().toString();
            String ten = edtTenPhong.getText().toString();
            String loai = edtLoaiPhong.getText().toString();
            String ghiChu = edtGhiChu.getText().toString();

            if (!ma.isEmpty() && !ten.isEmpty()) {
                dsPhong.add(ma + " - " + ten + " - " + loai + " (" + ghiChu + ")");
                adapter.notifyDataSetChanged();
                clearInput();
            }
        });

        // Nút Sửa
        btnSua.setOnClickListener(v -> {
            if (selectedIndex != -1) {
                String ma = edtMaPhong.getText().toString();
                String ten = edtTenPhong.getText().toString();
                String loai = edtLoaiPhong.getText().toString();
                String ghiChu = edtGhiChu.getText().toString();

                dsPhong.set(selectedIndex, ma + " - " + ten + " - " + loai + " (" + ghiChu + ")");
                adapter.notifyDataSetChanged();
                clearInput();
                selectedIndex = -1;
            }
        });

        // Nút Xóa
        btnXoa.setOnClickListener(v -> {
            if (selectedIndex != -1) {
                dsPhong.remove(selectedIndex);
                adapter.notifyDataSetChanged();
                clearInput();
                selectedIndex = -1;
            }
        });

        // Nút Tìm kiếm (rất đơn giản)
        btnTimKiem.setOnClickListener(v -> {
            String keyword = edtTenPhong.getText().toString().toLowerCase();
            ArrayList<String> ketQua = new ArrayList<>();
            for (String p : dsPhong) {
                if (p.toLowerCase().contains(keyword)) {
                    ketQua.add(p);
                }
            }
            adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, ketQua);
            listViewPhong.setAdapter(adapter);
        });

        // Quay lại Menu
        btnBackPhong.setOnClickListener(v -> {
            Intent intent = new Intent(PhongActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    // Hàm xóa trắng ô nhập
    private void clearInput() {
        edtMaPhong.setText("");
        edtTenPhong.setText("");
        edtLoaiPhong.setText("");
        edtGhiChu.setText("");
    }
}
