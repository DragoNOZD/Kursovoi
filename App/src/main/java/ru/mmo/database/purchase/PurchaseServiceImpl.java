package ru.mmo.database.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private PurchaseRepo purchaseRepo;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepo purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    public PurchaseRepo getPurchaseRepo() {
        return purchaseRepo;
    }

    public void setPurchaseRepo(PurchaseRepo purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    @Override
    public void addPurchase(Purchase purchase) {
        purchaseRepo.saveAndFlush(purchase);
    }

    @Override
    public List<Purchase> getAllByLogin(String login) {
        return purchaseRepo.getAllByLogin(login);
    }
}
