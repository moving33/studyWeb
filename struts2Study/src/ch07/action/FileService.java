package ch07.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileService {

    public void makeBasePath(String path){
        System.out.println("File Directory Create...");
        File dir = new File(path);
        if(!dir.exists())dir.mkdirs();
    }

    public String saveFile(File file,String basePath, String fileName)throws IOException{
        System.out.println("file save start...");
        if(file == null || file.getName().equals("") || file.length() <= 0){
            return null;
        }
        makeBasePath(basePath); //베이스 폴더 생성

        //저장할 전체 경로
        String serverFullPath = basePath +"\\"+ fileName;
        //파일 저장
        FileInputStream inputStream  = new FileInputStream(file);
        FileOutputStream  outputStream = new FileOutputStream(serverFullPath);

        int byteRead = 0;
        byte[] buffer = new byte[1024*8];
        while((byteRead = inputStream.read(buffer,0,buffer.length)) != -1){
            outputStream.write(buffer,0,byteRead);
        }
        outputStream.close();
        inputStream.close();

        System.out.println("file save success...");
        return serverFullPath;
    }
}
