package com.gildedrose.itemcontext

import com.gildedrose.Item
import com.gildedrose.ItemContext
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class BackstagePassesContextTest {
    @Test
    fun `backstage passes item can not be created with quality lt 0`() {
        assertThrows<IllegalArgumentException> {
            ItemContext.BackstagePasses(Item("backstage passes item", 0, -1))
        }
    }

    @Test
    fun `backstage passes item can not be created with quality gt 50`() {
        assertThrows<IllegalArgumentException> {
            ItemContext.BackstagePasses(Item("backstage passes item", 0, 51))
        }
    }

    @Test
    fun `backstage passes item is created correctly with quality in 0-50`() {
        val item = ItemContext.BackstagePasses(Item("backstage passes item", 0, 40))
        assertEquals(item.item.quality, 40)
    }

    @Test
    fun `backstage passes item quality is updated correctly for sellIn in 10-infinity`() {
        val item = ItemContext.BackstagePasses(Item("backstage passes item", 11, 40))
        item.updateQuality()

        assertEquals(item.item.quality, 41)
    }

    @Test
    fun `backstage passes item quality is updated correctly for sellIn in 6-10`() {
        val item = ItemContext.BackstagePasses(Item("backstage passes item", 10, 40))
        item.updateQuality()

        assertEquals(item.item.quality, 42)
    }

    @Test
    fun `backstage passes item quality is updated correctly for sellIn in 0-5`() {
        val item = ItemContext.BackstagePasses(Item("backstage passes item", 5, 40))
        item.updateQuality()

        assertEquals(item.item.quality, 43)
    }

    @Test
    fun `backstage passes item quality is updated correctly for sellIn lt 0`() {
        val item = ItemContext.BackstagePasses(Item("backstage passes item", -1, 40))
        item.updateQuality()

        assertEquals(item.item.quality, 0)
    }

    @Test
    fun `backstage passes item sellIn is updated correctly`() {
        val item = ItemContext.BackstagePasses(Item("backstage passes item", 3, 40))
        item.updateSellIn()

        assertEquals(item.item.sellIn, 2)
    }
}


