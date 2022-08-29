package com.example.swiperefreshlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
/*
setOnRefreshListener：设置刷新监听器。需要重写监听器OnRefreshListener的onRefresh方法，该方法在下拉松开时触发。
setRefreshing：设置刷新的状态。true表示正在刷新，false表示结束刷新。
isRefreshing：判断是否正在刷新。
setColorSchemeColors：设置进度圆圈的圆环颜色。
setProgressBackgroundColorSchemeColor：设置进度圆圈的背景颜色。
setProgressViewOffset：设置进度圆圈的偏移量。第一个参数表示进度圈是否缩放，第二个参数表示进度圈开始出现时距顶端的偏移，第三个参数表示进度圈拉到最大时距顶端的偏移。
setDistanceToTriggerSync：设置手势向下滑动多少距离才会触发刷新操作。
————————————————
版权声明：本文为CSDN博主「淼森007」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_38322371/article/details/115027179
 */
public class MainActivity extends AppCompatActivity  implements SwipeRefreshLayout.OnRefreshListener{
    private TextView textView;
    private SwipeRefreshLayout swipeRefreshLayout;
    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
textView=findViewById(R.id.tv_simple);
swipeRefreshLayout=findViewById(R.id.srl_simple);
//设置下拉刷新组件的刷新监听器，this代表implements SwipeRefreshLayout.OnRefreshListener的重写方法
swipeRefreshLayout.setOnRefreshListener(this);
     swipeRefreshLayout.setColorSchemeResources(R.color.blue,R.color.red,R.color.orange,R.color.teal_200);
// 定义一个handler用于模拟延迟，定义一个线程用于刷新ui界面
  handler=new Handler();
  runnable=new Runnable() {
     @Override
     public void run() {
         //线程
         textView.setText("刷新成功");
         swipeRefreshLayout.setRefreshing(false);
     }
 };


    }
//一旦下拉，就会触发下拉监听器的onRefresh方法
    @Override
    public void onRefresh() {
textView.setText("刷新中");
        //handler的postDelayed第一个方法是线程对象，第二个是延迟的秒数，延迟时间到了就执行线程的run方法
        handler.postDelayed(runnable,1000);
    }
}