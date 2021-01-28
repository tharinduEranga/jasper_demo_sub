package com.test;

import com.test.config.StudentReportGenerator;

import java.io.IOException;

/**
 * @author Tharindu Eranga
 * @date Wed 27 Jan 2021
 */
public class Run {
    public static void main(String[] args) {
        try {
            new StudentReportGenerator().generateReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
