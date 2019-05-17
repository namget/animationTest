package com.namget.customline

import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.namget.customline.data.CurrentData
import com.namget.customline.data.LineData
import com.namget.customline.data.LineItemInterface
import com.namget.customline.data.destinData
import com.namget.customline.databinding.ItemCurrentDotBinding
import com.namget.customline.databinding.ItemDestionationDotBinding
import com.namget.customline.databinding.ItemLineBinding


class LineAdapter(val lineItem: MutableList<LineItemInterface>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val TYPE_LINE = 0
    val TYPE_DESTIN_DOT = 1
    val TYPE_CURRENT = 2

    class LineHolder(val view: ItemLineBinding) : RecyclerView.ViewHolder(view.root) {
        var distance = 1000
        val distanceMinus = 10
        fun bind(item: LineItemInterface) {
            if (item is LineData) {

            }
        }

        fun changeLength() {
            Log.e("test", "changeLenth")
            val handler = Handler().postDelayed(
                Runnable {
                    if (distance - distanceMinus >= 0) {
                        distance -= distanceMinus
                        Log.e("test", "distance ${distance}")
                        view.lineLayout.layoutParams.height = distance
                        view.lineLayout.requestLayout()
                        changeLength()
                    }
                }, 1000
            )
        }

    }

    class DetinationDotHolder(val view: ItemDestionationDotBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: LineItemInterface) {

        }
    }

    class CurrentDotHolder(val view: ItemCurrentDotBinding) : RecyclerView.ViewHolder(view.root) {
        var anim: Animation
        var anim2: Animation

        init {
            anim = AnimationUtils.loadAnimation(view.root.context, R.anim.scale_anim).apply {
                repeatCount = Animation.INFINITE
                repeatMode = Animation.REVERSE
            }
            anim2 = AnimationUtils.loadAnimation(view.root.context, R.anim.scale_anim2).apply {
                repeatCount = Animation.INFINITE
                repeatMode = Animation.REVERSE
            }
        }

        fun bind(item: LineItemInterface) {

        }

        fun animate() {
            view.currentDot2.startAnimation(anim)
            view.currentDot3.startAnimation(anim2)
        }

        fun clearAnimate() {
            view.currentDot2.clearAnimation()
            view.currentDot3.clearAnimation()
        }
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        if (getItemViewType(holder.adapterPosition) == TYPE_CURRENT) {
            (holder as LineAdapter.CurrentDotHolder).animate()
        }
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        if (getItemViewType(holder.adapterPosition) == TYPE_CURRENT) {
            (holder as LineAdapter.CurrentDotHolder).clearAnimate()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_LINE -> {
                val view: ItemLineBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_line,
                    parent,
                    false
                )
                return LineAdapter.LineHolder(view)
            }
            TYPE_DESTIN_DOT -> {
                val view: ItemDestionationDotBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_destionation_dot,
                    parent,
                    false
                )
                return LineAdapter.DetinationDotHolder(view)
            }
            TYPE_CURRENT -> {
                val view: ItemCurrentDotBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_current_dot,
                    parent,
                    false
                )
                return LineAdapter.CurrentDotHolder(view)
            }
            else -> {
                throw Exception()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        when (lineItem[position]) {
            is LineData -> return TYPE_LINE
            is destinData -> return TYPE_DESTIN_DOT
            is CurrentData -> return TYPE_CURRENT
            else -> {
                throw Exception()
            }
        }
    }

    override fun getItemCount(): Int = lineItem.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_LINE -> {
                (holder as LineAdapter.LineHolder).bind(lineItem[position])
                if(position == 1)
                (holder as LineAdapter.LineHolder).changeLength()
            }
            TYPE_DESTIN_DOT -> {
                (holder as LineAdapter.DetinationDotHolder).bind(lineItem[position])
            }
            TYPE_CURRENT -> {
                (holder as LineAdapter.CurrentDotHolder).bind(lineItem[position])
            }
            else -> {
                throw Exception()
            }
        }
    }
}