package com.dp.viking.domain.dto;

import java.util.Date;

public class DismissalOrderContext {
    private String firstName;
    private String dismissionReason;
    private Date dateOut;
    private Date dateIn;
    private String secondName;
    private String title;
    private static final String TEMPLATE_DOC_PATH = "C:/Study/DP/Doc_templates/";
    private static final String READY_DOC_PATH = "C:/Study/DP/Ready_doc/Приказы_об_увольнении/";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDismissionReason() {
        return dismissionReason;
    }

    public void setDismissionReason(String dismissionReason) {
        this.dismissionReason = dismissionReason;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static String getTemplateDocPath() {
        return TEMPLATE_DOC_PATH;
    }

    public static String getReadyDocPath() {
        return READY_DOC_PATH;
    }
}
