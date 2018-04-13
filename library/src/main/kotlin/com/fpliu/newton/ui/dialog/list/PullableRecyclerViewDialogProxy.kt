package com.fpliu.newton.ui.dialog.list

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.fpliu.newton.ui.dialog.CustomDialog
import com.fpliu.newton.ui.list.IPullableRecyclerView
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback
import com.fpliu.newton.ui.recyclerview.OnItemClickListener
import com.fpliu.newton.ui.recyclerview.adapter.ItemAdapter
import com.fpliu.newton.ui.recyclerview.holder.ItemViewHolder

/**
 * 可以下拉刷新和上拉加载更多
 *
 * @author 792793182@qq.com 2016-06-06.
 */
abstract class PullableRecyclerViewDialogProxy<T>(activity: Activity, private val pullableRecyclerView: IPullableRecyclerView<T>) : CustomDialog(activity), IPullableRecyclerView<T> by pullableRecyclerView, OnItemClickListener<T>, RefreshOrLoadMoreCallback<RecyclerView> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(pullableRecyclerView.init(activity))
        itemAdapter = object : ItemAdapter<T>(null) {

            override fun onBindLayout(parent: ViewGroup, viewType: Int): Int {
                return this@PullableRecyclerViewDialogProxy.onBindLayout(parent, viewType)
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
                val itemViewHolder = super.onCreateViewHolder(parent, viewType)
                this@PullableRecyclerViewDialogProxy.onCreateViewHolder(itemViewHolder, parent, viewType)
                return itemViewHolder
            }

            override fun onBindViewHolder(holder: ItemViewHolder, position: Int, item: T) {
                this@PullableRecyclerViewDialogProxy.onBindViewHolder(holder, position, item)
            }

            override fun getItemViewType(position: Int): Int {
                return this@PullableRecyclerViewDialogProxy.getItemViewType(position)
            }
        }
        setOnItemClickListener(this)
        setRefreshOrLoadMoreCallback(this)
    }

    override fun onCreateViewHolder(itemViewHolder: ItemViewHolder, viewGroup: ViewGroup, viewType: Int) {

    }

    override fun onItemClick(holder: ItemViewHolder, position: Int, item: T) {

    }
}
