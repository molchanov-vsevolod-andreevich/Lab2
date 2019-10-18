import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Partitioner;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportPair implements WritableComparable<AirportPair> {
    private Text AIRPORT_ID;
    private IntWritable INSERT_ID;

    public AirportPair(Text airportID, IntWritable insertID) {
        AIRPORT_ID = airportID;
        INSERT_ID = insertID;
    }

    public AirportPair(Text airportID, int insertID) {
        AIRPORT_ID = airportID;
        INSERT_ID = new IntWritable(insertID);
    }

    public AirportPair(String airportID, IntWritable insertID) {
        AIRPORT_ID = new Text(airportID);
        INSERT_ID = insertID;
    }

    public AirportPair(String airportID, int insertID) {
        AIRPORT_ID = new Text(airportID);
        INSERT_ID = new IntWritable(insertID);
    }

    public AirportPair() {}

    public Text getAirportID() {
        return AIRPORT_ID;
    }

    public IntWritable getInsertID() {
        return INSERT_ID;
    }

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
    public int compareTo(AirportPair o) {
        int res = INSERT_ID.compareTo(o.INSERT_ID);
        if (res == 0) {
            res = AIRPORT_ID.compareTo(o.AIRPORT_ID);
        }
        return res;
    }

    public class AirportComparator extends WritableComparator {
//        protected AirportComparator() {
//            super((Class<? extends WritableComparable>) AirportComparator.class, true);
//        }

        @Override
        public int compare(WritableComparable o1, WritableComparable o2) {
            AirportPair airport1 = (AirportPair) o1;
            AirportPair airport2 = (AirportPair) o2;
            return airport1.AIRPORT_ID.compareTo(airport2.AIRPORT_ID);
        }
    }
}
