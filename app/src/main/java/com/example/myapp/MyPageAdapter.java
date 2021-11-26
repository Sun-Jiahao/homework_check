package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyPageAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    ArrayList<String> tabName = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();


    public void addFragment(Fragment fragment, String name){
        tabName.add(name);
        fragments.add(fragment);
    }

    public MyPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabName.get(position);
    }

    public View getTabView(String tabTitle) {
        mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.item_result, null);
        TextView tv =view.findViewById(R.id.tab_result);
        tv.setText(tabTitle);
        return view;
    }

}