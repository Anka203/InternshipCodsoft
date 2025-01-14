package atm;  

public class MainApp {  
    public static void main(String[] args) {  
        BankAccount myAccount = new BankAccount(5000000.00);
        ATM myATM = new ATM(myAccount);  
        myATM.showMenu();  
    }  
}