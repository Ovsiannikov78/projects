package de.ovsiannikov.ecommerce.service;

import de.ovsiannikov.ecommerce.dto.Purchase;
import de.ovsiannikov.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
