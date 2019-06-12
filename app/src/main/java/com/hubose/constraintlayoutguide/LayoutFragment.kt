package com.hubose.constraintlayoutguide

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.drawable.*
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_fragment.*

class LayoutFragment: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.layout_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layers = layerList.drawable as LayerDrawable
        layers.getDrawable(1).alpha = 120



        val transitionDrawable = main_layout.background as TransitionDrawable
        button.setOnClickListener {
            transition(button, transitionDrawable, true)
        }
        button2.setOnClickListener {
            transition(button2, transitionDrawable, false)
        }


        val levels = level_list.drawable as LevelListDrawable
        levels.level = 5
    }

    private fun transition(button: Button, transitionDrawable: TransitionDrawable, forward: Boolean) {
        button.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.rotator, 0)
        val progress = button.compoundDrawables[2] as RotateDrawable //0 - left, 1 - top, 2 - right, 3 - bottom
        val animator = ObjectAnimator.ofInt(progress, "level", 0, 10000)
        animator.repeatCount = ValueAnimator.INFINITE
        animator.duration = 500
        animator.start()
        if(forward) {
            transitionDrawable.startTransition(1000)
        } else {
            transitionDrawable.reverseTransition(1000)
        }
        Handler().postDelayed(
            {
                animator.cancel()
                button.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0)
            }, 1000)
    }
}