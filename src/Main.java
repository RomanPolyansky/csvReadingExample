public class Main {
    public static void main(String[] args) {

        ReportReader reportReader = new ReportReader();

        System.out.println("Месячные отчёты:");
        System.out.println(reportReader.getReportContents('m'));

        System.out.println("Годовые отчёты:");
        System.out.println(reportReader.getReportContents('y'));
    }
}
