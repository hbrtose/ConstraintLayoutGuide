package com.hubose.constraintlayoutguide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.task_fragment.view.*
import java.lang.RuntimeException

class RecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val HEADER = 0
        const val ITEM = 1
        const val FOOTER = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            HEADER -> HeaderHolder(LayoutInflater.from(parent.context).inflate(R.layout.header_item, parent, false))
            FOOTER -> FooterHolder(LayoutInflater.from(parent.context).inflate(R.layout.footer_item, parent, false))
            ITEM -> RecyclerHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_fragment, parent, false))
            else -> throw RuntimeException("Unknown view type")
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is RecyclerHolder) {
            holder.bind(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> HEADER
            9 -> FOOTER
            else -> ITEM
        }
    }

    class RecyclerHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(number: Int) {
            view.textView8.text = number.toString()
        }
    }

    class HeaderHolder(view: View): RecyclerView.ViewHolder(view)
    class FooterHolder(view: View): RecyclerView.ViewHolder(view)
}