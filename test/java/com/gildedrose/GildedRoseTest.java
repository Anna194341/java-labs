package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void testToString() {
        Item item = new Item("foo", 10, 20);
        assertEquals("foo, 10, 20", item.toString());
    }

    @Test
    void QualityNeverNegative() {
        Item[] items = new Item[] { new Item("foo", -1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertTrue(items[0].quality >= 0);
    }

    @Test
    void QualityNeverExceedsFifty() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 5, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
        assertEquals(50, items[0].quality);
    }

    @Test
    void ordinaryItem_QualityDecreasesByOneWhenSellInPositive() {
        Item[] items = new Item[] { new Item("Ordinary item", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].quality);
    }

    @Test
    void ordinaryItem_QualityDecreasesByTwoWhenSellInNegative() {
        Item[] items = new Item[] { new Item("Ordinary item", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, items[0].quality);
    }

    @Test
    void agedBrie_QualityIncreasesByOneWhenSellInPositive() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, items[0].quality);
    }

    @Test
    void agedBrie_QualityIncreasesByTwoWhenSellInNegative() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, items[0].quality);
    }

    @Test
    void sulfuras_NeverChanges() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, items[0].quality);
        assertEquals(5, items[0].sellIn);
    }

    @Test
    void backstagePasses_QualityIncreasesByOneWhenSellInOverTen() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, items[0].quality);
    }

    @Test
    void backstagePasses_QualityIncreasesByTwoWhenSellInTenOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, items[0].quality);
    }

    @Test
    void backstagePasses_QualityIncreasesByThreeWhenSellInFiveOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, items[0].quality);
    }

    @Test
    void backstagePasses_QualityDropsToZeroAfterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }

    /*
    Тести для conjured items
    @Test
    void conjuredItem_QualityDecreasesByTwoWhenSellInPositive() {
        Item[] items = new Item[] { new Item("Conjured", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, items[0].quality);
    }

    @Test
    void conjuredItem_QualityDecreasesByFourWhenSellInNegative() {
        Item[] items = new Item[] { new Item("Conjured", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, items[0].quality);
    }

    */

}