import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Parser {
    public static void main(String[] args) throws IOException {
        String s = ""

//        String content = new String(Files.readAllBytes(Paths.get("src/main/resources/L_AIRPORT_ID.csv")));
//        CSVParser parser = CSVParser.parse(content, CSVFormat.RFC4180);
//        for (CSVRecord csvRecord : parser) {
//            System.out.println(csvRecord);
//        }

//        Reader in = new FileReader("src/main/resources/L_AIRPORT_ID.csv");
//        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
//        for (CSVRecord record : records) {
//            System.out.println(record.get(0));
//        }
//        in.close();

//        File csvData = new File("src/main/resources/L_AIRPORT_ID.csv");
//        CSVParser parser = CSVParser.parse(csvData, StandardCharsets.UTF_8, CSVFormat.RFC4180);
////        List<CSVRecord> l = parser.getRecords();
//        for (CSVRecord csvRecord : parser) {
////            for (String s : csvRecord) {
////                System.out.print(s + " ");
////            }
////            System.out.println();
//            System.out.println(csvRecord);
//        }
////        for (CSVRecord r : l) {
////            String s = r.toString();
////            System.out.println(s);
////        }
    }
}