public class Parser {
    
    File csvData = new File("/path/to/csv");
    CSVParser parser = CSVParser.parse(csvData, CSVFormat.RFC4180);
    for (CSVRecord csvRecord : parser) {

    }
}