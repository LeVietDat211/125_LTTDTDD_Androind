package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView tvProfileName, tvEmail, tvPhone, tvStudentId;
    ImageButton btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvProfileName = findViewById(R.id.tvProfileName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvStudentId = findViewById(R.id.tvStudentId);
        btnSettings = findViewById(R.id.btnSettings);

        // Nhận username từ Login để hiển thị "Profile Name"
        String username = getIntent().getStringExtra("USERNAME");
        if (username == null || username.isEmpty()) username = "Người dùng";
        tvProfileName.setText(username);

        // Set thông tin cố định theo yêu cầu
        tvEmail.setText("levietdat23@gmail.com");
        tvPhone.setText("111111111");
        tvStudentId.setText("23115053122211");

        // Nút bánh răng -> Popup menu
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSettingsMenu(v);
            }
        });
    }

    private void showSettingsMenu(View anchor) {
        PopupMenu popup = new PopupMenu(ProfileActivity.this, anchor);
        popup.getMenuInflater().inflate(R.menu.menu_profile, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_login) {
                    // Chọn "Login" -> quay về màn hình Login
                    finish(); // đóng ProfileActivity, hiện lại MainActivity
                    return true;
                }
                return false;
            }
        });
        popup.show();
    }
}
