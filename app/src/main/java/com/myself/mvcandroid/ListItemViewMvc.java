package com.myself.mvcandroid;

import com.myself.mvcandroid.common.ObservableViewMvc;
import com.myself.mvcandroid.model.Data;

/**
 * Created by admin on 3/20/2019.
 */

public interface ListItemViewMvc extends ObservableViewMvc<ListItemViewMvc.Listener> {

    public interface Listener{
        void onDataClicked(Data data);
    }

    void bindData(Data data);
}
