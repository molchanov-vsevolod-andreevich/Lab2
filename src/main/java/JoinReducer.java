import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<AirportPair, Text, Text, Text> {
    @Override
    protected void reduce(AirportPair key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        context.write(key.getAirportID(), new Text(Util.getAirportName(iter) + Util.calculateDelaysInfo(iter)));
    }
}
