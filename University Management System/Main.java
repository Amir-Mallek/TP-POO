import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Amir Mallek");
        Student student2 = new Student(2, "Med Amine Mnejja");
        Student student3 = new Student(3, "Sami Ben Salah");

        Teacher teacher1 = new Teacher(1, "Sofien Smaoui");
        Teacher teacher2 = new Teacher(2, "Anwar Lajmi");
        Teacher teacher3 = new Teacher(3, "Abdelwaheb Cheffi");

        Course course1 = new Course("MT110", "Analyse I");
        Course course2 = new Course("AR111", "Arabe II");
        Course course3 = new Course("PH220", "Physique II");

        Club club1 = new Club("ACM", "Association for Computing Machinery");
        Club club2 = new Club("IEEE", "Institute of Electrical and Electronics Engineers");
        Club club3 = new Club("JEI", "Junior Entreprise INSAT");

        student1.joinClub(club1);
        student1.joinClub(club2);
        student2.joinClub(club2);
        student2.joinClub(club3);
        student3.joinClub(club3);
        student3.joinClub(club1);

        Admin.assignCourseTimeTable(course1, 0, 0);
        Admin.assignCourseTimeTable(course1, 0, 1);
        Admin.assignCourseTimeTable(course1, 0, 2);
        Admin.assignCourseTimeTable(course1, 0, 3);
        Admin.assignCourseTimeTable(course1, 0, 4);

        Admin.assignCourseTimeTable(course2, 1, 0);
        Admin.assignCourseTimeTable(course2, 1, 1);
        Admin.assignCourseTimeTable(course2, 1, 2);
        Admin.assignCourseTimeTable(course2, 1, 3);
        Admin.assignCourseTimeTable(course2, 1, 4);

        Admin.assignCourseTimeTable(course3, 2, 0);
        Admin.assignCourseTimeTable(course3, 2, 1);
        Admin.assignCourseTimeTable(course3, 2, 2);
        Admin.assignCourseTimeTable(course3, 2, 3);
        Admin.assignCourseTimeTable(course3, 2, 4);

        Admin.assignTeacherCourse(teacher1, course1);
        Admin.assignTeacherCourse(teacher2, course2);
        Admin.assignTeacherCourse(teacher3, course3);

        Admin.enrollStudentCourse(student1, course1);
        Admin.enrollStudentCourse(student1, course2);
        Admin.enrollStudentCourse(student2, course2);
        Admin.enrollStudentCourse(student2, course3);
        Admin.enrollStudentCourse(student3, course3);
        Admin.enrollStudentCourse(student3, course1);

        teacher1.displayInfo();
        teacher2.displayInfo();
        teacher3.displayInfo();

        student1.displayInfo();
        student2.displayInfo();
        student3.displayInfo();

        teacher1.displayTimeTable();
        teacher2.displayTimeTable();
        teacher3.displayTimeTable();

        student1.displayTimeTable();
        student2.displayTimeTable();
        student3.displayTimeTable();

    }
}
