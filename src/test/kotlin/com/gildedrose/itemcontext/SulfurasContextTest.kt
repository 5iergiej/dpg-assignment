package com.gildedrose.itemcontext

import com.gildedrose.Item
import com.gildedrose.ItemContext
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class SulfurasContextTest {
    @Test
    fun `sulfuras item can not be created with quality ne 80`() {
        assertThrows<IllegalArgumentException> {
            ItemContext.Sulfuras(Item("sulfuras item", 0, -1))
        }
    }

    @Test
    fun `sulfuras item is created correctly with quality eq 80`() {
        val item = ItemContext.Sulfuras(Item("sulfuras item", 0, 80))
        item.updateQuality()

        assertEquals(item.item.quality, 80)
    }

    @Test
    fun `sulfuras item quality is not changed when updated`() {
        val item = ItemContext.Sulfuras(Item("sulfuras item", 3, 80))
        item.updateQuality()

        assertEquals(item.item.quality, 80)
    }

    @Test
    fun `sulfuras item sellIn is updated correctly`() {
        val item = ItemContext.Sulfuras(Item("sulfuras item", 3, 80))
        item.updateSellIn()

        assertEquals(item.item.sellIn, 3)
    }
}


