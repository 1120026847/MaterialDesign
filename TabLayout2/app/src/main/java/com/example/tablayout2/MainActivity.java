package com.example.tablayout2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  String TAG="moli";
//把fragment1和fragment2放入集合中，利用适配器的构造方法来传递到构造方法里
        TabLayout tabLayout=findViewById(R.id.tablayout);
        ViewPager2 viewPager2=findViewById(R.id.viewpager2);
        ArrayList<Fragment> fragments=new ArrayList<Fragment>();
        OneFragment oneFragment=new OneFragment();
        TwoFragment twoFragment=new TwoFragment();
        fragments.add(oneFragment);
        fragments.add(twoFragment);
        //适配器的对象，第一个参数是装载在哪个activity
        TabLayoutAdapter tabLayoutAdapter=new TabLayoutAdapter(this,fragments);
        //设置ViewPager2的滑动方向
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        //为viewPager设置适配器
        viewPager2.setAdapter(tabLayoutAdapter);
        //创建fragment的标题列表
        ArrayList<String> FragmentTitle=new ArrayList<String>();
        FragmentTitle.add("娱乐");
        FragmentTitle.add("新闻");
        //tablayout与viewpager2关联起来
new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        //设置tablayout的标题,根据postion的位置来对应fragment
        tab.setText(FragmentTitle.get(position));
    }
}).attach();
//给viewpager2注册回调
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                Log.e(TAG, "onPageScrolled: ");
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.e(TAG, "onPageSelected: " );
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                Log.e(TAG, "onPageScrollStateChanged: ");
            }
        });
    }
}