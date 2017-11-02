package com.fpliu.newton.ui.dialog.list;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.dialog.CustomDialog;
import com.fpliu.newton.ui.list.IRecyclerView;
import com.fpliu.newton.ui.list.PullableRecyclerViewImpl;
import com.fpliu.newton.ui.recyclerview.OnItemClickListener;
import com.fpliu.newton.ui.recyclerview.adapter.ItemAdapter;
import com.fpliu.newton.ui.recyclerview.holder.ItemViewHolderAbs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class RecyclerViewDialog<T, H extends ItemViewHolderAbs> extends CustomDialog
        implements IRecyclerView<T, H>, OnItemClickListener<T, H> {

    private IRecyclerView<T, H> recyclerView;

    public RecyclerViewDialog(Activity activity) {
        super(activity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PullableRecyclerViewImpl pullableRecyclerView = new PullableRecyclerViewImpl<>();
        View contentView = pullableRecyclerView.init(getActivity());
        setContentView(contentView);
        recyclerView = pullableRecyclerView;
        pullableRecyclerView.canPullDown(false);
        pullableRecyclerView.canPullUp(false);
        pullableRecyclerView.getPullableViewContainer().getStateView().setVisibility(View.GONE);
        setItemAdapter(new ItemAdapter<T, H>(null) {

            @Override
            public H onCreateViewHolder(ViewGroup parent, int viewType) {
                return RecyclerViewDialog.this.onCreateViewHolder(parent, viewType);
            }

            public void onBindViewHolder(H holder, int position, T item) {
                RecyclerViewDialog.this.onBindViewHolder(holder, position, item);
            }

            @Override
            public int getItemViewType(int position) {
                return RecyclerViewDialog.this.getItemViewType(position);
            }
        });
        setOnItemClickListener(this);
    }

    @Override
    public View init(Context context) {
        return recyclerView.init(context);
    }

    @Override
    public void setItems(List<T> items) {
        recyclerView.setItems(items);
    }

    @Override
    public List<T> getItems() {
        return recyclerView.getItems();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return recyclerView.addAll(collection);
    }

    @Override
    public boolean add(T item) {
        return recyclerView.add(item);
    }

    @Override
    public T set(int location, T item) {
        return recyclerView.set(location, item);
    }

    @Override
    public T removeAt(int position) {
        return recyclerView.removeAt(position);
    }

    @Override
    public T removeLastItem() {
        return recyclerView.removeLastItem();
    }

    @Override
    public boolean remove(T item) {
        return recyclerView.remove(item);
    }

    @Override
    public void clear() {
        recyclerView.clear();
    }

    @Override
    public int getItemCount() {
        return recyclerView.getItemCount();
    }

    @Override
    public T getItem(int position) {
        return recyclerView.getItem(position);
    }

    @Override
    public T getLastItem() {
        return recyclerView.getLastItem();
    }

    @Override
    public void setViewBeforeBody(int layoutId) {
        recyclerView.setViewBeforeBody(layoutId);
    }

    @Override
    public void setViewBeforeBody(View view) {
        recyclerView.setViewBeforeBody(view);
    }

    @Override
    public void setViewAfterBody(int layoutId) {
        recyclerView.setViewAfterBody(layoutId);
    }

    @Override
    public void setViewAfterBody(View view) {
        recyclerView.setViewAfterBody(view);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView.getRecyclerView();
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener<T, H> onItemClickListener) {
        recyclerView.setOnItemClickListener(onItemClickListener);
    }

    @Override
    public void setItemAdapter(ItemAdapter<T, H> itemAdapter) {
        recyclerView.setItemAdapter(itemAdapter);
    }

    @Override
    public ItemAdapter<T, H> getItemAdapter() {
        return recyclerView.getItemAdapter();
    }

    @Override
    public int getItemViewType(int position) {
        return recyclerView.getItemViewType(position);
    }

    @Override
    public void notifyDataSetChanged() {
        recyclerView.notifyDataSetChanged();
    }

    @Override
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void setItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        recyclerView.setItemDecoration(itemDecoration);
    }

    @Override
    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        recyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void removeItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        recyclerView.removeItemDecoration(itemDecoration);
    }

    @Override
    public ArrayList<RecyclerView.ItemDecoration> getItemDecorations() {
        return recyclerView.getItemDecorations();
    }

    @Override
    public void clearItemDecorations() {
        recyclerView.clearItemDecorations();
    }

    @Override
    public void setItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
        recyclerView.setItemAnimator(itemAnimator);
    }

    @Override
    public void asList() {
        recyclerView.asList();
    }

    @Override
    public void asGrid(int columnNumber) {
        recyclerView.asGrid(columnNumber);
    }

    @Override
    public void onItemClick(H holder, int position, T item) {

    }
}
