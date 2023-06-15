package com.example.demauso1onthiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demauso1onthiandroid.helper.DatabaseHelper;
import com.example.demauso1onthiandroid.model.Lop;

public class AddLopActivity extends AppCompatActivity {
    private EditText txtTenLop, txtMoTa;
    private Button addLop;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lop);
        txtTenLop = findViewById(R.id.addLop_tenLop);
        txtMoTa = findViewById(R.id.addLop_moTa);
        databaseHelper = new DatabaseHelper(this, "databaseOnThiSo1.sqlite", null, 1);

        addLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenLop = txtTenLop.getText().toString();
                if (TextUtils.isEmpty(tenLop)) {
                    Toast.makeText(AddLopActivity.this, "vui lòng nhập tên lớp", Toast.LENGTH_SHORT).show();
                    return;
                }
                String moTa = txtMoTa.getText().toString();
                if (TextUtils.isEmpty(moTa)) {
                    Toast.makeText(AddLopActivity.this, "vui lòng nhập mô tả", Toast.LENGTH_SHORT).show();
                    return;
                }
                functionAddLop(new Lop(tenLop, moTa));
            }
        });
    }

    private void functionAddLop(Lop tmp) {
        databaseHelper.QueryData("INSERT INTO lop values(null, '"+tmp.getTenLop()+"','"+tmp.getMoTa()+"')");
        Toast.makeText(AddLopActivity.this, "thêm mới lớp thành công", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(AddLopActivity.this, MainActivity.class);
        startActivity(i);

    }
}