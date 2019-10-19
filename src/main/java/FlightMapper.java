import java.io.IOException;

import org.apache.commons.csv.CSVRecord;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class FlightMapper extends Mapper<LongWritable, Text, AirportPair, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() == Common.CSV_HEADER_ID) {
            return;
        }
        CSVRecord csvRecord = Util.getCsvRecord(value);
        String delay = csvRecord.get(Common.CSV_DELAY_INDEX);
        if (Util.delayExists(delay)) {
            context.write(new AirportPair(csvRecord.get(Common.CSV_FLIGHTS_AIRPORT_ID_INDEX), 1), new Text(delay));
        }
    }
}
