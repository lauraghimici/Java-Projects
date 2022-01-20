package ATM;

 
public class Bank {
    
    Account [] account=new Account[10];
    
    public Bank(Account[] account){
        
        this.account=account;
    
    }
    
    public String executeTransaction(Transaction t){
    
    return t.execute();
    
    }
   
    public Account getAccountByCardId(String cardId){
    
         for(int i=0;i<account.length;i++)
             if(account[i].getCardId(account[i].getCard()).equals(cardId)  )
                 return account[i];    
         
       return null;
    }

   
   
    
}
