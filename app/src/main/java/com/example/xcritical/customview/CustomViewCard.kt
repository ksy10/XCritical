package com.example.xcritical.customview


import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.xcritical.R


class CustomViewCard(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    init {
        val root = inflate(context, R.layout.view_custom_card, this)
    }

}