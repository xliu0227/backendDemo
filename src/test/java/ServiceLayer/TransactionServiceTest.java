package ServiceLayer;

import FileAccessLayer.TextFileService;
import Model.Transaction;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    @Test
    public void writeAndGetContect() {
        File file = new File("test.txt");
        if(file.delete()){
            System.out.println("File deleted successfully");
        }else{
            System.out.println("Failed to delete the file");
        }

        TextFileService tfs = new TextFileService("test.txt");
        tfs.update("this is first line");
        tfs.update("this is the second line");
        String result = tfs.getContent();
        assertEquals(result,"this is first line" +'\n'+
                "this is the second line");
    }


    @Test
    public void writeAndGetContectAtServiceLayer() {
        File file = new File("test.txt");
        if(file.delete()){
            System.out.println("File deleted successfully");
        }else{
            System.out.println("Failed to delete the file");
        }
        TransactionService ts = new TransactionService(true);
        Transaction transa1 = new Transaction("USD", 100000);
        Transaction transa2 = new Transaction("cad", 150000);

        ts.writeContect(transa1);
        ts.writeContect(transa2);
        String result = ts.getContent();
        //System.out.println(result);
        assertEquals(result,"USD\t\t100000.0" +'\n'+"CAD\t\t150000.0");
    }
}