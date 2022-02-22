package com.example.tipscalculator.domain.models

import androidx.core.content.contentValuesOf
import com.example.tipscalculator.core.Constants

data class TipsCalculation(private val subtotal: Double, private val tipsPercent: Int) {

    val tipsAmount = subtotal * (tipsPercent.toFloat() / Constants.PERCENT)
    val TPS = subtotal * Constants.TPS
    val TVQ = subtotal * Constants.TVQ
    val total = subtotal + TPS + TVQ + tipsAmount
}