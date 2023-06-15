package com.example.demauso1onthiandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demauso1onthiandroid.R;
import com.example.demauso1onthiandroid.model.SinhVien_Lop;

import java.util.List;

public class SinhVien_LopAdapter extends RecyclerView.Adapter<SinhVien_LopAdapter.SinhVien_LopHolder> {
    private Context mContext;
    private List<SinhVien_Lop> mListSinhVien_Lop;

    public SinhVien_LopAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<SinhVien_Lop> list){
        this.mListSinhVien_Lop = list;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public SinhVien_LopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sinhvien_lop, parent, false);
        return new SinhVien_LopHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhVien_LopHolder holder, int position) {
        SinhVien_Lop sv_lop = mListSinhVien_Lop.get(position);
        if(sv_lop == null){
            return;
        }
        holder.txtMSV.setText(String.valueOf(sv_lop.getMaSV()));
        holder.txtMaLop.setText(String.valueOf(sv_lop.getMaLop()));
        holder.txtKyHoc.setText(String.valueOf(sv_lop.getKyHoc()));
        holder.txtSoTC.setText(String.valueOf(sv_lop.getSoTinChi()));

    }

    @Override
    public int getItemCount() {
        if(mListSinhVien_Lop != null){
            return mListSinhVien_Lop.size();
        }
        return 0;
    }

    public class SinhVien_LopHolder extends RecyclerView.ViewHolder{
        private TextView txtMSV,txtMaLop, txtKyHoc, txtSoTC;

        public SinhVien_LopHolder(@NonNull View itemView) {
            super(itemView);
            txtMSV = itemView.findViewById(R.id.sv_lop_msv);
            txtMaLop = itemView.findViewById(R.id.sv_lop_malop);
            txtKyHoc = itemView.findViewById(R.id.sv_lop_kyhoc);
            txtSoTC = itemView.findViewById(R.id.sv_lop_sotc);
        }
    }
}
