package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.isEmpty()) {
                    etUsername.setError("Nhập tài khoản");
                    return;
                }
                if (password.isEmpty()) {
                    etPassword.setError("Nhập mật khẩu");
                    return;
                }

                // ✅ Kiểm tra mật khẩu cố định (ví dụ "12345")
                if (username.equals("admin") && password.equals("12345")) {
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.putExtra("USERNAME", username);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Sai tài khoản hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
