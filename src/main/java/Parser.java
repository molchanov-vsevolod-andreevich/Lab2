

public class Parser {
    public static void main(String[] args) {
        File csvData = new File("/path/to/csv");
        CSVParser parser = CSVParser.parse(csvData, CSVFormat.RFC4180);
        for (CSVRecord csvRecord : parser) {
            System.out.println(csvRecord);
        }
    }
}