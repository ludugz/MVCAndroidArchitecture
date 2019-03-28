package com.myself.mvcandroid;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.myself.mvcandroid.adapter.MyRvAdapter;
import com.myself.mvcandroid.common.BaseObservableViewMvc;
import com.myself.mvcandroid.model.Data;

import java.util.List;

/**
 * Created by admin on 3/20/2019.
 */

public class ListViewMvcImpl extends BaseObservableViewMvc<ListViewMvc.Listener>
        implements ListViewMvc, MyRvAdapter.Listener {

    private RecyclerView mRecyclerView;
    private MyRvAdapter mAdapter;

    public ListViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_questions_list, parent, false));

        mRecyclerView = findViewById(R.id.recycler_questions);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new MyRvAdapter(inflater, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void bindDatas(List<Data> dataList) {
        mAdapter.bindData(dataList);

    }

    @Override
    public void onDataClicked(Data data) {
        for (Listener listener : getListeners()) {
            listener.onDataClicked(data);
        }
    }
}
