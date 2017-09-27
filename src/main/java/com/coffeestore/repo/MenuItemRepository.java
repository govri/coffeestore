package com.coffeestore.repo;

import com.coffeestore.model.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository for menu items
 */
@Repository
public class MenuItemRepository {

    /**
     * Find and return all available menu items.
     *
     * @return List of menu items
     */
    public List<MenuItem> findAll(){

        List<MenuItem> list= new ArrayList<>();

        list.add(
                MenuItem.Builder.aMenuItem()
                .withCost(.50)
                .withName("Cola")
                .withType(MenuItem.Type.DRINK)
                .build()
        );

        list.add(
                MenuItem.Builder.aMenuItem()
                        .withCost(1.00)
                        .withName("Coffee")
                        .withType(MenuItem.Type.DRINK)
                        .build()
        );

        list.add(
                MenuItem.Builder.aMenuItem()
                        .withCost(2.00)
                        .withName("Cheese Sandwich")
                        .withType(MenuItem.Type.FOOD)
                        .build()
        );

        list.add(
                MenuItem.Builder.aMenuItem()
                        .withCost(4.50)
                        .withName("Steak Sandwich")
                        .withType(MenuItem.Type.FOOD)
                        .build()
        );

        return list;

    }

}
