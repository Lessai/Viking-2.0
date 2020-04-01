package com.dp.viking.domain.dto;

public class EmploymentContractContext {
    private String name;
    private static final String TEMPLATE_DOC_PATH = "C:/Study/DP/Doc_templates/";
    private static final String READY_DOC_PATH = "C:/Study/DP/Ready_doc/Приказы_о_найме/";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getTemplateDocPathDocPath() {
        return TEMPLATE_DOC_PATH;
    }

    public static String getReadyDocPath() {
        return READY_DOC_PATH;
    }
}
