package com.fpliu.newton.ui.dialog.list

import android.app.Activity
import android.os.Bundle
import android.view.ViewGroup
import com.fpliu.newton.ui.dialog.CustomDialog
import com.fpliu.newton.ui.list.MyNestedScrollView
import com.fpliu.newton.ui.list.IPullableScrollViewRecyclerView
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback
import com.fpliu.newton.ui.recyclerview.OnItemClickListener
import com.fpliu.newton.ui.recyclerview.adapter.ItemAdapter
import com.fpliu.newton.ui.recyclerview.holder.ItemViewHolder

/**
 * 可以下拉刷新和上拉加载更多
 *
 * @author 792793182@qq.com 2016-06-06.
 */
abstract class PullableScrollViewRecyclerViewDialogProxy<T>(activity: Activity, private val pullableScrollViewRecyclerView: IPullableScrollViewRecyclerView<T>) : CustomDialog(activity), IPullableScrollViewRecyclerView<T> by pullableScrollViewRecyclerView, OnItemClickListener<T>, RefreshOrLoadMoreCallback<MyNestedScrollView> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(pullableScrollViewRecyclerView.init(activity))
        itemAdapter = object : ItemAdapter<T>(null) {

            override fun onBindLayout(parent: ViewGroup, viewType: Int): Int {
                return this@PullableScrollViewRecyclerViewDialogProxy.onBindLayout(parent, viewType)
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
                val itemViewHolder = super.onCreateViewHolder(parent, viewType)
                this@PullableScrollViewRecyclerViewDialogProxy.onCreateViewHolder(itemViewHolder, parent, viewType)
                return itemViewHolder
            }

            override fun onBindViewHolder(holder: ItemViewHolder, position: Int, payloads: MutableList<Any>) {
                if (payloads.isEmpty()) {
                    onBindViewHolder(holder, position)
                } else {
                    this@PullableScrollViewRecyclerViewDialogProxy.onBindViewHolder(holder, position, payloads)
                }
            }

            override fun onBindViewHolder(holder: ItemViewHolder, position: Int, item: T) {
                this@PullableScrollViewRecyclerViewDialogProxy.onBindViewHolder(holder, position, item)
            }

            override fun getItemViewType(position: Int): Int {
                return this@PullableScrollViewRecyclerViewDialogProxy.getItemViewType(position)
            }
        }
        setOnItemClickListener(this)
        setRefreshOrLoadMoreCallback(this)
    }

    override fun onCreateViewHolder(itemViewHolder: ItemViewHolder, viewGroup: ViewGroup, viewType: Int) {

    }

    override fun onItemClick(holder: ItemViewHolder, position: Int, item: T) {

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int, payloads: MutableList<Any>) {

    }
}
