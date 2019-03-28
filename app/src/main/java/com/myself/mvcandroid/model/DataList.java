package com.myself.mvcandroid.model;

import java.util.List;

/**
 * Created by admin on 3/20/2019.
 */

public class DataList {
    private final List<Data> mDataLists;

    public DataList(List<Data> dataList) {
        mDataLists = dataList;
    }

    public List<Data> getDataList() {
        return mDataLists;
    }
}
