package com.myself.mvcandroid;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.myself.mvcandroid.adapter.MyRvAdapter;
import com.myself.mvcandroid.common.BaseActivity;
import com.myself.mvcandroid.model.Data;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends BaseActivity implements ListViewMvcImpl.Listener {
    private List<Data> mDataList = new ArrayList<>();
    private ListViewMvc mViewMvc;

    @Override
    protected void onStart() {
        super.onStart();
        getData();
    }

    private void getData() {
        bindData(mDataList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFakeData();

        mViewMvc = new ListViewMvcImpl(LayoutInflater.from(this),null);
        mViewMvc.registerListener(this);
        setContentView(mViewMvc.getRootView());
    }

    private void initFakeData() {
        mDataList.add(new Data("a", 1));
        mDataList.add(new Data("b", 2));
        mDataList.add(new Data("c", 3));
        mDataList.add(new Data("d", 4));
        mDataList.add(new Data("e", 5));
        mDataList.add(new Data("f", 6));
        mDataList.add(new Data("g", 7));
    }

    @Override
    public void onDataClicked(Data data) {
        Toast.makeText(this, data.getTitle(), Toast.LENGTH_SHORT).show();

    }

    private void bindData(List<Data> dataList) {
        List<Data> questions = new ArrayList<>(dataList.size());
        for (Data data : dataList) {
            questions.add(new Data(data.getTitle(), data.getId()));
        }
        mViewMvc.bindDatas(questions);
    }
}
