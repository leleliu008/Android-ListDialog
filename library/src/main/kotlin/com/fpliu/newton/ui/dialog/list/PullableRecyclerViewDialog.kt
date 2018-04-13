package com.fpliu.newton.ui.dialog.list

import android.app.Activity
import com.fpliu.newton.ui.list.PullableRecyclerViewImpl

/**
 *
 * @author 792793182@qq.com 2018-04-13.
 */
abstract class PullableRecyclerViewDialog<T>(activity: Activity) : PullableRecyclerViewDialogProxy<T>(activity, PullableRecyclerViewImpl<T>())