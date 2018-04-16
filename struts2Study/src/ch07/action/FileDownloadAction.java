package ch07.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

public class FileDownloadAction extends ActionSupport {
    private String basePath;
    private String fileName;
    private String contentType;
    private String contentDisposition;
    private InputStream inputStream;
    private long contentLength;

    public String execute()throws Exception{
        String inputPath = basePath +"/" +fileName;
        File file = new File(inputPath);
        setContentLength(file.length());
        setContentDisposition("attachment;filename"+URLEncoder.encode(fileName,"UTF-8"));
        setInputStream(new FileInputStream(file));
        return SUCCESS;
    }


    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentDisposition() {
        return contentDisposition;
    }

    public void setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }
}
