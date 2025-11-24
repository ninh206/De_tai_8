import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHelper {

    // Ghi danh sach cac dong (lines) vao file
    public static void write(String fileName, List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Loi ghi file " + fileName + ": " + e.getMessage());
        }
    }

    // Doc tat ca cac dong tu file
    public static List<String> read(String fileName) {
        List<String> lines = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) return lines; // File chua co thi tra ve list rong

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Loi doc file " + fileName + ": " + e.getMessage());
        }
        return lines;
    }
}