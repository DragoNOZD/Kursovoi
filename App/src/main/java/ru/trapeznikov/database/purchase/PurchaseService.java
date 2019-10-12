package ru.trapeznikov.database.purchase;

import java.util.List;

public interface PurchaseService {
    void addPurchase(Purchase purchase);
    List<Purchase> getAllByLogin(String login);
}
