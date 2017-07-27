package com.fpliu.newton.ui.dialog.list;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.dialog.CustomDialog;
import com.fpliu.newton.ui.list.IPullableRecyclerView;
import com.fpliu.newton.ui.list.PullableRecyclerViewImpl;
import com.fpliu.newton.ui.pullable.PullType;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;
import com.fpliu.newton.ui.recyclerview.ItemAdapter;
import com.fpliu.newton.ui.recyclerview.ItemViewHolderAbs;
import com.fpliu.newton.ui.recyclerview.OnItemClickListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 可以下拉刷新和上拉加载更多
 *
 * @author 792793182@qq.com 2016-06-06.
 */
public abstract class PullableRecyclerViewDialog<T, H extends ItemViewHolderAbs> extends CustomDialog
        implements IPullableRecyclerView<T, H>, OnItemClickListener<T, H>, RefreshOrLoadMoreCallback<RecyclerView> {

    private IPullableRecyclerView<T, H> pullableRecyclerView;

    public PullableRecyclerViewDialog(Activity activity) {
        super(activity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pullableRecyclerView = new PullableRecyclerViewImpl<>();
        setContentView(pullableRecyclerView.init(getActivity()));
        setItemAdapter(new ItemAdapter<T, H>(null) {
            @Override
            public H onCreateViewHolder(ViewGroup parent, int viewType) {
                return PullableRecyclerViewDialog.this.onCreateViewHolder(parent, viewType);
            }

            @Override
            public void onBindViewHolder(H holder, int position, T item) {
                PullableRecyclerViewDialog.this.onBindViewHolder(holder, position, item);
            }

            @Override
            public int getItemViewType(int position) {
                return PullableRecyclerViewDialog.this.getItemViewType(position);
            }
        });
        setOnItemClickListener(this);
        setRefreshOrLoadMoreCallback(this);
    }

    @Override
    public void canPullDown(boolean canPullDown) {
        pullableRecyclerView.canPullDown(canPullDown);
    }

    @Override
    public void canPullUp(boolean canPullUp) {
        pullableRecyclerView.canPullUp(canPullUp);
    }

    @Override
    public void finishRequestSuccess(PullType type, List<T> items) {
        pullableRecyclerView.finishRequestSuccess(type, items);
    }

    @Override
    public void finishRequestSuccess(PullType type, List<T> items, String s) {
        pullableRecyclerView.finishRequestSuccess(type, items, s);
    }

    @Override
    public void setRefreshOrLoadMoreCallback(RefreshOrLoadMoreCallback callback) {
        pullableRecyclerView.setRefreshOrLoadMoreCallback(callback);
    }

    @Override
    public View init(Context context) {
        return pullableRecyclerView.init(context);
    }

    @Override
    public PullableViewContainer<RecyclerView> getPullableViewContainer() {
        return pullableRecyclerView.getPullableViewContainer();
    }

    @Override
    public void setItemAdapter(ItemAdapter<T, H> itemAdapter) {
        pullableRecyclerView.setItemAdapter(itemAdapter);
    }

    @Override
    public ItemAdapter<T, H> getItemAdapter() {
        return pullableRecyclerView.getItemAdapter();
    }

    @Override
    public void setItems(List<T> items) {
        pullableRecyclerView.setItems(items);
    }

    @Override
    public List<T> getItems() {
        return pullableRecyclerView.getItems();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return pullableRecyclerView.addAll(collection);
    }

    @Override
    public boolean add(T item) {
        return pullableRecyclerView.add(item);
    }

    @Override
    public T set(int location, T item) {
        return pullableRecyclerView.set(location, item);
    }

    @Override
    public T getItem(int position) {
        return pullableRecyclerView.getItem(position);
    }

    @Override
    public int getItemCount() {
        return pullableRecyclerView.getItemCount();
    }

    @Override
    public boolean remove(T item) {
        return pullableRecyclerView.remove(item);
    }

    @Override
    public boolean removeThenShowActionIfEmpty(T item, CharSequence tipText, String actionBtnText, Runnable action) {
        return pullableRecyclerView.removeThenShowActionIfEmpty(item, tipText, actionBtnText, action);
    }

    @Override
    public void clear() {
        pullableRecyclerView.clear();
    }

    @Override
    public void clearThenShowAction(CharSequence tipText, String actionBtnText, Runnable action) {
        pullableRecyclerView.clearThenShowAction(tipText, actionBtnText, action);
    }

    @Override
    public int getItemViewType(int position) {
        return pullableRecyclerView.getItemViewType(position);
    }

    @Override
    public void notifyDataSetChanged() {
        pullableRecyclerView.notifyDataSetChanged();
    }

    @Override
    public void refresh() {
        pullableRecyclerView.refresh();
    }

    @Override
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        pullableRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        pullableRecyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void removeItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        pullableRecyclerView.removeItemDecoration(itemDecoration);
    }

    @Override
    public ArrayList<RecyclerView.ItemDecoration> getItemDecorations() {
        return pullableRecyclerView.getItemDecorations();
    }

    @Override
    public void clearItemDecorations() {
        pullableRecyclerView.clearItemDecorations();
    }

    @Override
    public void setItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
        pullableRecyclerView.setItemAnimator(itemAnimator);
    }

    @Override
    public void setViewBeforeBody(int layoutId) {
        pullableRecyclerView.setViewBeforeBody(layoutId);
    }

    @Override
    public void setViewBeforeBody(View view) {
        pullableRecyclerView.setViewBeforeBody(view);
    }

    @Override
    public void setViewAfterBody(int layoutId) {
        pullableRecyclerView.setViewAfterBody(layoutId);
    }

    @Override
    public void setViewAfterBody(View view) {
        pullableRecyclerView.setViewAfterBody(view);
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener<T, H> onItemClickListener) {
        pullableRecyclerView.setOnItemClickListener(onItemClickListener);
    }

    @Override
    public void onItemClick(H holder, int position, T item) {

    }
}
