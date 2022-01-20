package ATM;

public class Card {
    
    private String cardId;
    private String pin;
    static int i=0;
    
    public Card (String pin){
    
   this.pin=pin;
   cardId=String.valueOf(i);
   ++i;
   
    }
    
    public String getCardId(){
    
        return cardId;
        
    }
    
    public String getPin(){
    
        return pin;
        
    }
    public void setPin(String pin){
    this.pin=pin;
    }
    
   
}
