package ru.trapeznikov.database.purchase;

import ru.trapeznikov.database.PaymentMethod;
import ru.trapeznikov.database.user.User;

import javax.persistence.*;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(nullable = false)
    private User buyer;

    // TODO: Add Date, search by date, finalCost and paymentMethod

    //@Column
    //private Calendar date;

    @Column
    private float finalCost;

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

    public void setId(long id) {
        this.id = id;
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
}
