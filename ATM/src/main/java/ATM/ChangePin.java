package ATM;

public class ChangePin extends Transaction {

    public String oldPin;
    public String newPin;
    
    public ChangePin(Account account,String oldPin, String newPin){
        super(account);
        this.oldPin=oldPin;
        this.newPin=newPin;
    }
    
    @Override
    public String execute() {
    
        getAccount().getCard().setPin(newPin);
        return newPin;
    }
    
}
