package com.example.demauso1onthiandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demauso1onthiandroid.R;
import com.example.demauso1onthiandroid.model.SinhVien;

import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.SinhVienViewHolder> {
    private Context mContext;
    private List<SinhVien> mListSinhVien;

    public SinhVienAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<SinhVien> list) {
        this.mListSinhVien = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SinhVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sinhvien, parent, false);
        return new SinhVienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhVienViewHolder holder, int position) {
        SinhVien sinhVien = mListSinhVien.get(position);
        if (sinhVien == null) {
            return;
        }
        holder.txtMSV.setText(String.valueOf(sinhVien.getMaSV()));
        holder.txtHoTen.setText(sinhVien.getTenSV());
        holder.txtNamSinh.setText(String.valueOf(sinhVien.getNamSinh()));
        holder.txtQueQuan.setText(sinhVien.getQueQuan());
        holder.txtNamTotNghiep.setText(String.valueOf(sinhVien.getNamHoc()));
    }

    @Override
    public int getItemCount() {
        if (mListSinhVien != null) {
            return mListSinhVien.size();
        }
        return 0;
    }

    public class SinhVienViewHolder extends RecyclerView.ViewHolder {
        private TextView txtMSV, txtHoTen, txtNamSinh, txtQueQuan, txtNamTotNghiep;

        public SinhVienViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMSV = itemView.findViewById(R.id.sinhvien_msv);
            txtNamSinh = itemView.findViewById(R.id.sinhvien_namsinh);
            txtQueQuan = itemView.findViewById(R.id.sinhvien_quequan);
            txtNamTotNghiep = itemView.findViewById(R.id.sinhvien_namtotnghiep);
            txtHoTen = itemView.findViewById(R.id.sinhvien_hoten);
        }


    }
}
