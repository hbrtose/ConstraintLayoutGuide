package com.hubose.constraintlayoutguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_fragment.*

class RecyclerFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.recycler_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler.adapter = RecyclerAdapter()
        recycler.layoutManager = LinearLayoutManager(context)
        val dividerItemDecoration = DividerItemDecoration(
            recycler.context,
            LinearLayoutManager.VERTICAL
        )
        recycler.addItemDecoration(dividerItemDecoration)
    }
}