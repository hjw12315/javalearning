package inheritanceExample;

public class Account {
    private int id;
    private double balance;
    private double annuallnterestRate;

//    public Account(){}

    public Account(int id, double balance, double annuallnterestRate){
        this.id = id;
        this.balance = balance;
        this.annuallnterestRate = annuallnterestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public double getMonthlyInterest(){
        return getAnnuallnterestRate()/12;
    }

    public void withdraw(double amount){
        if(getBalance()>=amount){
            setBalance(getBalance() - amount);
            System.out.println("账户余额: "+getBalance());
        }
        else
            System.out.println("余额不足");
    }

    public void deposit(double amount){
        setBalance(getBalance() + amount);
        System.out.println(getBalance() +" "+ getMonthlyInterest());
    }
}
