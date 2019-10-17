import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvWritable implements Writable {
    private int counter;
    private long timestamp;
    
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(counter);
        out.writeLong(timestamp);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        counter = in.readInt();
        timestamp = in.readLong();
    }

    public static CsvWritable read(DataInput in) throws IOException {
        CsvWritable w = new CsvWritable();
        w.readFields(in);
        return w;
    }
}
