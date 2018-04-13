package com.fpliu.newton.ui.dialog.list

import android.app.Activity
import com.fpliu.newton.ui.list.PullableGridImpl

/**
 *
 * @author 792793182@qq.com 2018-04-13.
 */
abstract class PullableGridDialog<T>(activity: Activity) : PullableGridDialogProxy<T>(activity, PullableGridImpl<T>())