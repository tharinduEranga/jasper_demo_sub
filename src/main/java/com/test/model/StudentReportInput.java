package com.test.model;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tharindu Eranga
 * @date Wed 27 Jan 2021
 */
public class StudentReportInput {
    private String reportTitle;
    private String instituteName;
    private JRBeanCollectionDataSource studentDataSource;

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public JRBeanCollectionDataSource getStudentDataSource() {
        return studentDataSource;
    }

    public void setStudentDataSource(JRBeanCollectionDataSource studentDataSource) {
        this.studentDataSource = studentDataSource;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("P_INSTITUTE_NAME", getInstituteName());

        return parameters;
    }

    public Map<String, Object> getDataSources() {
        Map<String, Object> dataSources = new HashMap<>();
        dataSources.put("studentDataSource", studentDataSource);

        return dataSources;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }
}
