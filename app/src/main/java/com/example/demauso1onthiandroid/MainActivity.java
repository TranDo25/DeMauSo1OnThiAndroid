package com.example.demauso1onthiandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.database.Cursor;
import android.os.Bundle;

import com.example.demauso1onthiandroid.adapter.SinhVienAdapter;
import com.example.demauso1onthiandroid.adapter.ViewPagerAdapter;
import com.example.demauso1onthiandroid.helper.DatabaseHelper;
import com.example.demauso1onthiandroid.model.Lop;
import com.example.demauso1onthiandroid.model.SinhVien;
import com.example.demauso1onthiandroid.model.SinhVien_Lop;
import com.google.android.material.tabs.TabLayout;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        databaseHelper = new DatabaseHelper(this, "databaseOnThiSo1.sqlite", null, 1);
//        dropAllTable();
        createTable();
        addSampleData();
//        deleteTable();
    }

    private void deleteTable() {
        databaseHelper.QueryData("delete from sinhvien");
        databaseHelper.QueryData("delete from lop");
        databaseHelper.QueryData("delete from sinhvien_lop");
    }

    private void createTable() {
        databaseHelper.QueryData("CREATE TABLE IF NOT EXISTS sinhvien(" +
                "masv INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tensv varchar(255)," +
                "namsinh INTEGER, " +
                "quequan varchar(255)," +
                "namhoc INTEGER);");
        databaseHelper.QueryData("CREATE TABLE IF NOT EXISTS lop(" +
                "malop INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tenlop varchar(255)," +
                "mota varchar(255));");
        databaseHelper.QueryData("CREATE TABLE IF NOT EXISTS sinhvien_lop(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "masv INTEGER," +
                "malop INTEGER," +
                "kyhoc integer," +
                "sotinchi integer," +
                " foreign key (masv) references sinhvien(masv)," +
                " foreign key (malop) references lop(malop));");
//        databaseHelper.QueryData("ALTER TABLE sinhvien_lop ADD CONSTRAINT fk_sv_masv foreign key(masv) references sinhvien(masv);");
//        databaseHelper.QueryData("ALTER TABLE sinhvien_lop  ADD CONSTRAINT fk_lop_malop foreign key(malop)  references lop(malop);");
    }

    private void dropAllTable() {
        databaseHelper.QueryData("DROP TABLE sinhvien");
        databaseHelper.QueryData("DROP TABLE lop");
        databaseHelper.QueryData("DROP TABLE sinhvien_lop");
    }

    private void addSampleData() {
        //        //chèn dữ liệu vào bảng
        databaseHelper.QueryData("insert into sinhvien values(null, 'Tran Xuan Do', '2001', 'Minh Quang-Kien Xuong-Thai Binh',2023);");
        databaseHelper.QueryData("insert into sinhvien values(null, 'Hoang Tien Dat', '2002', 'Tra Giang-Kien Xuong-Thai Binh',2023);");
        databaseHelper.QueryData("insert into sinhvien values(null, 'Nguyen Dinh Du', '2003', 'Le Loi-Kien Xuong-Thai Binh',2023);");
        databaseHelper.QueryData("insert into sinhvien values(null, 'Pham Hoai Anh', '2001', 'Quang Trung-Kien Xuong-Thai Binh',2023);");
        databaseHelper.QueryData("insert into sinhvien values(null, 'Duong Tran Duc', '2001', 'Quang Minh-Kien Xuong-Thai Binh',2023);");
        databaseHelper.QueryData("insert into sinhvien values(null, 'Hoang Hai Nam', '2001', 'Quang Trung-Kien Xuong-Thai Binh',2);");

        databaseHelper.QueryData("insert into lop values(null, 'Kien truc thiet ke phan mem', 'lop do thay Nguyen Manh Hung day')");
        databaseHelper.QueryData("insert into lop values(null, 'Lap trinh thiet bi di dong', 'lop do thay Nguyen Hoanh Anh day')");
        databaseHelper.QueryData("insert into lop values(null, 'Dam bao chat luong phan mem', 'lop do co Do Thi Bich Ngoc day')");
        databaseHelper.QueryData("insert into lop values(null, 'Xay dung cac he thong nhung', 'lop do thay Do Tien Dung day')");
        databaseHelper.QueryData("insert into lop values(null, 'Chuyen de CNPM', 'lop do thay Do Duy Phuong day')");

        databaseHelper.QueryData("insert into sinhvien_lop values(null, 1, 1, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 1, 2, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 1, 3, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 1, 4, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 1, 5, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 2, 1, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 2, 2, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 2, 3, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 2, 4, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 2, 5, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 3, 1, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 3, 2, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 3, 3, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 3, 4, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 3, 5, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 4, 1, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 4, 2, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 4, 3, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 4, 4, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 4, 5, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 5, 1, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 5, 2, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 5, 3, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 5, 4, 9, 4)");
        databaseHelper.QueryData("insert into sinhvien_lop values(null, 5, 5, 9, 4)");
    }


}