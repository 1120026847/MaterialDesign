package com.example.scrolling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class ScrollingAndViewpager extends AppCompatActivity {
    ArrayList<Fragment> fragments;
    ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_and_viewpager);
  TabLayout tabLayout=findViewById(R.id.tabs);

        viewPager2=findViewById(R.id.viewPager2);
        fragments=new ArrayList<>();
       OneFragment oneFragment=new OneFragment();
       TwoFragment twoFragment=new TwoFragment();
       ThreeFragment threeFragment=new ThreeFragment();
       fragments.add(oneFragment);
       fragments.add(twoFragment);
       fragments.add(threeFragment);
        FragmentAdapter fragmentAdapter=new FragmentAdapter(this,fragments);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager2.setAdapter(fragmentAdapter);
        ArrayList<String> titleList=new ArrayList<String>();
        titleList.add("新闻");
        titleList.add("体育");
        titleList.add("电竞");





new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
       tab.setText(titleList.get(position));
    }
}).attach();


    }
}