package com.maxwell.javafxprograms.event_handling;

public class Loan {

    double interest;
    int year;
    double loanAmount;

    public Loan(double interest, int year, double loanAmount) {
        this.interest = interest;
        this.year = year;
        this.loanAmount = loanAmount;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getMonthlyPayment() {
        return getTotalPayment()/(12*year);
    }

    public double getTotalPayment() {
        return (loanAmount + (loanAmount*interest/100));
    }
}
