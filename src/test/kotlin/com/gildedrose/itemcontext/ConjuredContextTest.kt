package com.gildedrose.itemcontext

import com.gildedrose.Item
import com.gildedrose.ItemContext
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ConjuredContextTest {
    @Test
    fun `conjured item can not be created with quality lt 0`() {
        assertThrows<IllegalArgumentException> {
            ItemContext.Conjured(Item("conjured item", 0, -1))
        }
    }

    @Test
    fun `conjured item can not be created with quality gt 50`() {
        assertThrows<IllegalArgumentException> {
            ItemContext.Conjured(Item("conjured item", 0, 51))
        }
    }

    @Test
    fun `conjured item is created correctly with quality in 0-50`() {
        val item = ItemContext.Conjured(Item("conjured item", 0, 40))
        assertEquals(item.item.quality, 40)
    }

    @Test
    fun `conjured item quality is updated correctly for values ge 1`() {
        val item = ItemContext.Conjured(Item("conjured item", 2, 5))
        item.updateQuality()

        assertEquals(item.item.quality, 3)
    }

    @Test
    fun `conjured item quality is updated correctly but never lt 0`() {
        val item = ItemContext.Conjured(Item("conjured item", 0, 1))
        item.updateQuality()

        assertEquals(item.item.quality, 0)
    }

    @Test
    fun `conjured item sellIn is updated correctly`() {
        val item = ItemContext.Conjured(Item("conjured item", 0, 1))
        item.updateSellIn()

        assertEquals(item.item.sellIn, -1)
    }
}


