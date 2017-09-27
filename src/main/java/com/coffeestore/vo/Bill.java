package com.coffeestore.vo;

import com.coffeestore.model.MenuItem;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents Bill
 */
public class Bill implements Serializable {

    /**
     * The menu item list
     */
    private List<MenuItem> itemList=new ArrayList<>();

    /**
     * Menu items ordered.
     *
     * @return List of menu items
     */
    public List<MenuItem> getItemList() {
        return itemList;
    }

    /**
     * Set order items.
     *
     * @param itemList List of menu items
     */
    public void setItemList(List<MenuItem> itemList) {
        this.itemList = itemList;
    }

    /**
     * Calculate and return total cost.
     *
     * @return Cost of order
     */
    public double getTotalCost() {
        return getItemList().stream().mapToDouble(MenuItem::getCost).sum();
    }

    @Override
    public String toString() {

        return MoreObjects.toStringHelper(this)
                .add("itemList", itemList)
                .add("cost", getTotalCost())
                .toString();
    }

    /**
     * Builder class for Bill
     */
    public static final class Builder {

        /**
         * The item list
         */
        private List<MenuItem> itemList;

        private Builder() {
            //Private constructor
        }

        public static Builder aBill() {
            return new Builder();
        }

        public Builder withItem(MenuItem item) {
            if (this.itemList == null) {
                itemList = new ArrayList<>();
            }
            this.itemList.add(item);
            return this;
        }

        public Builder withItemList(List<MenuItem> itemList) {
            this.itemList = itemList;
            return this;
        }

        public Bill build() {
            Bill bill = new Bill();
            bill.setItemList(itemList);
            return bill;
        }
    }
}
