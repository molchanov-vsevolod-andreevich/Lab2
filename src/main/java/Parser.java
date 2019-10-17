import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
//import java.util.List;

public class Parser {
    public static void main(String[] args) throws IOException {
        File csvData = new File("src/main/resources/L_AIRPORT_ID.csv");
        CSVParser parser = CSVParser.parse(csvData, StandardCharsets.UTF_8, CSVFormat.RFC4180);
//        List<CSVRecord> l = parser.getRecords();
//        for (CSVRecord csvRecord : parser) {
//            System.out.println(csvRecord.get(1));
//        }
//        for (CSVRecord r : l) {
//            String s = r.toString();
//            System.out.println(s);
//        }
    }
}