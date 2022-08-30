package com.example.searchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout layout;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         layout = findViewById(R.id.layout);
textView=findViewById(R.id.textView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //引用清单文件
        getMenuInflater().inflate(R.menu.searchmenu, menu);
        MenuItem search = menu.findItem(R.id.serach_menu);
        SearchView searchView = (SearchView) search.getActionView();
        //搜索图标是否显示在搜索框内
        searchView.setIconifiedByDefault(true);
        //设置搜索框展开时是否显示提交按钮
        searchView.setSubmitButtonEnabled(true);
        //让键盘的回车设置为搜索
searchView.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
//搜索框默认是否展开.true时不展开，false是展开
searchView.setIconified(true);
//搜索框获取焦点
searchView.setFocusable(true);
//设置在Touch模式下不支持焦点，也能够获得焦点
       searchView.requestFocusFromTouch();
       //输入提示信息
searchView.setQueryHint("请输入搜索内容");
//获取输入框
        EditText editText=searchView.findViewById(com.google.android.material.R.id.search_src_text);
        //设置输入框的提示文字颜色
editText.setHintTextColor(ContextCompat.getColor(this,R.color.white));
//设置输入框的文字颜色
editText.setTextColor(ContextCompat.getColor(this,R.color.white));
//设置搜索框的文本监听
searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String query) {
        //搜索内容提交时的操作
        Snackbar.make(layout,"搜索的内容是"+query,Snackbar.LENGTH_SHORT).show();
        //伪搜索
        textView.setVisibility(View.VISIBLE);
        return false;
    }
//当搜索内容改变时触发该方法
    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)){
textView.setVisibility(View.INVISIBLE);
        }
        return false;
    }
});
        return super.onCreateOptionsMenu(menu);
    }
}