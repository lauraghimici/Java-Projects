package ATM;

public class ATM {
    
    private Bank bank;
    private Card card;
    
    public ATM(Bank bank){
    
        this.bank=bank;
    }
    
    
    public boolean insertCard(Card card,String pin){
    if(card.getPin().equals(pin))
    { 
    this.card=card;
    System.out.println("Card inserted.");
    return true;}
    else{
        System.out.println("Incorrect pin. Please try again.");
    return false;
    }
    }   
    
    
    public Bank getBank(){
    
        return bank;
    }
    
    public void setBank(Bank bank){
    
    this.bank=bank;
    
    }
    
    public Card getCard(){
    
        return card;
        
    }
    
    public void setCard(Card card){
    
        this.card=card;
        
    }
    
    public void changePin(String oldPin,String newPin){
    
        if(card.getPin().equals(oldPin)){
            String thisId=card.getCardId();         
         ChangePin changePin=new ChangePin(bank.getAccountByCardId(thisId),oldPin,newPin);
            changePin.execute();
            System.out.println("Pin changed successfully!");
        }
        else 
            System.out.println("Wrong Pin. Try again.");
    }
    
    public void checkmoney(){
       
        String thisId=card.getCardId();    
        CheckMoney cm=new CheckMoney(bank.getAccountByCardId(thisId));
        System.out.println(cm.execute());
  
    }
    
    public void withdraw(double amount){
    
         String thisId=card.getCardId();      
        if(bank.getAccountByCardId(thisId).getBalance()>amount)
        {
       WithdrawMoney wd=new WithdrawMoney(bank.getAccountByCardId(thisId),amount);
       System.out.println(wd.execute()); 

            }
            else
                System.out.println("Inssuficient funds!");
    
    }
    public void removeCard(){
    card=null;
    System.out.println("Card removed.");
    }
    
    
}
