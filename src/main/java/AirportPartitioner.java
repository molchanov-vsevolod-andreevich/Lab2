import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirportPartitioner extends Partitioner<AirportPair, Text> {
    @Override
    public int getPartition(AirportPair key, Text value, int numReduceTasks) {
        return 0;
    }
}
