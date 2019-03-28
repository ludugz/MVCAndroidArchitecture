package com.myself.mvcandroid.common;

/**
 * Created by admin on 3/20/2019.
 */

public interface ObservableViewMvc<ListenerType> extends ViewMvc {

    void registerListener(ListenerType listener);

    void unregisterListener(ListenerType listener);
}