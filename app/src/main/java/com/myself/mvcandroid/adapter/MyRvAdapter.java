package com.myself.mvcandroid.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.myself.mvcandroid.ListItemViewMvc;
import com.myself.mvcandroid.ListItemViewMvcImpl;
import com.myself.mvcandroid.model.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 3/10/2019.
 */

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyViewHolder>
        implements ListItemViewMvc.Listener {

    private List<Data> mDataList;
    private final LayoutInflater mInflater;
    private final Listener mListener;

    public MyRvAdapter(LayoutInflater inflater, Listener listener) {
        mInflater = inflater;
        mListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemViewMvc viewMvc = new ListItemViewMvcImpl(mInflater, parent);
        viewMvc.registerListener(this);
        return new MyViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.mViewMvc.bindData(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public void onDataClicked(Data data) {
        mListener.onDataClicked(data);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private final ListItemViewMvc mViewMvc;

        public MyViewHolder(ListItemViewMvc viewMvc) {
            super(viewMvc.getRootView());
            mViewMvc = viewMvc;
        }
    }

    public interface Listener {
        void onDataClicked(Data data);
    }

    public void bindData(List<Data> questions) {
        mDataList = new ArrayList<>(questions);
        notifyDataSetChanged();
    }
}

