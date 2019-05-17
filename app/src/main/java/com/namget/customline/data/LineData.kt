package com.namget.customline.data

interface LineItemInterface {
    val destination: String
    var distance: Int
}

data class LineData(
    override val destination: String,
    override var distance: Int = 1000
) : LineItemInterface

data class CurrentData(
    override val destination: String,
    override var distance: Int = 1000
) : LineItemInterface

data class destinData(
    override val destination: String,
    override var distance: Int = 1000
) : LineItemInterface