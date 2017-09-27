package com.coffeestore.model;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * Class Menu Item represents a single item in the menu.
 */
public class MenuItem implements Serializable {

    /**
     * The menu item name
     */
    private String name;

    /**
     * The menu item type
     */
    private Type type;

    /**
     * The menu item cost
     */
    private double cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Represents menu type
     */
    public enum Type{
        FOOD,DRINK
    }

    /**
     * Serving
     */
    public enum Serving{
        HOT,COLD
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name",name)
                .add("type",type)
                .add("cost",cost)
                .toString();
    }

    /**
     * Builder class for MenuItem
     */
    public static final class Builder {
        private String name;
        private Type type;
        private double cost;

        private Builder() {
        }

        public static Builder aMenuItem() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withType(Type type) {
            this.type = type;
            return this;
        }

        public Builder withCost(double cost) {
            this.cost = cost;
            return this;
        }

        public MenuItem build() {
            MenuItem menuItem = new MenuItem();
            menuItem.setName(name);
            menuItem.setType(type);
            menuItem.setCost(cost);
            return menuItem;
        }
    }


}
