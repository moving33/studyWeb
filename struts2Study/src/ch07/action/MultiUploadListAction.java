package ch07.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MultiUploadListAction extends ActionSupport{

    private List<File> upload = new ArrayList<File>();
    private List<String> uploadFileName = new ArrayList<>();
    private List<String> uploadContentType = new ArrayList<>();
    private List<String> serverFullPath = new ArrayList<>();

    public String execute()throws Exception{
        String basePath = getText("path.upload_file");
        FileService fileService = new FileService();
        for(int i=0;i<upload.size();i++){
            File file = upload.get(i);
            serverFullPath.add(fileService.saveFile(file, basePath , uploadFileName.get(i)));
        }
        return SUCCESS;
    }

    public List<File> getUpload() {
        return upload;
    }

    public void setUpload(List<File> upload) {
        this.upload = upload;
    }

    public List<String> getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(List<String> uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public List<String> getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(List<String> uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public List<String> getServerFullPath() {
        return serverFullPath;
    }

    public void setServerFullPath(List<String> serverFullPath) {
        this.serverFullPath = serverFullPath;
    }
}
