package com.coffeestore.service.impl;

import com.coffeestore.model.MenuItem;
import com.coffeestore.repo.MenuItemRepository;
import com.coffeestore.vo.Bill;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Coffee store service test
 */
public class CoffeeStoreServiceImplTest {

    @Mock
    private MenuItemRepository menuItemRepository;

    @InjectMocks
    private CoffeeStoreServiceImpl coffeeStoreServiceImpl;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        List<MenuItem> list = new ArrayList<>();

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

        Mockito.when(menuItemRepository.findAll()).thenReturn(list);
    }

    /**
     * Test place order
     */
    @Test
    public void testPlaceOrder() {

        Bill result = coffeeStoreServiceImpl.placeOrder(coffeeStoreServiceImpl.getAvailableItems());

        Assert.assertTrue("Expecting total 1.50", 1.50 == result.getTotalCost());

    }

    /**
     * Test retrieve available items
     */
    @Test
    public void testGetAvailableItems() {

        List<MenuItem> items= coffeeStoreServiceImpl.getAvailableItems();

        Assert.assertTrue("Expecting 2 items", 2==items.size());

    }

}