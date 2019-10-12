package ru.trapeznikov.database.purchase;

import ru.trapeznikov.database.PaymentMethod;
import ru.trapeznikov.database.gametopurchaselink.GameToPurchaseLink;
import ru.trapeznikov.database.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @ManyToOne
    private User buyer;

    // TODO: Add Date, search by date, finalCost and paymentMethod

    //@Column
    //private Calendar date;

    @Column
    private float finalCost;

    @OneToMany
    private List<GameToPurchaseLink> purchaseLinks;

    @Enumerated(EnumType.STRING)
    @Column
    private PaymentMethod paymentMethod;

    public Purchase() {
    }

    public Purchase(User buyer, PaymentMethod paymentMethod) {
        this.buyer = buyer;
        this.paymentMethod = paymentMethod;
    }

    public long getId() {
        return id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public float getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(float finalCost) {
        this.finalCost = finalCost;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<GameToPurchaseLink> getPurchaseLinks() {
        return purchaseLinks;
    }

    public void setPurchaseLinks(List<GameToPurchaseLink> purchaseLinks) {
        this.purchaseLinks = purchaseLinks;
    }

    public void addPurchaseLink(GameToPurchaseLink purchaseLink) {
        this.purchaseLinks.add(purchaseLink);
    }

    public void addPurchaseLinks(List<GameToPurchaseLink> purchaseLinks) {
        this.purchaseLinks.addAll(purchaseLinks);
    }
}
