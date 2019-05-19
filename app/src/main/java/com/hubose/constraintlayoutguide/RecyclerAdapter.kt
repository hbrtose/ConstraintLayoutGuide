package com.hubose.constraintlayoutguide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.task_fragment.view.*

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder>() {

    companion object {
        const val HEADER = 0
        const val ITEM = 1
        const val FOOTER = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_fragment, parent, false)
        return RecyclerHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.bind(position)
    }


    class RecyclerHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(number: Int) {
            view.textView8.text = number.toString()
        }
    }
}