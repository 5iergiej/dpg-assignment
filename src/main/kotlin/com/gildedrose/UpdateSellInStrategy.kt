package com.gildedrose

abstract class UpdateSellInStrategy {
    abstract fun calculate(item: Item): Int
}

class BasicUpdateSellInStrategy {
    companion object : UpdateSellInStrategy() {
        override fun calculate(item: Item): Int = item.sellIn - 1
    }
}

class NotUpdateSellInStrategy {
    companion object : UpdateSellInStrategy() {
        override fun calculate(item: Item): Int = item.sellIn
    }
}
