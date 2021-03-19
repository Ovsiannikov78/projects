package de.ovsiannikov.ecommerce.dto;

import de.ovsiannikov.ecommerce.entity.Address;
import de.ovsiannikov.ecommerce.entity.Customer;
import de.ovsiannikov.ecommerce.entity.Order;
import de.ovsiannikov.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
