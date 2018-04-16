package com.fpliu.newton.ui.dialog.list

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.fpliu.newton.ui.dialog.CustomDialog
import com.fpliu.newton.ui.list.IPullableRecyclerView
import com.fpliu.newton.ui.list.IRecyclerView
import com.fpliu.newton.ui.recyclerview.OnItemClickListener
import com.fpliu.newton.ui.recyclerview.adapter.ItemAdapter
import com.fpliu.newton.ui.recyclerview.holder.ItemViewHolder

abstract class RecyclerViewDialogProxy<T>(activity: Activity, private val recyclerView: IPullableRecyclerView<T>) : CustomDialog(activity), IRecyclerView<T> by recyclerView, OnItemClickListener<T> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(recyclerView) {
            setContentView(init(activity))
            canPullDown(false)
            canPullUp(false)
            pullableViewContainer?.stateView?.visibility = View.GONE
        }

        itemAdapter = object : ItemAdapter<T>(null) {

            override fun onBindLayout(parent: ViewGroup, viewType: Int): Int {
                return this@RecyclerViewDialogProxy.onBindLayout(parent, viewType)
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
                val itemViewHolder = super.onCreateViewHolder(parent, viewType)
                this@RecyclerViewDialogProxy.onCreateViewHolder(itemViewHolder, parent, viewType)
                return itemViewHolder
            }

            override fun onBindViewHolder(holder: ItemViewHolder, position: Int, item: T) {
                this@RecyclerViewDialogProxy.onBindViewHolder(holder, position, item)
            }

            override fun getItemViewType(position: Int): Int {
                return this@RecyclerViewDialogProxy.getItemViewType(position)
            }
        }
        setOnItemClickListener(this)
    }

    override fun onCreateViewHolder(itemViewHolder: ItemViewHolder, parent: ViewGroup, viewType: Int) {

    }

    override fun onItemClick(holder: ItemViewHolder, position: Int, item: T) {

    }
}
