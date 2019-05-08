package com.namget.customline

interface LineItemInterface {
    val destination: String
}

data class LineData(override val destination: String) : LineItemInterface
data class CurrentData(override val destination: String) : LineItemInterface
data class destinData(override val destination: String) : LineItemInterface