
public class Main {

    public static void main(String[] args) {

        Course course = new Course();
        course.setTitle("Praktikum Java");

        // Membuat mahasiswa pertama
        Student student1 = new Student();
        student1.setName("Alya");

        CourseRecord record1 = new CourseRecord();
        record1.setStudent(student1);

        Assignment assignment1 = new Assignment();
        assignment1.setMark(80);

        Assignment assignment2 = new Assignment();
        assignment2.setMark(90);

        record1.addAssignment(assignment1);
        record1.addAssignment(assignment2);
        course.addCourseRecord(record1);

        // Membuat mahasiswa kedua
        Student student2 = new Student();
        student2.setName("Bima");

        CourseRecord record2 = new CourseRecord();
        record2.setStudent(student2);

        Assignment assignment3 = new Assignment();
        assignment3.setMark(75);

        Assignment assignment4 = new Assignment();
        assignment4.setMark(85);

        record2.addAssignment(assignment3);
        record2.addAssignment(assignment4);
        course.addCourseRecord(record2);

        // Menguji method
        System.out.println(
            "Daftar mahasiswa pada "
            + course.getTitle()
            + ":"
        );
        course.printCourseStudents();

        System.out.println("\nMahasiswa dengan rata-rata terbaik:");
        course.printBestStudent();

        System.out.println("\nKelayakan ujian akhir:");
        course.printFinalExamStudents();
    }
}
