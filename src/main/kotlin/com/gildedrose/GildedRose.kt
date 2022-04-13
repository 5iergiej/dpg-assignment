package com.gildedrose

class GildedRose(var items: Array<Item>) {

    /**
     * This will update both quality and sellIn properties for all the items
     */
    fun updateQuality() {
        items.map { item ->
            item.context().let { context ->
                context.updateSellIn()
                context.updateQuality()
            }
        }
    }
}
