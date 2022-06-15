package main.java.com.gildedrose;

public class ConjuredItemHandler extends ItemHandler {
    @Override
    protected void decrementQuality(Item item) {
        super.decrementQuality(item, 2);
    }
}
