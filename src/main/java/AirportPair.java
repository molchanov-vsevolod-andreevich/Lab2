import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportPair implements WritableComparable<AirportPair> {
    private Text airportID;
    private IntWritable insertID;

    public AirportPair(Text airportID, IntWritable insertID) {
        this.airportID = airportID;
        this.insertID = insertID;
    }

    public AirportPair(Text airportID, int insertID) {
        this.airportID = airportID;
        this.insertID = new IntWritable(insertID);
    }

    public AirportPair(String airportID, IntWritable insertID) {
        this.airportID = new Text(airportID);
        this.insertID = insertID;
    }

    public AirportPair(String airportID, int insertID) {
        this.airportID = new Text(airportID);
        this.insertID = new IntWritable(insertID);
    }

    public AirportPair() {
        airportID = new Text("0");
        insertID = new IntWritable(-1);
    }

    public Text getAirportID() {
        return airportID;
    }

    public IntWritable getInsertID() {
        return insertID;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        airportID.write(out);
        insertID.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        airportID.readFields(in);
        insertID.readFields(in);
    }

    @Override
    public int compareTo(AirportPair o) {
        int res = airportID.compareTo(o.airportID);
        if (res == 0) {
            res = insertID.compareTo(o.insertID);
        }
        return res;
    }
}
