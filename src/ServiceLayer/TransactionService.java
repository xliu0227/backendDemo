package ServiceLayer;

import FileAccessLayer.TextFileService;
import Model.Transaction;

public class TransactionService {
    private TextFileService tfs;
    public TransactionService(boolean isDebugMode){
        if(isDebugMode){
            tfs = new TextFileService("test.txt");
        }else{
            tfs = new TextFileService("transaction_demo.txt");
        }
    }

    public void writeContect(Transaction transa){
        if(transa == null || transa.getCurrency() == null){
            System.out.println("Data format incorrect, please re-enter");
        }

        tfs.update(transa.getCurrency() + "\t\t" + transa.getAmount());
    }

    public String getContent(){
        return tfs.getContent();
    }
}
