package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

/**
 * This will resolve context for the Item based on item name.
 *
 * This method is rather expensive in terms of calculations
 * but right now the only way to calculate the item type is based on name.
 */
fun Item.context() = when {
    name.contains("Aged Brie", true) -> ItemContext.AgedBrie(this)
    name.contains("Sulfuras", true) -> ItemContext.Sulfuras(this)
    name.contains("Backstage passes", true) -> ItemContext.BackstagePasses(this)
    name.contains("Conjured", true) -> ItemContext.Conjured(this)
    else -> ItemContext.Basic(this)
}
