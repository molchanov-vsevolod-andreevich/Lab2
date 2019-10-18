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

    public class AirportPartitioner extends Partitioner<AirportPair, Text> {
        @Override
        public int getPartition(AirportPair key, Text value, int numReduceTasks) {
            if (key.AIRPORT_ID.compareTo(new Text("3343")) == -1) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public class AirportComparator implements RawComparator<AirportPair> {
//        @Override
//        public int compare(byte[] bytes, int i, int i1, byte[] bytes1, int i2, int i3) {
//            return 0;
//        }
        protected AirportComparator() {
            super()
        }

        @Override
        public int compare(AirportPair o1, AirportPair o2) {
            return o1.AIRPORT_ID.compareTo(o2.AIRPORT_ID);
        }
    }
}
