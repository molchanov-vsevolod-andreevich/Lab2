import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirportPartitioner extends Partitioner<AirportPair, Text> {
    @Override
    public int getPartition(AirportPair key, Text value, int numReduceTasks) {
        if (Integer.parseInt(key.getAirportID().toString()) < 13344) {
            return 0;
        } else {
            return 1;
        }
//        return (key.getAirportID().hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }
}