import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public abstract class Util {
    public static final CSVRecord getCsvRecord(Text line) throws IOException {
        return CSVParser.parse(line.toString(), CSVFormat.RFC4180).getRecords().get(0);
    }
}
