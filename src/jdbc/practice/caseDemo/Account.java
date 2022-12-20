package jdbc.practice.caseDemo;

public class Account {

    private int id;
    private String a_name;
    private double money;

    public Account() {
    }

    public Account(int id, String a_name, double money) {
        this.id = id;
        this.a_name = a_name;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", a_name='" + a_name + '\'' +
                ", money=" + money +
                '}';
    }
}
