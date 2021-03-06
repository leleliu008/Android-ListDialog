package com.fpliu.newton.ui.list.sample

import android.app.Application
import android.widget.ImageView
import com.fpliu.newton.ui.recyclerview.holder.ItemViewHolder

/**
 *
 * @author 792793182@qq.com 2018-03-28.
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        ItemViewHolder.setImageLoader(object : ItemViewHolder.ImageLoader {
            override fun image(imageView: ImageView?, resId: Int) {

            }

            override fun image(imageView: ImageView?, resource: String?, defaultImg: Int) {

            }

            override fun imageCircle(imageView: ImageView?, resId: Int) {

            }

            override fun imageCircle(imageView: ImageView?, resource: String?, defaultImg: Int) {

            }

            override fun imageRoundRect(imageView: ImageView?, resId: Int, radius: Int) {

            }

            override fun imageRoundRect(imageView: ImageView?, resource: String?, defaultImg: Int, radius: Int) {

            }
        })
    }
}