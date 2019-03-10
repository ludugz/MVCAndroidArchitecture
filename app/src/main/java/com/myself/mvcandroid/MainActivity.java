package com.myself.mvcandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.myself.mvcandroid.adapter.MyRvAdapter;
import com.myself.mvcandroid.model.FakeData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRvAdapter.IOnClickItemListener {
    private List<FakeData> mFakeDataList = new ArrayList<>();
    private MyRvAdapter mMyRvAdapter;
    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFakeData();
        initRecycler();
    }

    private void initRecycler() {
        mRv = findViewById(R.id.recycler_view);
        mMyRvAdapter = new MyRvAdapter(mFakeDataList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRv.setLayoutManager(linearLayoutManager);
        mRv.setAdapter(mMyRvAdapter);
    }

    private void initFakeData() {
        mFakeDataList.add(new FakeData("a", 1));
        mFakeDataList.add(new FakeData("b", 2));
        mFakeDataList.add(new FakeData("c", 3));
        mFakeDataList.add(new FakeData("d", 4));
        mFakeDataList.add(new FakeData("e", 5));
        mFakeDataList.add(new FakeData("f", 6));
        mFakeDataList.add(new FakeData("g", 7));
    }

    @Override
    public void showToast(FakeData fakeData) {
        Toast.makeText(this, String.valueOf(fakeData.getId()), Toast.LENGTH_LONG).show();
    }
}
