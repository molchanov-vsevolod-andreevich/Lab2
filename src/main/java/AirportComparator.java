import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirportComparator extends WritableComparator {
    protected AirportComparator() {
        super(AirportPair.class);
    }

    @Override
    public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
        Integer i1 = readInt(b1, s1);
        Integer i2 = readInt(b2, s2);
        return 
    }

    @Override
    public int compare(WritableComparable o1, WritableComparable o2) {
//        AirportPair airport1 = (AirportPair) o1;
//        AirportPair airport2 = (AirportPair) o2;
//        System.out.println(airport1.getAirportID() + " : " + airport2.getAirportID() + " => " + airport1.getAirportID().compareTo(airport2.getAirportID()));
//        return airport1.getAirportID().compareTo(airport2.getAirportID());
        return o1.compareTo(o2);
    }
}