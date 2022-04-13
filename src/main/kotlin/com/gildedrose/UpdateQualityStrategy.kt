package com.gildedrose

abstract class UpdateQualityStrategy {
    abstract fun calculate(item: Item): Int
}

object BasicUpdateQualityStrategy : UpdateQualityStrategy() {
    override fun calculate(item: Item) =
        if (item.sellIn > 0) {
            item.quality - 1
        } else {
            item.quality - 2
        }.let { maxOf(it, 0) }
}

class AgedBrieUpdateQualityStrategy {
    companion object : UpdateQualityStrategy() {
        override fun calculate(item: Item) =
            if (item.sellIn >= 0) {
                item.quality + 1
            } else {
                item.quality + 2
            }.let { minOf(it, 50) }
    }
}

class SulfurasUpdateQualityStrategy {
    companion object : UpdateQualityStrategy() {
        override fun calculate(item: Item) = 80
    }
}

class BackstagePassesUpdateQualityStrategy {
    companion object : UpdateQualityStrategy() {
        override fun calculate(item: Item) =
            when {
                item.sellIn in 6..10 -> item.quality + 2
                item.sellIn in 0..5 -> item.quality + 3
                item.sellIn < 0 -> 0
                else -> item.quality + 1
            }.let { minOf(it, 50) }
    }
}

class ConjuredUpdateQualityStrategy {
    companion object : UpdateQualityStrategy() {
        override fun calculate(item: Item) =
            maxOf(item.quality - 2, 0)
    }
}
