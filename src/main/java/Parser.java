import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Parser {
    public static void main(String[] args) {
        File csvData = new File("/path/to/csv");
        CSVParser parser = CSVParser.parse(csvData, CSVFormat.RFC4180);
        for (CSVRecord csvRecord : parser) {
            System.out.println(csvRecord);
        }
    }
}