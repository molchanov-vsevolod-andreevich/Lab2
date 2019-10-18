import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {
        float time = 0f;
        float count = 0f;
        float min = 100000f;
        float max = 0f;
        String name = "";
        for (Text t : values) {
            String parts[] = t.toString().split(":");
            if (parts[0].equals("delay")) {
                count++;
                float del = Float.parseFloat(parts[1]);
                time += del;
                if (del > max) {
                    max = del;
                }
                if (del < min) {
                    min = del;
                }
            } else {
                name = key.toString() + " " + "\"" + parts[1] + "\"";
            }
        }
        if (count == 0f || time == 0f) {
//            context.write(new Text(name), new FloatWritable(0.0f));
        } else {
            float res = time / count;
            context.write(new Text(name), new Text("\n\taverage: " + Float.toString(res) + "\n\tmin: " + Float.toString(min) + "\n\tmax: " + Float.toString(max)));
        }
    }
}
