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
import com.example.demauso1onthiandroid.model.SinhVien;

public class AddSinhVienActivity extends AppCompatActivity {
    private EditText txtHoTen, txtNamSinh, txtQueQuan, txtNamHoc;
    private DatabaseHelper databaseHelper;
    private Button addSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinh_vien);
        txtHoTen = findViewById(R.id.addSV_tenSV);
        txtNamSinh = findViewById(R.id.addSV_txtNamSinh);
        txtQueQuan = findViewById(R.id.addSV_queQuan);
        txtNamHoc = findViewById(R.id.addSV_namHoc);
        addSV = findViewById(R.id.addSV_btnAdd);
        databaseHelper = new DatabaseHelper(this, "databaseOnThiSo1.sqlite", null, 1);
        addSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = txtHoTen.getText().toString();
                if (TextUtils.isEmpty(hoTen)) {
                    Toast.makeText(AddSinhVienActivity.this, "vui lòng nhập họ tên", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(txtNamSinh.getText().toString())) {
                    Toast.makeText(AddSinhVienActivity.this, "vui lòng nhập năm sinh", Toast.LENGTH_SHORT).show();
                    return;
                }
                int namSinh = Integer.parseInt(txtNamSinh.getText().toString());

                String queQuan = txtQueQuan.getText().toString();
                if (TextUtils.isEmpty(queQuan)) {
                    Toast.makeText(AddSinhVienActivity.this, "vui lòng nhập quê quán", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(txtNamHoc.getText().toString())) {
                    Toast.makeText(AddSinhVienActivity.this, "vui lòng nhập năm học", Toast.LENGTH_SHORT).show();
                    return;
                }
                int namHoc = Integer.parseInt(txtNamHoc.getText().toString());
                SinhVien tmp = new SinhVien( hoTen, namSinh, queQuan, namHoc);
                processAddSV(tmp);
            }

            private void processAddSV(SinhVien tmp) {
                databaseHelper.QueryData("INSERT INTO sinhvien values(null," +
                        "'" + tmp.getTenSV() + "',"
                        + tmp.getNamSinh() + ", '"
                        + tmp.getQueQuan() + "', "
                        + tmp.getNamHoc() + ")");
                Toast.makeText(AddSinhVienActivity.this, "thêm mới sinh viên thành công", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AddSinhVienActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

}