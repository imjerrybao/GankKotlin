package com.andy.kotlin.gank.adapter

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * CommonViewHolder<T>
 * @author andyqtchen <br></br>
 * *         创建日期：2017/6/7 17:59
</T> */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bindView(data: T, position: Int)
}
