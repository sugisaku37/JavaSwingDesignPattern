public class Employee {
    private int sickDays, vacDays;
    private float salary;
    private String name;

    public Employee(String name, float salary, int vacdays, int sickdays) {
        this.vacDays = vacdays;
        this.sickDays = sickdays;
        this.salary = salary;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getSickdays() {
        return sickDays;
    }
    public int getVacDays() {
        return vacDays;
    }
    public float getSalary() {
        return salary;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
