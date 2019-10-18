import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class FlightMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        CSVParser parser = CSVParser.parse(value.toString(), CSVFormat.RFC4180);
        boolean i = true;
        for (CSVRecord csvRecord : parser) {
            if (i) {
                i = false;
                continue;
            }
            String del = csvRecord.get(18);
            if (!del.equals("")) {
                context.write(new Text(csvRecord.get(14)), new Text("delay:" + del));
            }
        }
    }
}
