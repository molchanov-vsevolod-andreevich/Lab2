import java.io.IOException;

import javafx.print.Collation;
import org.apache.commons.csv.CSVRecord;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class AirportMapper extends Mapper<LongWritable, Text, AirportPair, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() == Common.CSV_HEADER_ID) {
            return;
        }
        CSVRecord csvRecord = Util.getCsvRecord(value);
        context.write(new AirportPair(csvRecord.get(Common.CSV_AIRPORTS_AIRPORT_ID_INDEX), 0),
                new Text(csvRecord.get(Common.CSV_AIRPORT_NAME_INDEX)));
    }
}
