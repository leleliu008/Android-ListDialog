package com.fpliu.newton.ui.list.sample

import android.app.Activity
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.fpliu.newton.log.Logger
import com.fpliu.newton.ui.base.UIUtil
import com.fpliu.newton.ui.dialog.list.PullableRecyclerViewDialog
import com.fpliu.newton.ui.pullable.PullType
import com.fpliu.newton.ui.pullable.PullableViewContainer
import com.fpliu.newton.ui.recyclerview.holder.ItemViewHolder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * RecyclerViewHelper使用示例
 * @author 792793182@qq.com 2018-03-28.
 */
class PullableRecyclerViewDialogExample(activity: Activity) : PullableRecyclerViewDialog<Pair<Int, String>>(activity) {

    companion object {
        private val TAG = PullableRecyclerViewDialogExample::class.java.simpleName
    }

    init {
        setWindowBackgroundColor(Color.WHITE)
        setWindowWidth(UIUtil.getScreenWidth(activity))
        setWindowHeight(UIUtil.getScreenHeight(activity) / 2)
    }

    override fun onRefreshOrLoadMore(pullableViewContainer: PullableViewContainer<RecyclerView>?, pullType: PullType, pageNum: Int, pageSize: Int) {
        Observable
            .just("")
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map {
                ArrayList<Pair<Int, String>>().apply {
                    repeat(10, {
                        add(Pair(it, it.toString()))
                    })
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                finishRequestSuccessWithErrorImageAndMessageIfItemsEmpty(pullType, it, R.drawable.ic_warnning, "暂无数据")
            }, { Logger.e(TAG, "", it) })
    }

    override fun onBindLayout(parent: ViewGroup?, viewType: Int): Int {
        return R.layout.item
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int, item: Pair<Int, String>) {
        holder.run {
            id(R.id.imageView).image("https://modao.cc/uploads/avatars/33224/profile_user-avatar.png", R.drawable.default_img)
            id(R.id.textView).text(item.second)
        }
    }
}