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
    private ArrayWritable records;
    
    @Override
    public void write(DataOutput out) throws IOException {
        records.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        records.readFields(in);
    }

    public static AirportPair read(DataInput in) throws IOException {
        AirportPair w = new AirportPair();
        w.readFields(in);
        return w;
    }
}
