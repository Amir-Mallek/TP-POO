public class Course {
    private final String courseCode;
    private final String courseName;
    private final boolean[][] timeTable;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.timeTable = new boolean[5][8];
    }

    public void assignTime(int day, int hour) {
        timeTable[day][hour] = true;
    }

    public boolean[][] getTimeTable() {
        return timeTable;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String toString() {
        return courseCode + " - " + courseName;
    }
}
