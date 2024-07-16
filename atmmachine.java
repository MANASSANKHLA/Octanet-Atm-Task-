
import java.util.*;
public class atmmachine {

    public static void main(String[] args) {
          Atm a = new Atm(); 
    }
}
//function include
// Account balance inquiry
// Cash withdrawal
// Cash deposit
// PIN change
// Transaction history

class Atm {

    int pin = 1234;
    String m = "Manas Sankhla";
    float balance;
    List<String> transactionHistory = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    Atm() {
        System.out.println("Enter Your Pin:");
        int userpin = sc.nextInt();
        if (userpin == pin) {
            System.out.println("Hello " + m);
            dashboard();
        } else {
            System.out.println("Enter Valid Pin");
            cancel();
        }
    }

    public void dashboard() {
        System.out.println("Press 1:Check Account Balance");
        System.out.println("Press 2:Withdraw Money");
        System.out.println("Press 3:Deposit Money");
        System.out.println("Press 4:Pin Change");
        System.out.println("Press 5:Transaction History");
        System.out.println("Press 6:CANCEL");
        int selected = sc.nextInt();
        switch (selected) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdrawal();
                break;
            case 3:
                deposit();
                break;
            case 4:
                pinChange();
                break;
            case 5:
                history();
                break;
            case 6:
                cancel();
                break;
            default:
                System.out.println("Enter Valid Input");
                dashboard();
        }
    }

    public void checkBalance() {
        System.out.println("Account Balance" + balance);
        transactionHistory.add("Checked balance: " + balance);
        dashboard();
    }

    public void withdrawal() {
        System.out.println("Enter your withdrawal amount:");
        float amount = sc.nextInt();
        if (amount > balance) {
            System.out.println("Limit Out");
        } else {
            balance = balance - amount;
            System.out.println("Money Withdrawal Successfully");
            transactionHistory.add("Withdrew: " + amount);
            System.out.println("If you want to check left balance \n Type:1");
            System.out.println("You want to exit \n Type:0");
            int y = sc.nextInt();
            if (y == 1) {
                System.out.println("your left balance is " + balance);
            }
            else if(y == 0){
                cancel();
            }
            else{
                System.out.println("you entered wrong");
            }
        }
        dashboard();
    }

    public void deposit() {
        String accept = "yes";
        String notaccept = "no";
        System.out.println("Enter Your Amount To Deposit:");
        float deposit = sc.nextInt();
        balance = balance + deposit;
        System.out.println("Money Deposit Successfully");
        transactionHistory.add("Deposited: " + deposit);
        System.out.println("If you want to check balance \n Type:1");
        System.out.println("You want to exit \n Type:0");
        int y = sc.nextInt();
        if (y == 1) {
            System.out.println("your balance is " + balance);
        }
        else if(y == 0) {
            cancel();
        }
        else{
            System.out.println("you entered wrong");
        }
        dashboard(); 
    }

    public void pinChange() {
        System.out.println("Enter Your Current Pin:");
        int oldPin = sc.nextInt();
        if (oldPin == pin) {
            System.out.println("Enter Your New Pin");
            int newPin = sc.nextInt();
            System.out.println("Re-enter your New Pin");
            int newPinCheck = sc.nextInt();
            if (newPin == newPinCheck) {
                pin = newPin;
                System.out.println("Congratulation your pin Changed");
                transactionHistory.add("Changed PIN");
            } else {
                System.out.println("Your new and old pin not match");
            }
        } else {
            System.out.println("You enter wrong pin");
        }
        dashboard();

    }

    public void history() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
        dashboard();
    }
    
    public void cancel(){
        System.out.println("Welcome Back");
        System.exit(0);
    }
}
