import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirportPartitioner extends Partitioner<AirportPair, Text> {
    @Override
    public int getPartition(AirportPair key, Text value, int numReduceTasks) {
//        System.out.println(key.getAirportID());
        if (key.getAirportID().compareTo(new Text("13344")) == -1) {
//            System.out.println("YYYYYEEEEEEEESSSSSS");
            return 0;
        } else {
//            System.out.println("NOOOOOOOOOOOOOOOOOO");
            return 1;
        }
//        return (key.getAirportID().hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }
}