import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.File;
import java.nio.charset.StandardCharsets;
java.io.IO

public class Parser {
    public static void main(String[] args) {
        File csvData = new File("/path/to/csv");
        CSVParser parser = CSVParser.parse(csvData, StandardCharsets.UTF_8, CSVFormat.RFC4180);
        for (CSVRecord csvRecord : parser) {
            System.out.println(csvRecord);
        }
    }
}