import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirportPartitioner extends Partitioner<AirportPair, Text> {
    @Override
    public int getPartition(AirportPair key, Text value, int numReduceTasks) {
        System.out.println(key.getAirportID());
        if (key.getAirportID().compareTo(new Text("3343")) == -1) {
            return 0;
        } else {
            return 1;
        }
    }
}