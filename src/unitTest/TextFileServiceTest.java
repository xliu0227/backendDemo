package unitTest;

import FileAccessLayer.TextFileService;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class TextFileServiceTest {

    @org.junit.jupiter.api.Test
    void writeAndGetContect() {
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



}