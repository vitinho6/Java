package model.entities;

import model.exceptions.BalanceException;
import model.exceptions.LimitException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withDrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance; // tentei usar o deposito, mas deu NullPointerException, por tentar acessar um metodo de um objeto ainda nao completamente instanciado
        this.withDrawLimit = withDrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithDrawLimit() {
        return withDrawLimit;
    }

    public void setWithDrawLimit(Double withDrawLimit) {
        this.withDrawLimit = withDrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }

    public void withdraw(Double amount) throws LimitException, BalanceException{
        if (amount>withDrawLimit){
            throw new LimitException("Amount exceeds withdraw limit");
        }
        if (amount>balance){
            throw new BalanceException("Not enough balance");
        }

        balance -= amount;
    }
}
