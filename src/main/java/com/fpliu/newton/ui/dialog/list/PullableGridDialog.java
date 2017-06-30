package com.fpliu.newton.ui.dialog.list;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.fpliu.newton.ui.base.UIUtil;
import com.fpliu.newton.ui.dialog.CustomDialog;
import com.fpliu.newton.ui.list.IPullableList;
import com.fpliu.newton.ui.list.ItemAdapter;
import com.fpliu.newton.ui.list.PullableGridImpl;
import com.fpliu.newton.ui.pullable.PullableGridView;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;
import com.fpliu.newton.ui.pullable.Type;

import java.util.Collection;
import java.util.List;

/**
 * 可以下拉刷新和上拉加载更多
 *
 * @author 792793182@qq.com 2016-06-06.
 */
public abstract class PullableGridDialog<T> extends CustomDialog
        implements IPullableList<T, PullableGridView>,
        AdapterView.OnItemClickListener, RefreshOrLoadMoreCallback<PullableGridView> {

    private IPullableList<T, PullableGridView> pullableList;

    public PullableGridDialog(Activity activity) {
        super(activity);

        setWindowBackgroundColor(Color.WHITE);

        setWindowWidth(UIUtil.getScreenWidth(activity));

        pullableList = new PullableGridImpl<>();
        setContentView(pullableList.init(activity));
        setOnItemClickListener(this);
        setItemAdapterIfEmpty(new ItemAdapter<T>(null) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return PullableGridDialog.this.getItemView(position, convertView, parent);
            }

            @Override
            public int getViewTypeCount() {
                return PullableGridDialog.this.getItemViewTypeCount();
            }

            @Override
            public int getItemViewType(int position) {
                return PullableGridDialog.this.getItemViewType(position);
            }
        });
        setRefreshOrLoadMoreCallback(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void canPullDown(boolean canPullDown) {
        pullableList.canPullDown(canPullDown);
    }

    @Override
    public void canPullUp(boolean canPullUp) {
        pullableList.canPullUp(canPullUp);
    }

    @Override
    public void finishRequestSuccess(Type type, List<T> items) {
        pullableList.finishRequestSuccess(type, items);
    }

    @Override
    public void setRefreshOrLoadMoreCallback(RefreshOrLoadMoreCallback callback) {
        pullableList.setRefreshOrLoadMoreCallback(callback);
    }

    @Override
    public View init(Context context) {
        return pullableList.init(context);
    }

    @Override
    public PullableViewContainer<PullableGridView> getPullableViewContainer() {
        return pullableList.getPullableViewContainer();
    }

    @Override
    public void setItemAdapterIfEmpty(ItemAdapter<T> itemAdapter) {
        pullableList.setItemAdapterIfEmpty(itemAdapter);
    }

    @Override
    public void setItemAdapter(ItemAdapter<T> itemAdapter) {
        pullableList.setItemAdapter(itemAdapter);
    }

    @Override
    public ItemAdapter<T> getItemAdapter() {
        return pullableList.getItemAdapter();
    }

    @Override
    public void setItems(List<T> items) {
        pullableList.setItems(items);
    }

    @Override
    public List<T> getItems() {
        return pullableList.getItems();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return pullableList.addAll(collection);
    }

    @Override
    public boolean add(T item) {
        return pullableList.add(item);
    }

    @Override
    public T set(int location, T item) {
        return pullableList.set(location, item);
    }

    @Override
    public boolean remove(T item) {
        return pullableList.remove(item);
    }

    @Override
    public T getItem(int position) {
        return pullableList.getItem(position);
    }

    @Override
    public int getCount() {
        return pullableList.getCount();
    }

    @Override
    public void clear() {
        pullableList.clear();
    }

    @Override
    public int getItemViewTypeCount() {
        return pullableList.getItemViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return pullableList.getItemViewType(position);
    }

    @Override
    public void setDividerHeight(int height) {
        pullableList.setDividerHeight(height);
    }

    @Override
    public void setViewBeforeBody(int layoutId) {
        pullableList.setViewBeforeBody(layoutId);
    }

    @Override
    public void setViewBeforeBody(View view) {
        pullableList.setViewBeforeBody(view);
    }

    @Override
    public void setViewAfterBody(int layoutId) {
        pullableList.setViewAfterBody(layoutId);
    }

    @Override
    public void setViewAfterBody(View view) {
        pullableList.setViewAfterBody(view);
    }

    @Override
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        pullableList.setOnItemClickListener(listener);
    }
}
