package ATM;

import java.util.Scanner;

public class Exercise1 {
    
 public static void main(String[] args) {
     
     Card card0=new Card("1234");
     Card card1=new Card("2356");
     Card card2=new Card("1a2d");
     Card card3=new Card("!0u24");
     Account [] accounts =new Account[10];
     accounts[0]=new Account("John Doe",1000,card0);
     accounts[1]=new Account("Mary Jane",143,card1);
     accounts[2]=new Account("David Brady",12,card2);
     accounts[3]=new Account("Harry Potter",5790,card3);
     
    Bank bank=new Bank(accounts);
    ATM atm=new ATM(bank);
      
       Scanner scanner = new Scanner(System.in);
       boolean ok=true;
       while(ok){
       System.out.println("Menu: 0-Insert Card"
               + " 1-Withdraw Money"
               + " 2-Check Money"
               + " 3-Change Pin"
               + " 4- Done");
       int action=scanner.nextInt();
       Scanner scanner2 = new Scanner(System.in);
       switch(action){
           case 0: {
           System.out.println("Enter the card you want to insert");
            int card=scanner.nextInt();
            System.out.println("Enter the Pin:");           
            String pin = scanner2.nextLine();
            atm.insertCard(accounts[card].getCard(),pin);
            break;
           }
           
           case 1:{
               System.out.println("Enter the amount:");
               double amount=scanner.nextDouble();
               atm.withdraw(amount);
               break;
           
           }
           case 2:{
              atm.checkmoney(); 
              break;
              
           }
           case 3:{
               System.out.println("Enter the old pin:");
               String oldPin= scanner2.nextLine();
               System.out.println("Enter the new pin:");
               String newPin= scanner2.nextLine();
               atm.changePin(oldPin, newPin);
               break;
           }
           
           case 4:{
               ok=false;
               break;
           }
        
       }
      
      
       }
      
      
      
    
   
 }
           
}
