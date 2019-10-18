import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<AirportPair, Text, Text, Text> {
    @Override
    protected void reduce(AirportPair key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        Text airportName = new Text(iter.next());

        float time = 0f;
        float count = 0f;
        float min = Float.MIN_VALUE;
        float max = Float.MAX_VALUE;
        while (iter.hasNext()) {
            float nextDelay = Float.parseFloat(iter.next().toString());
            count++;
            time += nextDelay;

            if (nextDelay > max) {
                max = nextDelay;
            }
            if (nextDelay < min) {
                min = nextDelay;
            }
        }

        if (count == 0f || time == 0f) {
            context.write(key.getAirportID(), new Text(airportName.toString() + " No delays"));
        } else {
            float res = time / count;
            context.write(key.getAirportID(), new Text(airportName.toString() + "\n\taverage: " + res + "\n\tmin: " + min + "\n\tmax: " + max));
        }
    }
}
