package com.example.a2211_levietdat_tuan5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.widget.TextView;
import android.graphics.Color;


public class LoginActivity extends AppCompatActivity {
    EditText edtUser, edtPass;
    Button btnLogin, btnToRegister; // thêm nút Đăng ký

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView tvTitle = findViewById(R.id.tvTitle);
        Shader textShader = new LinearGradient(0, 0, 0, tvTitle.getTextSize(),
                new int[]{Color.YELLOW, Color.RED}, // xanh lá + hồng
                null, Shader.TileMode.CLAMP);
        tvTitle.getPaint().setShader(textShader);


        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnToRegister = findViewById(R.id.btnToRegister); // ánh xạ nút Đăng ký

        btnLogin.setOnClickListener(v -> {
            String user = edtUser.getText().toString();
            String pass = edtPass.getText().toString();

            if (user.equals("admin") && pass.equals("123")) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "Sai tài khoản hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
            }
        });

        // sự kiện cho nút Đăng ký
        btnToRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
