package entities;

import enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public Double income(Integer year, Integer month){
        double sum = baseSalary;
        //instancia o calendário deste mês como sendo o do programa
        Calendar cal = Calendar.getInstance();

        for(HourContract c: contracts ){
            //para cada contrato c, define a data do contrato como sendo a data do calendário
            cal.setTime(c.getDate());
            //seta c_year como o ANO daquela data
            int c_year = cal.get(Calendar.YEAR);
            //seta c_year como o MÊS daquela data | mes no Calendar começa com 0, por isso 1+
            int c_month = 1+cal.get(Calendar.MONTH);

            if(c_year==year && c_month==month){
                sum +=c.totalValue();
            }

        }
        return sum;
    }
}
