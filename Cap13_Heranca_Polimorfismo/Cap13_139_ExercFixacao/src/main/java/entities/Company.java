package entities;

public class Company extends TaxPayer {

    private int employeesQuantity;

    public Company(String name, Double anualIncome, int employeesQuantity) {
        super(name, anualIncome);
        this.employeesQuantity = employeesQuantity;
    }


    @Override
    public Double anualTaxes() {

        if(employeesQuantity > 10){
            return getAnualIncome() * 0.14;
        }
        else {
            return getAnualIncome() * 0.16;
        }
    }
}
