import org.apache.commons.csv.CSVRecord;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

public abstract class Util {
    public static final CSVRecord parseCvsWithHeader (LongWritable lineNumber, Text line) {
        if (lineNumber == 0) {
            return CSVRecord("header");
        } else {

        }
    }
}
