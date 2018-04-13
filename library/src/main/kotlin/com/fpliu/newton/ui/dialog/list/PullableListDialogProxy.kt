package com.fpliu.newton.ui.dialog.list

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import com.fpliu.newton.ui.dialog.CustomDialog
import com.fpliu.newton.ui.list.IPullableListView
import com.fpliu.newton.ui.list.ItemAdapter
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback

/**
 * 可以下拉刷新和上拉加载更多
 *
 * @author 792793182@qq.com 2016-06-06.
 */
abstract class PullableListDialogProxy<T>(activity: Activity, private val pullableListView: IPullableListView<T>) : CustomDialog(activity), IPullableListView<T> by pullableListView, AdapterView.OnItemClickListener, RefreshOrLoadMoreCallback<ListView> {

    private var headerView: View? = null

    private var headerData: Any? = null

    private var headerIsSelectable: Boolean = false

    private var footerView: View? = null

    private var footerData: Any? = null

    private var footerIsSelectable: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(pullableListView.init(activity))
        setOnItemClickListener(this)

        if (headerView != null) {
            pullableListView.addHeaderView(headerView, headerData, headerIsSelectable)
        }

        if (footerView != null) {
            pullableListView.addHeaderView(footerView, footerData, footerIsSelectable)
        }

        itemAdapter = object : ItemAdapter<T>(null) {
            override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
                return this@PullableListDialogProxy.getItemView(position, convertView, parent)
            }

            override fun getViewTypeCount(): Int {
                return this@PullableListDialogProxy.itemViewTypeCount
            }

            override fun getItemViewType(position: Int): Int {
                return this@PullableListDialogProxy.getItemViewType(position)
            }
        }
        setRefreshOrLoadMoreCallback(this)
    }


    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {

    }

    //必须在super.onCreate()之前调用
    override fun addHeaderView(view: View, data: Any, isSelectable: Boolean) {
        this.headerView = view
        this.headerData = data
        this.headerIsSelectable = isSelectable
    }

    //必须在super.onCreate()之前调用
    override fun addFooterView(view: View, data: Any, isSelectable: Boolean) {
        this.footerView = view
        this.footerData = data
        this.footerIsSelectable = isSelectable
    }
}
