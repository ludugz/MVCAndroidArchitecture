package com.myself.mvcandroid;

import com.myself.mvcandroid.common.ObservableViewMvc;
import com.myself.mvcandroid.model.Data;

import java.util.List;

/**
 * Created by admin on 3/20/2019.
 */

interface ListViewMvc extends ObservableViewMvc<ListViewMvc.Listener> {

    public interface Listener {
        void onDataClicked(Data data);
    }

    void bindDatas(List<Data> datas);

}

