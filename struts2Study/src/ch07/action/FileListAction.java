package ch07.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileListAction extends ActionSupport{
    private List<File> listFile = new ArrayList<>();
    private String basePath;

    public String execute()throws Exception{
        basePath = getText("path.download_base");
        File dir = new File(basePath);
        File[] files = dir.listFiles();
        if(files != null){
            for(File file:files){
                if(file.isFile()){
                    listFile.add(file);
                }
            }
        }
        return SUCCESS;
    }

    public List<File> getListFile() {
        return listFile;
    }

    public void setListFile(List<File> listFile) {
        this.listFile = listFile;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
}
