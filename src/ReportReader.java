import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ReportReader {
    String reportsPath = "./resources/";
    File f = new File(reportsPath);

    public ArrayList<String> getReportContents(String reportSignature) {
        ArrayList<String> fileNames = getAvailableReportsFileNamesFromExplorer(reportSignature);

        ArrayList<String> filesContents = new ArrayList<>();
        for (String fileName : fileNames) {
            String fullPath = reportsPath + fileName;
            String fileContents = readFileContentsOrNull(fullPath);
            filesContents.add(fileContents);
        }
        return filesContents;
    }

    private ArrayList<String> getAvailableReportsFileNamesFromExplorer(String reportSignature) {
        String[] filesList = f.list();
        ArrayList<String> reportNames = new ArrayList<>();
        for (String fileName : filesList) {
            if (fileName.startsWith(reportSignature)) {
                reportNames.add(fileName);
            }
        }
        return reportNames;
    }

    private String readFileContentsOrNull(String path)
    {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

}
