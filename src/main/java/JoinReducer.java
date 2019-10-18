import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<AirportPair, Text, Text, Text> {
    @Override
    protected void reduce(AirportPair key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        Text airportName = new Text(iter.next());
        float time = 0f;
        float count = 0f;
        float min = 100000f;
        float max = 0f;
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
            context.write(, new Text("No delays"));
        } else {
            float res = time / count;
            context.write(new Text(name), new Text("\n\taverage: " + Float.toString(res) + "\n\tmin: " + Float.toString(min) + "\n\tmax: " + Float.toString(max)));
        }
    }
}
