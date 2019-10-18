import org.apache.hadoop.mapreduce.Partitioner;

public class AirportPartitioner extends Partitioner<AirportPair, > {
    @Override
    public int getPartition(Object o, Object o2, int i) {
        return 0;
    }
}
