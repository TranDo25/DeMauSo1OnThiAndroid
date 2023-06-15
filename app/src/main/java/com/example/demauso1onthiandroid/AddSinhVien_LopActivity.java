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
import com.example.demauso1onthiandroid.model.SinhVien_Lop;

public class AddSinhVien_LopActivity extends AppCompatActivity {
    private EditText txtMSV, txtMaLop, txtKyHoc, txtSoTC;
    private Button addSV_Lop;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinh_vien_lop);
        txtMSV = findViewById(R.id.addLop_SV_MSV);
        txtMaLop = findViewById(R.id.addLop_SV_MaLop);
        txtKyHoc = findViewById(R.id.addLop_SV_KyHoc);
        txtSoTC = findViewById(R.id.addLop_SV_soTC);
        addSV_Lop = findViewById(R.id.addLop_SV_btnSave);
        databaseHelper = new DatabaseHelper(this, "databaseOnThiSo1.sqlite", null, 1);
        addSV_Lop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(txtKyHoc.getText().toString())) {
                    Toast.makeText(AddSinhVien_LopActivity.this, "vui lòng nhập kỳ học", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(txtMSV.getText().toString())) {
                    Toast.makeText(AddSinhVien_LopActivity.this, "vui lòng nhập mã sinh viên", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(txtMaLop.getText().toString())) {
                    Toast.makeText(AddSinhVien_LopActivity.this, "vui lòng nhập mã lớp", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(txtSoTC.getText().toString())) {
                    Toast.makeText(AddSinhVien_LopActivity.this, "vui lòng nhập số tín chỉ", Toast.LENGTH_SHORT).show();
                    return;
                }
                int MSV = Integer.parseInt(txtMSV.getText().toString());
                int maLop = Integer.parseInt(txtMaLop.getText().toString());
                int kyHoc = Integer.parseInt(txtKyHoc.getText().toString());
                int soTC = Integer.parseInt(txtSoTC.getText().toString());
                processAddSVLop(new SinhVien_Lop(MSV, maLop, kyHoc, soTC));

            }
        });
    }

    private void processAddSVLop(SinhVien_Lop sinhVien_lop) {
        try {
            databaseHelper.QueryData("INSERT INTO sinhvien_lop values(null,"+sinhVien_lop.getMaSV()+","+sinhVien_lop.getMaLop()+","+sinhVien_lop.getKyHoc()+","+sinhVien_lop.getSoTinChi()+")");
        } catch (Exception e) {
            Toast.makeText(AddSinhVien_LopActivity.this, "đăng ký lớp thất bại", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(AddSinhVien_LopActivity.this, "đăng ký lớp thành công", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(AddSinhVien_LopActivity.this, MainActivity.class);
        startActivity(i);

    }
}