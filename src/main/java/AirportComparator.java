import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

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