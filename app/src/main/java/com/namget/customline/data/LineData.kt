package com.namget.customline.data

interface LineItemInterface {
    val destination: String
}

data class LineData(
    override val destination: String,
    val distance: Int = 1000
) : LineItemInterface

data class CurrentData(
    override val destination: String
) : LineItemInterface

data class destinData(
    override val destination: String
) : LineItemInterface