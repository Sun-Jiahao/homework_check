package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.search_img);
        Glide.with(this).load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg1.juimg.com%2F180329%2F330819-1P32913244598.jpg&refer=http%3A%2F%2Fimg1.juimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1640351339&t=0812f213e8fad81874ab0a02fbc7df96").into(imageView);

        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("asfs");
        arrayList.add("asfsdfsds");
        MyPageAdapter mAdapter = initPager(arrayList);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        for (int i = 0;i < tabs.getTabCount();i++){
            if (i == 0) tabs.getTabAt(i).setCustomView(mAdapter.getTabView("结果1"));
            else tabs.getTabAt(i).setCustomView(mAdapter.getTabView(""+(i+1)));
        }

    }

    private MyPageAdapter initPager(ArrayList<String> tabName) {
        MyPageAdapter adapter = new MyPageAdapter(this, getSupportFragmentManager());
        Fragment fragment = new SearchResult();
        adapter.addFragment(fragment,tabName.get(0));
        adapter.addFragment(new SearchResult(),tabName.get(1));
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        return adapter;
    }

}