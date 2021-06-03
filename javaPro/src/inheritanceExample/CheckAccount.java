package inheritanceExample;

public class CheckAccount extends Account {
    private double overdraft;

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft){
        this.overdraft = overdraft;
    }
    // 调用父类的构造方法
    public CheckAccount(int id, double balance, double annuallnterestRate, double overdraft){
        super(id, balance, annuallnterestRate);
        this.overdraft = overdraft;
    }

    // 重写 withdraw 方法
    public void withdraw(double amount){
        if(amount <= getBalance()){
            // setBalance(getBalance() - amount);
            super.withdraw(amount);  // 调用父类的withdraw方法
            System.out.println("可透支额度: " + overdraft);
        }
        else{
            double balance = amount - getBalance();
            if(overdraft>balance){
                // setBalance(0);
                super.withdraw(getBalance());
                overdraft -=  balance;
                System.out.println("可透支额度: " + overdraft);
            }
            else
                System.out.println("超过可透支额度");
        }
    }
}
