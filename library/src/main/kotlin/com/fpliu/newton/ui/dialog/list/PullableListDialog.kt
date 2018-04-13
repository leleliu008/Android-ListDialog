package com.fpliu.newton.ui.dialog.list

import android.app.Activity
import com.fpliu.newton.ui.list.PullableListImpl

/**
 *
 * @author 792793182@qq.com 2018-04-13.
 */
abstract class PullableListDialog<T>(activity: Activity) : PullableListDialogProxy<T>(activity, PullableListImpl<T>())