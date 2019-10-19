import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

public abstract class Util {
    public static final CSVRecord getCsvRecord(Text line) {
        return CSVParser parser = CSVParser.parse(value.toString(), CSVFormat.RFC4180);
    }
}
