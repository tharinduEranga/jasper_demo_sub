package com.test.config;

import com.test.model.Course;
import com.test.model.Student;
import com.test.model.StudentReportInput;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tharindu Eranga
 * @date Wed 27 Jan 2021
 */
public class StudentReportDataAssembler {
    public static StudentReportInput assemble() {
        StudentReportInput studentReportInput = new StudentReportInput();
        studentReportInput.setReportTitle("Student Report");
        studentReportInput.setInstituteName("My Institute");

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            //Add Student1
            Student student = new Student();
            student.setName("Mark" + i);
            student.setEmail("mark1234@gmail.com" + i);
            students.add(student);

            List<Course> studentCourses = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                Course courseStudent = new Course();
                courseStudent.setName("History" + j);
                courseStudent.setLocation("L1" + j);
                studentCourses.add(courseStudent);
            }

            student.setCourseList(studentCourses);
        }

        JRBeanCollectionDataSource studentDataSource = new JRBeanCollectionDataSource(students, false);
        studentReportInput.setStudentDataSource(studentDataSource);

        return studentReportInput;
    }
}
