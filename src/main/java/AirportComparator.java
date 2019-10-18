import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirportComparator extends WritableComparator {
    @Override
    public int compare(WritableComparable o1, WritableComparable o2) {
        AirportPair airport1 = (AirportPair) o1;
        AirportPair airport2 = (AirportPair) o2;
        return airport1.getAirportID().compareTo(airport2.getAirportID());
    }
}