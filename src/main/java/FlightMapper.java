import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class FlightMapper extends Mapper<LongWritable, Text, AirportPair, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        CSVParser parser = CSVParser.parse(value.toString(), CSVFormat.RFC4180);
        for (CSVRecord csvRecord : parser) {
            String del = csvRecord.get(18);
            if (!del.equals("")) {
                context.write(new AirportPair(csvRecord.get(14), 1), new Text(del));
            }
        }
    }
}
