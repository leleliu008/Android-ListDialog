package com.fpliu.newton.ui.dialog.list

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import com.fpliu.newton.ui.dialog.CustomDialog
import com.fpliu.newton.ui.list.IPullableGridView
import com.fpliu.newton.ui.list.ItemAdapter
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback

/**
 * 可以下拉刷新和上拉加载更多
 *
 * @author 792793182@qq.com 2016-06-06.
 */
abstract class PullableGridDialogProxy<T>(activity: Activity, private val pullableGridView: IPullableGridView<T>) : CustomDialog(activity), IPullableGridView<T> by pullableGridView, AdapterView.OnItemClickListener, RefreshOrLoadMoreCallback<GridView> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(pullableGridView.init(activity))
        setOnItemClickListener(this)
        itemAdapter = object : ItemAdapter<T>(null) {
            override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
                return this@PullableGridDialogProxy.getItemView(position, convertView, parent)
            }

            override fun getViewTypeCount(): Int {
                return this@PullableGridDialogProxy.itemViewTypeCount
            }

            override fun getItemViewType(position: Int): Int {
                return this@PullableGridDialogProxy.getItemViewType(position)
            }
        }
        setRefreshOrLoadMoreCallback(this)
    }


    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {

    }
}
