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

    public static final String calculateDelaysInfo(Iterator<Text> delays) {
        float time = 0f;
        float count = 0f;
        float min = Float.MAX_VALUE;
        float max = Float.MIN_VALUE;
        while (delays.hasNext()) {
            float nextDelay = Float.parseFloat(delays.next().toString());
            count++;
            time += nextDelay;
            if (nextDelay != 0f) {
                if (nextDelay > max) {
                    max = nextDelay;
                }
                if (nextDelay < min) {
                    min = nextDelay;
                }
            }
        }

        if (count == 0f || time == 0f) {
            return " No delays";
        } else {
            float res = time / count;
            return "\n\taverage: " + res + "\n\tmin: " + min + "\n\tmax: " + max;
        }
    }

    public static final Text getAirportName(Iterator<Text> iter) {
        return iter.next();
    }

    public static final boolean delayExists(String delay) {
        if (delay.equals("")) {
            return false;
        }
        return true;
    }
}
