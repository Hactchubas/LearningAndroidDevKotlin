package com.example.learningandroiddevkotlin.listener

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView

class MoviesRecyclerItemClickListener(
    context : Context, val recyclerView : RecyclerView, listener : OnItemClickListener)
    : RecyclerView.OnItemTouchListener {

    private val mListener : OnItemClickListener = listener
    var mGestureDetector : GestureDetector
    init {
        mGestureDetector = GestureDetector(context, object :
            GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent): Boolean {
                return true
            }
            override fun onLongPress(e: MotionEvent) {
                val child = recyclerView.findChildViewUnder(e.x,e.y)
                if(child != null && mListener != null) {
                    mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
                }
            }
        })

    }
    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val childView : View? = rv.findChildViewUnder(e.x,e.y)
        if(childView != null  && mListener != null && mGestureDetector.onTouchEvent(e)){
            mListener.onItemClick(childView, rv.getChildAdapterPosition(childView))
            return true
        }
        return false
    }
    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) { }
    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) { }

    interface OnItemClickListener : AdapterView.OnItemClickListener{
        fun onItemClick(view : View, position : Int)
        fun onLongItemClick(view : View, position : Int)
    }

}



