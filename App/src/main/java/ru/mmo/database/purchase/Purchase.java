package ru.mmo.database.purchase;

import ru.mmo.database.account.Account;

import javax.persistence.*;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Purchase_generator")
    @SequenceGenerator(name = "Purchase_generator", sequenceName = "Purchase_sequence")
    private long id;

    @ManyToOne
    private Account buyer;

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

    public Purchase(Account buyer, PaymentMethod paymentMethod) {
        this.buyer = buyer;
        this.paymentMethod = paymentMethod;
    }

    public long getId() {
        return id;
    }

    public Account getBuyer() {
        return buyer;
    }

    public void setBuyer(Account buyer) {
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
