package ch07.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;

public class SingleUploadAction extends ActionSupport {

    private File upload; // 실제파일
    private String uploadFileName; // 로컬 파일
    private String uploadContentType; // 업로드할 파일의 컨텐트 타입
    private String serverFullPath; // 저장할 실제파일의 전체 경로

    public String execute()throws Exception{
        String basePath = getText("path.upload_file");
        FileService fileService = new FileService();
        serverFullPath =
                fileService.saveFile(upload,basePath,uploadFileName);
        return SUCCESS;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        System.out.println("use setUploadFileName..");
        this.uploadFileName = uploadFileName;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getServerFullPath() {
        return serverFullPath;
    }

    public void setServerFullPath(String serverFullPath) {
        this.serverFullPath = serverFullPath;
    }
}

