package com.coffeestore.service;

import com.coffeestore.model.MenuItem;
import com.coffeestore.vo.Bill;

import java.util.List;

/**
 * Coffee store service
 */
public interface ICoffeeStoreService {

    Bill placeOrder(List<MenuItem> items);

}
