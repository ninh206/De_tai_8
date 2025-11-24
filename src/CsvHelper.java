import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHelper {

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

    public static List<String> read(String fileName) {
        List<String> lines = new ArrayList<>();
        File file = new File(fileName);

        // Kiem tra file ton tai truoc khi doc
        if (!file.exists()) {
            System.out.println("Luu y: File " + fileName + " chua ton tai (se tu tao moi).");
            return lines;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Loi doc file: " + e.getMessage());
        }
        return lines;
    }
}