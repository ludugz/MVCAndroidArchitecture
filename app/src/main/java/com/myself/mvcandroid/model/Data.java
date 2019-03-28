package com.myself.mvcandroid.model;

/**
 * Created by admin on 3/10/2019.
 */

public class Data {
    private String mTitle;
    private int mId;

    public Data(String mTitle, int mId) {
        this.mTitle = mTitle;
        this.mId = mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }
}
