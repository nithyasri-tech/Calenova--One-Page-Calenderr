import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class OnePageYearCalendar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = sc.nextInt();

        String[] months = {
            "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
            "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"
        };

        System.out.println("\nONE PAGE CALENDAR - " + year + "\n");

        // Print month header
        System.out.printf("%-6s", "DATE");
        for (String m : months) {
            System.out.printf("%-6s", m);
        }
        System.out.println();

        // Dates 1 to 31
        for (int date = 1; date <= 31; date++) {
            System.out.printf("%-6d", date);

            for (int month = 1; month <= 12; month++) {
                try {
                    LocalDate d = LocalDate.of(year, month, date);
                    String day = d.getDayOfWeek()
                                  .getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
                    System.out.printf("%-6s", day);
                } catch (Exception e) {
                    // Date does not exist (like Feb 30)
                    System.out.printf("%-6s", "");
                }
            }
            System.out.println();
        }
    }
}
