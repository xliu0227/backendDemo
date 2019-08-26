package Model;

import java.sql.Timestamp;

public class Transaction {
    //int id;
    String currency;
    double amount;

    public Transaction(String currency, double amount){
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }
}
