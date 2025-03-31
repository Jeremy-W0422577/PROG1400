import java.util.ArrayList; //Import the ArrayList class for transaction storage
import java.util.Date; //Import the Date class to record transaction dates
import java.util.Scanner; //Import the Scanner class for user input

//Transaction class stores transaction details
class Transaction {
    private Date date; //Date of transaction
    private char type; //Type of transaction ('D' for deposit, 'W' for withdrawal)
    private double amount; //Amount transacted
    private double balance; //Balance after transaction
    private String description; //Description of transaction

    //Constructor initializes transaction
    public Transaction(Date date, char type, double amount, double balance, String description) {
        this.date=date; //Set transaction date
        this.type=type; //Set transaction type
        this.amount=amount; //Set transaction amount
        this.balance=balance; //Set account balance after transaction
        this.description=description; //Set transaction description
    }

    //Returns string of transaction
    @Override
    public String toString() {
        return "Transaction{"+
                "date="+date+ //Include date in string
                ", type="+type+ //Include type in string
                ", amount="+amount+ //Include amount in string
                ", balance="+balance+ //Include balance in string
                ", description='"+description+'\''+ //Include description in string
                '}';
    }
}

//Account class manages account details and transactions
class Account {
    private String customerName; //Customer name
    private int id; //Account ID
    private double balance; //Account balance
    private double annualInterestRate; //Annual interest rate
    private ArrayList<Transaction> transactions; //List of transactions related to account

    //Constructor initializes customer name, account ID, and balance, with default interest rate
    public Account(String customerName, int id, double balance) {
        this.customerName=customerName; //Set customer name
        this.id=id; //Set account ID
        this.balance=balance; //Set initial balance
        this.annualInterestRate=1.5; //Set default annual interest rate
        this.transactions=new ArrayList<>(); //Initialize transaction list
    }

    //Constructor initializes customerName, id, balance, and annual interest rate
    public Account(String customerName, int id, double balance, double annualInterestRate) {
        this.customerName=customerName; //Set customer name
        this.id=id; //Set account ID
        this.balance=balance; //Set initial balance
        this.annualInterestRate=annualInterestRate; //Set annual interest rate
        this.transactions=new ArrayList<>(); //Initialize transaction list
    }

    //Method gets monthly interest rate
    public double getMonthlyInterestRate() {
        return annualInterestRate/12/100; //Calculate and return monthly interest rate
    }

    //Method to deposit amount into account
    public void deposit(double amount) {
        balance+=amount; //Update account balance
        //Record deposit transaction in list
        transactions.add(new Transaction(new Date(), 'D', amount, balance, "Deposit")); //Create new transaction
    }

    //Method to withdraw amount from account
    public void withdraw(double amount) {
        if (amount<=balance) { //Check if enough balance is available
            balance-=amount; //Update account balance
            //Record withdrawal transaction in list
            transactions.add(new Transaction(new Date(), 'W', amount, balance, "Withdrawal")); //Create new transaction
        } else {
            System.out.println("Withdrawal amount exceeds balance."); //Inform user of insufficient funds
        }
    }

    //Method to get summary of account and transactions
    public String getAccountSummary() {
        StringBuilder summary=new StringBuilder(); //Create StringBuilder for summary
        summary.append("Customer Name: ").append(customerName)  //Add customer name to summary
               .append("\nAccount ID: ").append(id) //Add account ID to summary
               .append("\nAnnual Interest Rate: ").append(annualInterestRate) //Add interest rate to summary
               .append("%\nBalance: $").append(balance) //Add balance to summary
               .append("\nTransactions:\n"); //Start transactions section in summary
        for (Transaction t : transactions) { //Loop through each transaction
            summary.append(t.toString()).append("\n"); //Add transaction details
        }
        return summary.toString(); //Return complete summary as string
    } //End of getAccountSummary method
} //End of Account class

//Main class
public class BankAccount {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in); //Create Scanner object for input

        //Create account using constructor with default interest rate
        Account account=new Account("George", 1122, 1000); 

        //User inputs for deposits
        System.out.println("Enter deposit amounts (0 to end):"); //Prompt user for deposits
        while (true) { //Start loop for deposits
            double depositAmount=input.nextDouble(); //Read deposit amount
            if (depositAmount==0) { //Exit condition for deposits
                break; //Exit on 0
            }
            account.deposit(depositAmount); //Deposit method updates balance and record transaction
        } //End of deposit loop

        //User inputs for withdrawals
        System.out.println("Enter withdrawal amounts (0 to end):"); //Prompt user for withdrawals
        while (true) { //Start loop for withdrawals
            double withdrawalAmount=input.nextDouble(); //Read withdrawal amount
            if (withdrawalAmount==0) { //Exit condition for withdrawals
                break; //Exit on 0 
            }
            account.withdraw(withdrawalAmount); //Withdraw method updates balance and record transaction
        } //End of withdrawal loop

        //Print account summary
        System.out.println(account.getAccountSummary()); //Display account summary
        
        input.close(); //Close the scanner to prevent memory leaks
    } //End of main method
} //End of BankAccount class