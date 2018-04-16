package ch07.action;

import com.opensymphony.xwork2.ActionSupport;

public class FieldValidationAction extends ActionSupport {
    private String requiredValidator = null;
    private String requiredStringValidator= null;
    private Integer integerValidator = null;

    private String emailValidator = null;
    private String urlValidator = null;
    private String stringLengthValidator = null;
    private String regexValidator = null;
    private String fieldExpressionValidator = null;

    public String execute()throws Exception{
        return SUCCESS;
    }

    public String getRequiredValidator() {
        return requiredValidator;
    }

    public void setRequiredValidator(String requiredValidator) {
        this.requiredValidator = requiredValidator;
    }

    public String getRequiredStringValidator() {
        return requiredStringValidator;
    }

    public void setRequiredStringValidator(String requiredStringValidator) {
        this.requiredStringValidator = requiredStringValidator;
    }

    public Integer getIntegerValidator() {
        return integerValidator;
    }

    public void setIntegerValidator(Integer integerValidator) {
        this.integerValidator = integerValidator;
    }

    public String getEmailValidator() {
        return emailValidator;
    }

    public void setEmailValidator(String emailValidator) {
        this.emailValidator = emailValidator;
    }

    public String getUrlValidator() {
        return urlValidator;
    }

    public void setUrlValidator(String urlValidator) {
        this.urlValidator = urlValidator;
    }

    public String getStringLengthValidator() {
        return stringLengthValidator;
    }

    public void setStringLengthValidator(String stringLengthValidator) {
        this.stringLengthValidator = stringLengthValidator;
    }

    public String getRegexValidator() {
        return regexValidator;
    }

    public void setRegexValidator(String regexValidator) {
        this.regexValidator = regexValidator;
    }

    public String getFieldExpressionValidator() {
        return fieldExpressionValidator;
    }

    public void setFieldExpressionValidator(String fieldExpressionValidator) {
        this.fieldExpressionValidator = fieldExpressionValidator;
    }
}
