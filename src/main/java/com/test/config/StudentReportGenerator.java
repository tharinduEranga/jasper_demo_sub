package com.test.config;

import com.test.model.StudentReportInput;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Tharindu Eranga
 * @date Wed 27 Jan 2021
 */
public class StudentReportGenerator {
    public void generateReport() throws IOException {
        StudentReportInput studentReportInput = StudentReportDataAssembler.assemble();

        String folder = "D:\\TestExamples\\jasper_sub_list\\src\\main\\resources\\";
        File file = new File(folder + "student_sub.jasper");
        try (InputStream inputStream = new FileInputStream(file)) {

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);

            JRMapArrayDataSource dataSource = new JRMapArrayDataSource(new Object[]{studentReportInput.getDataSources()});

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                    studentReportInput.getParameters(), dataSource);

            JasperExportManager.exportReportToPdfFile(jasperPrint, folder + "student_sub.pdf");
            JasperViewer jv = new JasperViewer(jasperPrint, true);
            jv.setTitle("Student");
            jv.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
