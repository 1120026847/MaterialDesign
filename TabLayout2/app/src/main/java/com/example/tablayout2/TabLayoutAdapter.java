package com.example.tablayout2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class TabLayoutAdapter extends FragmentStateAdapter {
    //使用list装载Fragment
    ArrayList<Fragment> fragments;
    //适配器的构造方法，传入fragments,使得适配器与MainActivity之间fragment数据连接
    public TabLayoutAdapter(@NonNull FragmentActivity fragmentActivity,ArrayList<Fragment> fragments) {
        super(fragmentActivity);
        this.fragments=fragments;
    }
//用position fragment与Adapter绑定在一起
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }
//返回item的数量
    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
