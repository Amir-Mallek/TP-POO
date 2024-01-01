import java.util.ArrayList;

public class Student extends Person {
    private final ArrayList<Course> courses;
    private final ArrayList<Club> clubsJoined;

    public Student(int studentId, String name) {
        super(studentId, name);
        this.courses = new ArrayList<>();
        this.clubsJoined = new ArrayList<>();
        this.timeTable = new TimeSheet();
    }

    void updateTimeTable(Course course) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (count == 3) break;
                if (course.getTimeTable()[i][j] && !timeTable.isOccupied(i, j)) {
                    timeTable.addCourse(course, i, j);
                    count++;
                }
            }
        }
    }

    public void enrollCourse(Course course) {
        updateTimeTable(course);
        courses.add(course);
    }

    public void joinClub(Club club) {
        clubsJoined.add(club);
    }

    public void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Courses Enrolled:");
        for (Course course : courses) {
            System.out.println("  - " + course);
        }
        System.out.println("Clubs Joined:");
        for (Club club : clubsJoined) {
            System.out.println("  - " + club);
        }
        System.out.println("-----------------------------");
    }

    public void displayTimeTable() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        timeTable.display();
    }
}
