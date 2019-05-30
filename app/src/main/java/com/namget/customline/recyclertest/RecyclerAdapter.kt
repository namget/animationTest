package com.namget.customline.recyclertest

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.namget.customline.R
import com.namget.customline.data.CurrentData
import com.namget.customline.data.LineData
import com.namget.customline.data.LineItemInterface
import com.namget.customline.data.destinData
import com.namget.customline.databinding.ItemDestinationDotBinding
import com.namget.customline.databinding.ItemLineBinding


class RecyclerAdapter(val lineItem: MutableList<LineItemInterface>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val TYPE_LINE = 0
    val TYPE_DESTIN_DOT = 1
    val TYPE_CURRENT = 2

    private var CURRENT_POSITION = 0

    interface ViewHolderInf {
        fun bind(item: LineItemInterface)
    }

    class LineHolder(val view: ItemLineBinding) : RecyclerView.ViewHolder(view.root),
        ViewHolderInf {
        var distance = 0
        val distanceMinus = 10


        override fun bind(item: LineItemInterface) {
            if (item is LineData) {
                distance = item.distance
                view.lineLayout.layoutParams.height = distance
                view.lineLayout.requestLayout()
            }
        }

    }

    fun getCurrentPosition(): Int = CURRENT_POSITION

    class DetinationDotHolder(val view: ItemDestinationDotBinding) : RecyclerView.ViewHolder(view.root),
        ViewHolderInf {
        var distance: Int = view.itemDestinLayout.layoutParams.height
        val distanceMinus = 10


        override fun bind(item: LineItemInterface) {

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
                return LineHolder(view)
            }
            TYPE_DESTIN_DOT -> {
                val view: ItemDestinationDotBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_destination_dot,
                    parent,
                    false
                )
                return DetinationDotHolder(view)

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
        Log.e("onBindViewHolder", "position : " + position)
        when (getItemViewType(position)) {
            TYPE_LINE -> {
                (holder as LineHolder).bind(lineItem[position])
            }
            TYPE_DESTIN_DOT -> {
                (holder as DetinationDotHolder).bind(lineItem[position])
            }
            else -> {
                throw Exception()
            }
        }
    }
}