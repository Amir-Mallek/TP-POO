public class Admin {
    public static void assignTeacherCourse(Teacher teacher, Course course) {
        teacher.assignCourse(course);
    }

    public static void enrollStudentCourse(Student student, Course course) {
        student.enrollCourse(course);
    }

    public static void assignCourseTimeTable(Course course, int day, int hour) {
        course.assignTime(day, hour);
    }
}
