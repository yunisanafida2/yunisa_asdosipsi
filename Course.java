
import java.util.Vector;
import java.util.Enumeration;

public class Course {

    private String title;
    private Vector<CourseRecord> courseRecords;

    Course() {
        courseRecords = new Vector<CourseRecord>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void addCourseRecord(CourseRecord cr) {
        courseRecords.addElement(cr);
    }

    public Enumeration<CourseRecord> getCourseRecords() {
        return courseRecords.elements();
    }

    public void printCourseStudents() {
        Enumeration<CourseRecord> records = getCourseRecords();

        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();
            Student student = cr.getStudent();

            if (student != null) {
                System.out.println(student.getName());
            }
        }
    }

    public void printBestStudent() {
        Student bestStudent = null;
        double bestAverage = -1;

        Enumeration<CourseRecord> records = getCourseRecords();

        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();
            Student student = cr.getStudent();

            if (student == null) {
                continue;
            }

            Enumeration<Assignment> assignments = cr.getAssignments();
            double total = 0;
            int count = 0;

            while (assignments.hasMoreElements()) {
                Assignment assignment = assignments.nextElement();

                try {
                    total += assignment.getMark();
                    count++;
                } catch (NotYetSetException e) {
                    // Nilai yang belum diisi tidak dihitung.
                }
            }

            if (count > 0) {
                double average = total / count;

                if (average > bestAverage) {
                    bestAverage = average;
                    bestStudent = student;
                }
            }
        }

        if (bestStudent != null) {
            System.out.println(
                bestStudent.getName()
                + " dengan rata-rata "
                + bestAverage
            );
        } else {
            System.out.println(
                "Belum ada nilai yang dapat dihitung."
            );
        }
    }

    public void printFinalExamStudents() {
        // Aturan kelayakan ujian akhir belum ditentukan dalam soal.
        System.out.println(
            "Aturan kelayakan ujian akhir belum ditentukan."
        );
    }
}
