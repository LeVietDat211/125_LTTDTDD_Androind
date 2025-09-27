package com.example.a2211_levietdat_tuan5;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    Button btnRegister, btnToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView tvTitle = findViewById(R.id.tvRegister);
        Shader textShader = new LinearGradient(0, 0, 0, tvTitle.getTextSize(),
                new int[]{Color.YELLOW, Color.RED},
                null, Shader.TileMode.CLAMP);
        tvTitle.getPaint().setShader(textShader);

        btnRegister = findViewById(R.id.btnRegister);
        btnToLogin = findViewById(R.id.btnToLogin);

        // Nút "Đăng ký" (ở đây chỉ minh họa)
        btnRegister.setOnClickListener(v -> {
            // Xử lý logic đăng ký ở đây (chưa cần DB thì chỉ show Toast thôi)
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        // Nút "Quay lại Đăng nhập"
        btnToLogin.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
