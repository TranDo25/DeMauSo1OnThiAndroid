package com.example.demauso1onthiandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demauso1onthiandroid.R;
import com.example.demauso1onthiandroid.model.Lop;

import java.util.List;

public class LopAdapter extends RecyclerView.Adapter<LopAdapter.LopViewHolder> {
    private Context mContext;
    private List<Lop> mListLop;

    public LopAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<Lop> list){
        this.mListLop = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lop, parent, false);
        return new LopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LopViewHolder holder, int position) {
        Lop lop = mListLop.get(position);
        if(lop == null){
            return;
        }
        holder.txtMaLop.setText(String.valueOf(lop.getMaLop()));
        holder.txtTenLop.setText(String.valueOf(lop.getTenLop()));
        holder.txtMoTa.setText(String.valueOf(lop.getMoTa()));
    }

    @Override
    public int getItemCount() {
        if(mListLop != null){
            return mListLop.size();
        }
        return 0;
    }

    public class LopViewHolder extends RecyclerView.ViewHolder {
        private TextView txtMaLop, txtTenLop, txtMoTa;
        public LopViewHolder(@NonNull View itemView){
            super(itemView);
            txtMaLop = itemView.findViewById(R.id.lop_malop);
            txtTenLop = itemView.findViewById(R.id.lop_tenlop);
            txtMoTa = itemView.findViewById(R.id.lop_mota);
        }
    }

}
