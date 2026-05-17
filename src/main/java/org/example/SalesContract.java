package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesContract extends Contract {

    private final double SALES_TAX_RATE = 0.05;

    private final BigDecimal RECORDING_FEE =
            new BigDecimal("100");

    private boolean finance;

    public SalesContract(String date,
                         String customerName,
                         String customerEmail,
                         Vehicle vehicleSold,
                         boolean finance) {

        super(date, customerName, customerEmail, vehicleSold);

        this.finance = finance;
    }

    public BigDecimal getSalesTaxAmount() {

        return getVehicleSold()
                .getPrice()
                .multiply(BigDecimal.valueOf(SALES_TAX_RATE));
    }

    public BigDecimal getProcessingFee() {

        if(getVehicleSold().getPrice()
                .compareTo(new BigDecimal("10000")) < 0){

            return new BigDecimal("295");
        }

        return new BigDecimal("495");
    }

    @Override
    public BigDecimal getTotalPrice() {

        return getVehicleSold()
                .getPrice()
                .add(getSalesTaxAmount())
                .add(RECORDING_FEE)
                .add(getProcessingFee());
    }

    @Override
    public double getMonthlyPayment() {

        if(!finance){
            return 0;
        }

        double loanAmount = getTotalPrice().doubleValue();

        double annualInterestRate;
        int months;

        if(loanAmount >= 10000){

            annualInterestRate = 0.0425;
            months = 48;

        } else {

            annualInterestRate = 0.0525;
            months = 24;
        }

        double monthlyInterestRate =
                annualInterestRate / 12;

        double monthlyPayment =
                (loanAmount * monthlyInterestRate)
                        / (1 - Math.pow(
                        1 + monthlyInterestRate,
                        -months
                ));

        return BigDecimal.valueOf(monthlyPayment)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }
}