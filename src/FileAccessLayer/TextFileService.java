package FileAccessLayer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFileService implements IFileAccessSerivce{
    private static final Object lock = new Object();
    private static volatile TextFileService instance;
    private String simpleReadCache;
    private String dir;

    public TextFileService(String inputDir) {
        this.dir = inputDir;
    }

    @Override
    public synchronized void update(String content) {
        try{
            File file = new File(this.dir);
            if(!file.exists()){
                file.createNewFile();
            }else{
                getContent();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(this.dir, true));
            writer.newLine();
            writer.write(content);
            writer.close();

            if(simpleReadCache == null){
                simpleReadCache  = content;
            }else{
                simpleReadCache += ("\n" + content);
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public String getContent() {
        if(simpleReadCache != null){
            return simpleReadCache;
        }


        try{
            File file = new File(this.dir);
            if(!file.exists()){
                return null;
            }

            simpleReadCache = new String(Files.readAllBytes(Paths.get(this.dir)));
        }catch(IOException ex){
            ex.printStackTrace();
        }

        return simpleReadCache;
    }
}
