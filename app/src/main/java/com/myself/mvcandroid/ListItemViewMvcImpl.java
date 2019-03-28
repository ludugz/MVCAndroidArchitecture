package com.myself.mvcandroid;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myself.mvcandroid.common.BaseObservableViewMvc;
import com.myself.mvcandroid.model.Data;

/**
 * Created by admin on 3/20/2019.
 */

public class ListItemViewMvcImpl extends BaseObservableViewMvc<ListItemViewMvc.Listener>
        implements ListItemViewMvc {

    private final TextView mTxtTitle;
    private Data mData;

    public ListItemViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_question_list_item, parent, false));
        mTxtTitle = findViewById(R.id.txt_title);
        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Listener listener : getListeners()) {
                    listener.onDataClicked(mData);
                }
            }
        });
    }

    @Override
    public void bindData(Data data) {
        mData = data;
        mTxtTitle.setText(data.getTitle());
    }
}
