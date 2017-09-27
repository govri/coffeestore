package com.coffeestore.service.impl;

import com.coffeestore.model.MenuItem;
import com.coffeestore.repo.MenuItemRepository;
import com.coffeestore.service.ICoffeeStoreService;
import com.coffeestore.vo.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Coffee store service
 */
@Service
public class CoffeeStoreServiceImpl implements ICoffeeStoreService {

    private final MenuItemRepository menuItemRepository;

    /**
     * Autowire repository
     *
     * @param menuItemRepository MenuItemRepository
     */
    @Autowired
    public CoffeeStoreServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    /**
     * Return list of available menu items in store.
     *
     * @return List of menu items
     */
    public List<MenuItem> getAvailableItems(){
        return menuItemRepository.findAll();
    }

    /**
     * Constructs and returns Bill for the given menu items.
     *
     * @param items List of menu items
     * @return Bill
     */
    @Override
    public Bill placeOrder(final List<MenuItem> items) {

        return Bill.Builder.aBill()
                .withItemList(items)
                .build();

    }

}
