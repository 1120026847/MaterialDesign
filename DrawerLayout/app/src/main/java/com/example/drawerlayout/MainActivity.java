package com.example.drawerlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String TAG="moli";
        NavigationView navigationView=findViewById(R.id.LeftDrawer);
        DrawerLayout drawerLayout=findViewById(R.id.drawerLayout);
        MaterialToolbar materialToolbar=findViewById(R.id.materialToolbar);
        Button bt_StartLeftDrawer=findViewById(R.id.btn_open_left);
        Button bt_StartRightDrawer=findViewById(R.id.btn_open_right);
Button bt_EndRightDrawer=findViewById(R.id.bt_End_right_Drawer);

        /*
        ActionBarDrawerToggle就是DrawerLayout事件的监听器。
drawerlayout与masteraltoolbar关联起来
         */
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,materialToolbar,R.string.String_Open,R.string.String_close);
//初始化状态
        actionBarDrawerToggle.syncState();
//DrawerLayout设置监听
    drawerLayout.addDrawerListener(actionBarDrawerToggle);
//DrawerLayout设置监听事件
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            //抽屉滑动的时候触发的监听
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                Log.e(TAG, "滑动中" );
            }
            //抽屉打开的时候触发的监听
            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                Log.e(TAG, "打开中" );
            }
            //抽屉关闭的时候触发的监听
            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                Log.e(TAG, "关闭中" );
            }
//抽屉状态改变的时候触发的监听
            @Override
            public void onDrawerStateChanged(int newState) {
                Log.e(TAG, "状态改变");
            }
        });

        //设置navigationview内容点击事件
navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        String title= (String) item.getTitle();
        Toast.makeText(MainActivity.this, "内容是"+title, Toast.LENGTH_SHORT).show();
        return false;
    }
});
bt_StartLeftDrawer.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
drawerLayout.openDrawer(GravityCompat.START);
    }
});
bt_StartRightDrawer.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        drawerLayout.openDrawer(GravityCompat.END);
    }
});
bt_EndRightDrawer.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //关闭执行DrawerLayout
drawerLayout.closeDrawer(GravityCompat.END);
    }
});
//drawerLayout.closeDrawers();关闭所有

    }
}