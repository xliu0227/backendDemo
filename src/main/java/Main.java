import Model.Transaction;
import ServiceLayer.TransactionService;
import java.util.Scanner;

public class Main {
    static TransactionService ts;
    public static void main(String[] args) {

        System.out.println("app start");
        System.out.println("Welcome to Xiaolong's Backend Demo");
        //get files
        //display exist transaction

        appStart();
    }

    public static void appStart(){
        ts = new TransactionService(false);

        Scanner scan = new Scanner(System.in);
        while(true){
            displayExistRecord();
            if(!isWritingTransaction(scan)){
                break;
            }
        }

        System.out.println("App completed");
    }

    public static boolean isWritingTransaction(Scanner scan){
        System.out.println("Options:");
        System.out.println("1. Create new transaction");
        System.out.println("2. Exit Program");
        String firstChoice;
        try{
            firstChoice = scan.nextLine();
            if(firstChoice.equals("1")){
                createTransaction();
            }else if(firstChoice.equals("2")){
                return false;
            }else{
                System.out.println("Please enter a valid option number.");
            }
        }catch(Exception e){
            System.out.println("Format incorrect, please enter a correct option number");
            return true;
        }

        return true;
    }

    public static void displayExistRecord(){
        String content = ts.getContent();
        if(content == null){
            System.out.println("No Histroy record");
        }else{
            System.out.println(content);
        }
    }


    public static void createTransaction(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input transaction currency");
        String currency = scan.nextLine().toUpperCase();
        System.out.println("please input transaction amount");
        String tmp = scan.nextLine();
        double amount = Double.parseDouble(tmp);

        Transaction trans = new Transaction(currency, amount);
        ts.writeContect(trans);

        System.out.println("New transaction created completed");
    }
}



