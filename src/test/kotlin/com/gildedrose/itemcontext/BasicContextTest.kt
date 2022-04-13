package com.gildedrose.itemcontext

import com.gildedrose.Item
import com.gildedrose.ItemContext
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class BasicContextTest {
    @Test
    fun `basic item can not be created with quality lt 0`() {
        assertThrows<IllegalArgumentException> {
            ItemContext.Basic(Item("basic item", 0, -1))
        }
    }

    @Test
    fun `basic item can not be created with quality gt 50`() {
        assertThrows<IllegalArgumentException> {
            ItemContext.Basic(Item("basic item", 0, 51))
        }
    }

    @Test
    fun `basic item is created correctly with quality in 0-50`() {
        val item = ItemContext.Basic(Item("basic item", 0, 40))
        assertEquals(item.item.quality, 40)
    }

    @Test
    fun `basic item quality is updated correctly for sellIn gt 0`() {
        val item = ItemContext.Basic(Item("basic item", 3, 40))
        item.updateQuality()

        assertEquals(item.item.quality, 39)
    }

    @Test
    fun `basic item quality is updated correctly for sellIn le 0`() {
        val item = ItemContext.Basic(Item("basic item", 0, 40))
        item.updateQuality()

        assertEquals(item.item.quality, 38)
    }

    @Test
    fun `basic item sellIn is updated correctly`() {
        val item = ItemContext.Basic(Item("basic item", 0, 40))
        item.updateSellIn()

        assertEquals(item.item.sellIn, -1)
    }
}


