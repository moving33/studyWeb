package ch08.action;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.jasperreports.engine.*;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.util.HashMap;

public class ReportAction extends ActionSupport {

    public ResultSet rs = null;
    public String submit = null;
    public FileInputStream fileInputStream;
    public String jasperPath = "";
    public String pdfName = "";
    public String rpt = "";
    public JRResultSetDataSource resultSetDataSource;

    public JRResultSetDataSource getResultSetDataSource() {
        return resultSetDataSource;
    }

    public void setResultSetDataSource(JRResultSetDataSource resultSetDataSource) {
        this.resultSetDataSource = resultSetDataSource;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public FileInputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    public String getJasperPath() {
        return jasperPath;
    }

    public void setJasperPath(String jasperPath) {
        this.jasperPath = jasperPath;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public String getRpt() {
        return rpt;
    }

    public void setRpt(String rpt) {
        this.rpt = rpt;
    }

    @Override
    public String execute() throws Exception {
        try {
                rs = new ReportDAO().getPdf();
                jasperPath = ServletActionContext.getServletContext().getRealPath("/Reports");
                System.out.println(jasperPath);
                pdfName = "StudentReport";
                rpt = "studentReport.jrxml";
                resultSetDataSource = new JRResultSetDataSource(rs);
                HashMap<String, Object> pm = new HashMap<String, Object>();
                String logo = jasperPath + "/wg.png";
                pm.put("logo", logo);
            JasperCompileManager.compileReportToFile(jasperPath+"/"+rpt,
                    jasperPath +"/"+ pdfName + ".pdf");
            //JasperReport jr = JasperCompileManager.compileReport(jasperPath + "/" + rpt);
            //JasperPrint jp = JasperFillManager.fillReport(jr, pm, resultSetDataSource);


                //JasperExportManager.exportReportToPdfFile(jp, jasperPath + pdfName + ".pdf");
                //fileInputStream = new FileInputStream(new File(jasperPath + pdfName + ".pdf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
}

