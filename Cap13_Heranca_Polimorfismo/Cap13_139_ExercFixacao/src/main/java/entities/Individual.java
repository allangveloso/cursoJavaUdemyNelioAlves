package entities;

public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

//    public void setHealthExpenditures(Double healthExpenditures) {
//        this.healthExpenditures = healthExpenditures;
//    }

    @Override
    public Double anualTaxes() {
        double healthDisccount= 0.5;

        if(getAnualIncome() >= 20000){
            return (getAnualIncome() * 0.25) - healthExpenditures * healthDisccount;
        }
        else {
            return (getAnualIncome() * 0.15) - healthExpenditures * healthDisccount;
        }
    }
}
