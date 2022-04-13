package com.gildedrose.itemcontext

import com.gildedrose.Item
import com.gildedrose.ItemContext
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class AgedBrieContextTest {
    @Test
    fun `aged brie item can not be created with quality lt 0`() {
        assertThrows<IllegalArgumentException> {
            ItemContext.AgedBrie(Item("aged brie item", 0, -1))
        }
    }

    @Test
    fun `aged brie item can not be created with quality gt 50`() {
        assertThrows<IllegalArgumentException> {
            ItemContext.AgedBrie(Item("aged brie item", 0, 51))
        }
    }

    @Test
    fun `aged brie item is created correctly with quality in 0-50`() {
        val item = ItemContext.AgedBrie(Item("aged brie item", 0, 40))
        assertEquals(item.item.quality, 40)
    }

    @Test
    fun `aged brie item quality is updated correctly for sellIn gt 0`() {
        val item = ItemContext.AgedBrie(Item("aged brie item", 3, 40))
        item.updateSellIn()
        item.updateQuality()

        assertEquals(item.item.quality, 41)
    }

    @Test
    fun `aged brie item quality is updated correctly for sellIn le 0`() {
        val item = ItemContext.AgedBrie(Item("aged brie item", 0, 40))
        item.updateSellIn()
        item.updateQuality()

        assertEquals(item.item.quality, 42)
    }

    @Test
    fun `aged brie item sellIn is updated correctly`() {
        val item = ItemContext.AgedBrie(Item("aged brie item", 3, 40))
        item.updateSellIn()

        assertEquals(item.item.sellIn, 2)
    }
}


