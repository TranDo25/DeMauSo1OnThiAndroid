package com.example.demauso1onthiandroid.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.demauso1onthiandroid.fragment.LopFragment;
import com.example.demauso1onthiandroid.fragment.SinhVienFragment;
import com.example.demauso1onthiandroid.fragment.SinhVien_LopFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behaviorResumeOnlyCurrentFragment) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SinhVienFragment();
            case 1:
                return new LopFragment();
            case 2:
                return new SinhVien_LopFragment();
            default:
                return new SinhVienFragment();

        }
    }

    @Override
    public int getCount() {
        return 3;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch(position){
            case 0:
                title = "Sinh viên";
                break;
            case 1:
                title = "Lớp";
                break;
            case 2:
                title = "Đăng ký môn học";
                break;
        }
        return title;
    }
}
