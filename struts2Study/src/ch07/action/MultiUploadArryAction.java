package ch07.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;

public class MultiUploadArryAction extends ActionSupport {

    private File[] upload;
    private String[] uploadFileName;
    private String[] uploadContentType;
    private String[] serverFullPath;
    private String[] uploadContentLength;

    public String[] getUploadContentLength() {
        return uploadContentLength;
    }

    public void setUploadContentLength(String[] uploadContentLength) {
        this.uploadContentLength = uploadContentLength;
    }

    public String execute()throws Exception{

        String basePath = getText("path.upload_file");

        FileService fileService = new FileService();

        uploadContentLength = new String[upload.length];
        serverFullPath = new String[upload.length];

        for(int i=0; i< upload.length ;i++){
            serverFullPath[i] = fileService.saveFile(upload[i],basePath,uploadFileName[i]);
            uploadContentLength[i] = String.valueOf(upload[i].length())+ " byte";
        }
        return SUCCESS;
    }

    public File[] getUpload() {
        return upload;
    }

    public void setUpload(File[] upload) {
        this.upload = upload;
    }

    public String[] getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String[] uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String[] getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String[] uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String[] getServerFullPath() {
        return serverFullPath;
    }

    public void setServerFullPath(String[] serverFullPath) {
        this.serverFullPath = serverFullPath;
    }
}
