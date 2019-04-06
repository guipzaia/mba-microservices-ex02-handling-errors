package br.com.fiap.orderservice.enums;

public enum OrderStatus {
    PAYMENT_WAITING,
    PAYMENT_CONFIRMED,
    DISPATCHED,
    ON_DELIVERY_ROUTE,
    DELIVERED,
    RETURNED,
    CANCELED,
}
