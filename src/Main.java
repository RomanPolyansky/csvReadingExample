import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ReportReader reportReader = new ReportReader();

        ArrayList<String> monthlyReports = reportReader.getReportContents("m");
        ArrayList<String> annualReports = reportReader.getReportContents("y");

        System.out.println("Месячные отчёты:");
        System.out.println(monthlyReports);

        System.out.println("Годовые отчёты:");
        System.out.println(annualReports);
    }
}
