import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.util.Iterator;

public abstract class Util {
    public static final CSVRecord getCsvRecord(Text line) throws IOException {
        return CSVParser.parse(line.toString(), CSVFormat.RFC4180).getRecords().get(0);
    }

    public static final String getAirportId(CSVRecord record) {
        return record.get(0);
    }

    public static final String getAirportName(CSVRecord record) {
        return record.get(1);
    }

//    public static final String calculateDelaysInfo(Iterator<Text> delays) {
//
//    }

    public static final Text getAirportName(Iterator<Text> iter) {
        return iter.next();
    }
}
