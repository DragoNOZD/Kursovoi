package ru.mmo.database.item;

public enum Rarity {
    U(1),
    L(20000),
    F(100000),
    R(1000000),
    C(999999999);

    long count;
    Rarity(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }
}
