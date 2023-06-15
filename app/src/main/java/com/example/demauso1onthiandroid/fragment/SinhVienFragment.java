package com.example.demauso1onthiandroid.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.demauso1onthiandroid.AddSinhVienActivity;
import com.example.demauso1onthiandroid.R;
import com.example.demauso1onthiandroid.adapter.SinhVienAdapter;
import com.example.demauso1onthiandroid.helper.DatabaseHelper;
import com.example.demauso1onthiandroid.model.SinhVien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SinhVienFragment extends Fragment {
    DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    private SinhVienAdapter sinhVienAdapter;
    private FloatingActionButton floatingActionButtonAdd;
    private Button sinhVienNam2TenNam, btnDsSVNormal;

    public SinhVienFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sinh_vien, container, false);
        databaseHelper = new DatabaseHelper(getContext(), "databaseOnThiSo1.sqlite", null, 1);

        // Inflate the layout for this fragment
        recyclerView = rootView.findViewById(R.id.recyclerview_all);
        sinhVienAdapter = new SinhVienAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        sinhVienAdapter.setData(getAllSinhVien());
        recyclerView.setAdapter(sinhVienAdapter);
        DividerItemDecoration decor = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decor);
        floatingActionButtonAdd = rootView.findViewById(R.id.floatingActionButtonAddSV);
        sinhVienNam2TenNam = rootView.findViewById(R.id.btn_sinhVienNam2TenNam);
        btnDsSVNormal = rootView.findViewById(R.id.btn_dsSVNormal);
        btnDsSVNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sinhVienAdapter.setData(getAllSinhVien());
                recyclerView.setAdapter(sinhVienAdapter);
            }
        });
        sinhVienNam2TenNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sinhVienAdapter.setData(getSinhVienNam2TenNam());
                recyclerView.setAdapter(sinhVienAdapter);
            }
        });
        floatingActionButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AddSinhVienActivity.class);
                startActivity(i);
            }
        });
        return rootView;
    }

    public List<SinhVien> getSinhVienNam2TenNam() {
        Cursor dsSinhVien = databaseHelper.GetData("select * from sinhvien where sinhvien.namhoc = 2;");
        List<SinhVien> dsSVFormal = new ArrayList<>();
        while (dsSinhVien.moveToNext()) {
            SinhVien tmp = new SinhVien(dsSinhVien.getInt(0), dsSinhVien.getString(1), dsSinhVien.getInt(2), dsSinhVien.getString(3), dsSinhVien.getInt(4));
            String[] hoTenArr = tmp.getTenSV().split(" ");
            String ten = hoTenArr[hoTenArr.length - 1];
            if (ten.equals("Nam")) {
                dsSVFormal.add(tmp);

            }
        }
        return dsSVFormal;
    }

    public List<SinhVien> getAllSinhVien() {

        Cursor dsSinhVien = databaseHelper.GetData("select * from sinhvien;");
        List<SinhVien> dsSVFormal = new ArrayList<>();
        while (dsSinhVien.moveToNext()) {
            SinhVien tmp = new SinhVien(dsSinhVien.getInt(0), dsSinhVien.getString(1), dsSinhVien.getInt(2), dsSinhVien.getString(3), dsSinhVien.getInt(4));
            dsSVFormal.add(tmp);
        }
        return dsSVFormal;
    }
}