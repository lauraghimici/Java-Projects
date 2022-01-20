package ATM;

public class WithdrawMoney extends Transaction{

    public double amount;
    
    public WithdrawMoney(Account account,double amount){
    super(account);
    this.amount=amount;
    
    }
    @Override
    public String execute() {
        
       double result=getAccount().getBalance()-amount;     
        getAccount().setBalance(result);
      return ("Transaction was successful. "+ amount + "$ withdrawed.");   
    }
    
}
