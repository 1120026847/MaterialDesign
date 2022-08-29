package com.example.snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String TAG="moli";
//        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
//       View  view = inflater.inflate(R.layout.activity_main, null);
        ConstraintLayout constraintLayout=findViewById(R.id.view);
        Snackbar.make(constraintLayout,"这是主布局的view",Snackbar.LENGTH_SHORT).show();
        Button bt_common_show=findViewById(R.id.bt_common_show);
        Button bt_AddAction=findViewById(R.id.bt_AddAction);
        Button bt_ChangeColor=findViewById(R.id.bt_ChangeColor);
        /*
        public void snackBar(String msg, View v) {
    Snackbar.make(v, msg, Snackbar.LENGTH_LONG).setAction("Action", null).show();
}
         */
        bt_common_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"提示",Snackbar.LENGTH_SHORT).show();
            }
        });
        bt_AddAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //LENGTH_INDEFINITE代表无限
              Snackbar snackbar=  Snackbar.make(view,"这是加action的snackbar",Snackbar.LENGTH_INDEFINITE);
//设置action的点击事件
                snackbar.setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "你点了确定", Toast.LENGTH_SHORT).show();
                    }
                }).show();

            }
        });
        bt_ChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Snackbar snackbar=Snackbar.make(view,"这是改变颜色的snackbar",Snackbar.LENGTH_INDEFINITE);
//设置snackbar的背景颜色
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.teal_700));
snackbar.setActionTextColor(Color.RED);
snackbar.setAction("确定", new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this, "你点了确定", Toast.LENGTH_SHORT).show();
    }
}).show();
//snackbar添加的回调方法
snackbar.addCallback(new Snackbar.Callback(){
    @Override
    public void onDismissed(Snackbar transientBottomBar, int event) {
        super.onDismissed(transientBottomBar, event);
        Log.e(TAG, "Sanck消失的时候触发的重写方法 ");
    }

    @Override
    public void onShown(Snackbar sb) {
        super.onShown(sb);
        Log.e(TAG, "Sanck展示的时候触发的重写方法");
    }
});

            }
        });
    }
}