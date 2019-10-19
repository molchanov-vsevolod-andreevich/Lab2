import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirportPartitioner extends Partitioner<AirportPair, Text> {
    @Override
    public int getPartition(AirportPair key, Text value, int numReduceTasks) {
        if (Integer.parseInt(key.getAirportID().toString()) < Common.HALF_OF_AIRPORTS_IDS) {
            return 0;
        } else {
            return 1;
        }
    }
}