public class TimeSheet {
    private final Course[][] timeSheet;

    public TimeSheet() {
        timeSheet = new Course[5][8];
    }

    public void addCourse(Course course, int day, int hour) {
        timeSheet[day][hour] = course;
    }

    private String getDay(int i) {
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri"};
        return days[i];
    }

    public void display() {
        System.out.println("TimeSheet:");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("    | 09:00 | 10:00 | 11:00 | 12:00 | 13:00 | 14:00 | 15:00 | 16:00 |");
        System.out.println("--------------------------------------------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.print(getDay(i) + " | ");
            for (int j = 0; j < 8; j++) {
                if (timeSheet[i][j] != null) {
                    System.out.print(timeSheet[i][j].getCourseCode() + " | ");
                } else {
                    System.out.print("      | ");
                }
            }
            System.out.println();
            System.out.println("--------------------------------------------------------------------");
        }
    }

    public boolean isOccupied(int day, int hour) {
        return timeSheet[day][hour] != null;
    }
}
