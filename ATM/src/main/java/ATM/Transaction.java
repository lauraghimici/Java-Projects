package ATM;

public abstract class Transaction {
    
    
    private Account account;
    
    public Transaction(Account account){
     this.account=account;
    
    }
    
    public Account getAccount(){
    return account;
    }
    
    public void setAccount(Account account){
        
    this.account=account;
    
    }
    
    
    public abstract String execute();
    
}
