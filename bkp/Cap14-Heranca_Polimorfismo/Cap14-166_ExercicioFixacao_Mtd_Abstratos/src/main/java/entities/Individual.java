package entities;

public class Individual extends TaxPayer{
    private double healthExpenditures;

    public Individual(String name, double anualIncome, double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public double gethealthExpenditures() {
        return healthExpenditures;
    }

    public void sethealthExpenditures(double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        if(getAnualIncome()<20000){
            return getAnualIncome() * 0.15 - healthExpenditures * 0.5;
        }else{
            return getAnualIncome() * 0.25 - healthExpenditures * 0.5;
        }
    }
}
