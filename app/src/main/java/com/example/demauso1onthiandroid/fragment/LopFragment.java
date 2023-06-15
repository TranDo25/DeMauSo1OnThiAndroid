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

import com.example.demauso1onthiandroid.AddLopActivity;
import com.example.demauso1onthiandroid.AddSinhVienActivity;
import com.example.demauso1onthiandroid.R;
import com.example.demauso1onthiandroid.adapter.LopAdapter;
import com.example.demauso1onthiandroid.helper.DatabaseHelper;
import com.example.demauso1onthiandroid.model.Lop;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class LopFragment extends Fragment {

    DatabaseHelper databaseHelper;

    private RecyclerView recyclerView;
    private LopAdapter lopAdapter;
    private FloatingActionButton floatingActionButtonAdd;

    public LopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lop,container, false);
        databaseHelper = new DatabaseHelper(getContext(), "databaseOnThiSo1.sqlite", null, 1);
        recyclerView = rootView.findViewById(R.id.recycleview_lop);
        lopAdapter = new LopAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        lopAdapter.setData(getALlLop());
        recyclerView.setAdapter(lopAdapter);
        DividerItemDecoration decor = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decor);
        floatingActionButtonAdd = rootView.findViewById(R.id.floatingActionButtonAddLop);
        floatingActionButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AddLopActivity.class);
                startActivity(i);
            }
        });
        return rootView;
    }
    public List<Lop> getALlLop() {
        Cursor dsLop = databaseHelper.GetData("select * from lop;");
        List<Lop> dsLopFormal = new ArrayList<>();
        while (dsLop.moveToNext()) {
            Lop tmp = new Lop(dsLop.getInt((0)), dsLop.getString(1), dsLop.getString(2));
            dsLopFormal.add(tmp);
        }
        return dsLopFormal;
    }

}