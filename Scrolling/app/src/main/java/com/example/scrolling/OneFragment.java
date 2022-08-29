package com.example.scrolling;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OneFragment extends Fragment {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter();
        RecyclerView recyclerView=getView().findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        /*
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
LinearLayoutManager layoutManager = new LinearLayoutManager(this );
//设置布局管理器
recyclerView.setLayoutManager(layoutManager);
//设置为垂直布局，这也是默认的
layoutManager.setOrientation(OrientationHelper. VERTICAL);
//设置Adapter
recyclerView.setAdapter(recycleAdapter);
 //设置分隔线
recyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
//设置增加或删除条目的动画
recyclerView.setItemAnimator( new DefaultItemAnimator());
         */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }
}