import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVRecord;
//import java.io.File;
//import java.nio.charset.StandardCharsets;
//import java.util.List;

public class AirportPair implements WritableComparable {
    private Text AIRPORT_ID;
    private IntWritable INSERT_ID;
    
    @Override
    public void write(DataOutput out) throws IOException {
        AIRPORT_ID.write(out);
        INSERT_ID.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        AIRPORT_ID.readFields(in);
        INSERT_ID.readFields(in);
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
