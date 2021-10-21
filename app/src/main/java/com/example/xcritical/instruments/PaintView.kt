package com.example.xcritical.instruments

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.xcritical.fragment.WalletFragment.Companion.brush
import com.example.xcritical.fragment.WalletFragment.Companion.path

class PaintView : View {

    constructor(context: Context) : this(context, null) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    var layout: ViewGroup.LayoutParams? = null

    companion object {
        var listPath = ArrayList<Path>()
        var listColor = ArrayList<Int>()
        var brushColor = Color.BLACK
    }

    private fun init() {
        brush.isAntiAlias = true
        brush.color = brushColor
        brush.style = Paint.Style.STROKE
        brush.strokeJoin = Paint.Join.ROUND
        brush.strokeWidth = 10f
        layout = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y

        when(event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x, y)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(x, y)
                listPath.add(path)
                listColor.add(brushColor)
            } else -> return false
        }
        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas?) {
        for (i in listPath.indices) {
            brush.color = listColor[i]
            canvas?.drawPath(listPath[i], brush)
            invalidate()
        }
    }

    fun clear() {
        listPath.clear()
        listColor.clear()
        path.reset()
    }
}