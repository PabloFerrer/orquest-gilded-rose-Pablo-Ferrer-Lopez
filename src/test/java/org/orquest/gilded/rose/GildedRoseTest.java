package org.orquest.gilded.rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 0, 0),
            new Item("Quel'Serrar", 5, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49), 
            new Item("Conjured Mana Cake", 3, 16)};
        
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 10; i++) {
            app.updateQuality();    
        }
        
        for(Item item :items){
            if(!item.name.toLowerCase().contains("sulfuras")){
                assertTrue(item.quality<=50 && item.quality>=0, "Error while validating " + item + " quality.");
            } else {
                assertTrue(item.quality==80 && item.sellIn==0, "Error while validating Sulfuras, it must be immutable.");
            }
        }
    }

}
