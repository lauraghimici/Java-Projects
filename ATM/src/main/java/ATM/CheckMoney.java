package ATM;


public class CheckMoney extends Transaction {

    
    public CheckMoney(Account account){
    super(account);
    
    }
    @Override
    public String execute() {
       
        return"The balance of this account is "+getAccount().getBalance()+"$";
    }
    
}
