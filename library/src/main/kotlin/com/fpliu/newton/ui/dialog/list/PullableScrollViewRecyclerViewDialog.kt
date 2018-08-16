package com.fpliu.newton.ui.dialog.list

import android.app.Activity
import com.fpliu.newton.ui.list.PullableScrollViewRecyclerViewImpl

/**
 *
 * @author 792793182@qq.com 2018-04-13.
 */
abstract class PullableScrollViewRecyclerViewDialog<T>(activity: Activity) : PullableScrollViewRecyclerViewDialogProxy<T>(activity, PullableScrollViewRecyclerViewImpl<T>())