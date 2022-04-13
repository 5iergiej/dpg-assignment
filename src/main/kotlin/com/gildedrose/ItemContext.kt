package com.gildedrose

sealed class ItemContext {
    abstract var item: Item

    abstract fun updateQuality()
    abstract fun updateSellIn()

    data class Basic(
        override var item: Item
    ) : ItemContext() {
        init {
            require(item.quality in 0..50) { "Quality must be in range 0..50. $item." }
        }

        override fun updateQuality() {
            item.quality = BasicUpdateQualityStrategy.calculate(item)
        }

        override fun updateSellIn() {
            item.sellIn = BasicUpdateSellInStrategy.calculate(item)
        }
    }

    data class AgedBrie(
        override var item: Item
    ) : ItemContext() {
        init {
            require(item.quality in 0..50) { "Quality must be in range 0..50. $item." }
        }

        override fun updateQuality() {
            item.quality = AgedBrieUpdateQualityStrategy.calculate(item)
        }

        override fun updateSellIn() {
            item.sellIn = BasicUpdateSellInStrategy.calculate(item)
        }
    }

    data class Sulfuras(
        override var item: Item
    ) : ItemContext() {
        init {
            require(item.quality == 80) { "Quality must be 80. $item." }
        }

        override fun updateQuality() {
            item.quality = SulfurasUpdateQualityStrategy.calculate(item)
        }

        override fun updateSellIn() {
            item.sellIn = NotUpdateSellInStrategy.calculate(item)
        }
    }

    data class BackstagePasses(
        override var item: Item
    ) : ItemContext() {
        init {
            require(item.quality in 0..50) { "Quality must be in range 0..50. $item." }
        }

        override fun updateQuality() {
            item.quality = BackstagePassesUpdateQualityStrategy.calculate(item)
        }

        override fun updateSellIn() {
            item.sellIn = BasicUpdateSellInStrategy.calculate(item)
        }
    }

    data class Conjured(
        override var item: Item
    ) : ItemContext() {
        init {
            require(item.quality in 0..50) { "Quality must be in range 0..50. $item." }
        }

        override fun updateQuality() {
            item.quality = ConjuredUpdateQualityStrategy.calculate(item)
        }

        override fun updateSellIn() {
            item.sellIn = BasicUpdateSellInStrategy.calculate(item)
        }
    }
}
