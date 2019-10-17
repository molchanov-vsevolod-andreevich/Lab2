import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWritable implements Writable {
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

    public static FlightWritable read(DataInput in) throws IOException {
        FlightWritable w = new FlightWritable();
        w.readFields(in);
        return w;
    }
}
