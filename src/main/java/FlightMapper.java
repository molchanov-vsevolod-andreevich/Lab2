import java.io.IOException;

import org.apache.commons.csv.CSVRecord;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class FlightMapper extends Mapper<LongWritable, Text, AirportPair, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() == 0) { // header CSV
            return;
        }
        CSVRecord csvRecord = Util.getCsvRecord(value);
        String delay = csvRecord.get(18);
        if (!delay.equals("")) {
            context.write(new AirportPair(csvRecord.get(14), 1), new Text(delay));
        }
    }
}
