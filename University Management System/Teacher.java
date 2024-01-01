import java.util.ArrayList;

public class Teacher extends Person {
    private final ArrayList<Course> coursesTaught;
    private final TimeSheet timeTable;

    public Teacher(int teacherId, String name) {
        super(teacherId, name);
        this.timeTable = new TimeSheet();
        this.coursesTaught = new ArrayList<>();
    }

    void updateTimeTable(Course course) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (course.getTimeTable()[i][j] && !timeTable.isOccupied(i, j))
                    timeTable.addCourse(course, i, j);
            }
        }
    }

    public void assignCourse(Course course) {
        updateTimeTable(course);
        coursesTaught.add(course);
    }

    public void displayInfo() {
        System.out.println("----------------------------");
        System.out.println("Teacher ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Courses Taught:");
        for (Course course : coursesTaught) {
            System.out.println("  - " + course);
        }
        System.out.println("-----------------------------");
    }

    public void displayTimeTable() {
        System.out.println("Teacher ID: " + id);
        System.out.println("Name: " + name);
        timeTable.display();
    }
}
