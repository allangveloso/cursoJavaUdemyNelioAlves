package entities;

public abstract class TaxPayer {
    private String nameOfTaxPayer;
    private Double anualIncome;

    public TaxPayer() {
    }

    public TaxPayer(String nameOfTaxPayer, Double anualIncome) {
        this.nameOfTaxPayer = nameOfTaxPayer;
        this.anualIncome = anualIncome;
    }

    public String getNameOfTaxPayer() {
        return nameOfTaxPayer;
    }

//    public void setNameOfTaxPayer(String name) {
//        this.nameOfTaxPayer = nameOfTaxPayer;
//    }

    public Double getAnualIncome() {
        return anualIncome;
    }

//    public void setAnualIncome(Double anualIncome) {
//        this.anualIncome = anualIncome;
//    }

    public abstract Double anualTaxes();
}
