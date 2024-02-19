package org.orquest.gilded.rose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if("Aged Brie".equals(item.name)){
                item = updateBrieItem(item);
            } else if(item.name.toLowerCase().contains("backstage")){
                item = updateBackStageItem(item);
            } else if(item.name.toLowerCase().contains("conjured")){
                item = updateConjuredItem(item);
            } else if(!item.name.toLowerCase().contains("sulfuras")){
                item = updateGenericItem(item);
            }
            if(!item.name.toLowerCase().contains("sulfuras")){
                if(item.quality>50){
                    item.quality = 50;
                }else if(item.quality<0){
                    item.quality = 0;
                }
                item.sellIn--;
            }
        }
    }

    private boolean checkQuality(Item item){

        return item.quality<=50 && item.quality>=0;
    }

    private boolean checkSellIn(Item item){
        return item.sellIn>0;
    }

    private Item updateBrieItem(Item item){
        if(checkQuality(item)){
            if(checkSellIn(item)){
                item.quality++;                            
            }else{
                item.quality += 2;
            }
        }
        return item; 
    }

    private Item updateBackStageItem(Item item){
        if(checkQuality(item)){
            if(!checkSellIn(item)){
                item.quality = 0;
            }else if(item.sellIn<=5){
                item.quality+=3;
                
            }else if(item.sellIn<=10){
                item.quality+=2;
            }else{
                item.quality++;   
            }

        }
        return item;
    }

    private Item updateConjuredItem(Item item){
        if(checkQuality(item)){
            if(checkSellIn(item)){
                item.quality -= 2;                            
            }else{
                item.quality -= 4;
            }
        }
        return item; 
    }  

    private Item updateGenericItem(Item item){
        if(checkQuality(item)){
            if(checkSellIn(item)){
                item.quality--;                            
            }else{
                item.quality -= 2;
            }
        }
        return item; 
    }


}
