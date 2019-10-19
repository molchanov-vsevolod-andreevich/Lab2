import org.apache.commons.csv.CSVRecord;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

public abstract class Util {
    public static final String getCsvRecordExcludeHeader (LongWritable lineNumber, Text line) {
        if (lineNumber.get() == 0) {
            return
        } else {

        }
    }
}
