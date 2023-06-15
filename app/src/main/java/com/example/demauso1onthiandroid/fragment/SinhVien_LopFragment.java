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

import com.example.demauso1onthiandroid.AddSinhVienActivity;
import com.example.demauso1onthiandroid.AddSinhVien_LopActivity;
import com.example.demauso1onthiandroid.R;
import com.example.demauso1onthiandroid.adapter.LopAdapter;
import com.example.demauso1onthiandroid.adapter.SinhVien_LopAdapter;
import com.example.demauso1onthiandroid.helper.DatabaseHelper;
import com.example.demauso1onthiandroid.model.SinhVien_Lop;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class SinhVien_LopFragment extends Fragment {

    DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    private SinhVien_LopAdapter sinhVien_lopAdapter;
    private FloatingActionButton floatingActionButtonAdd;

    public SinhVien_LopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sinh_vien__lop, container, false);
        databaseHelper = new DatabaseHelper(getContext(), "databaseOnThiSo1.sqlite", null, 1);
        recyclerView = rootView.findViewById((R.id.recycleview_sv_lop));
        sinhVien_lopAdapter = new SinhVien_LopAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        sinhVien_lopAdapter.setData(getAllSinhVien_Lop());
        recyclerView.setAdapter(sinhVien_lopAdapter);
        DividerItemDecoration decor = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decor);
        floatingActionButtonAdd = rootView.findViewById(R.id.floatingActionButtonAddSV_Lop);
        floatingActionButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AddSinhVien_LopActivity.class);
                startActivity(i);
            }
        });
        return rootView;

    }

    public List<SinhVien_Lop> getAllSinhVien_Lop() {
        Cursor dsSinhVien_Lop = databaseHelper.GetData("select * from sinhvien_lop;");
        List<SinhVien_Lop> dsSinhVien_LopFormal = new ArrayList<>();
        while (dsSinhVien_Lop.moveToNext()) {
            SinhVien_Lop tmp = new SinhVien_Lop(dsSinhVien_Lop.getInt(0), dsSinhVien_Lop.getInt(1), dsSinhVien_Lop.getInt(2),
                    dsSinhVien_Lop.getInt(3), dsSinhVien_Lop.getInt(4));
            dsSinhVien_LopFormal.add(tmp);
        }
        return dsSinhVien_LopFormal;
    }
}