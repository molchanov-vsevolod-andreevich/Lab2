import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<Text, Text, Text, FloatWritable> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {
        float time = 0f;
        float count = 0f;
        String name = "";
        for (Text t : values) {
            String parts[] = t.toString().split(":");
            if (parts[0].equals("delay")) {
                count++;
                time += Float.parseFloat(parts[1]);
            } else {
                name = key.toString() + " " + "\"" + parts[1] + "\"";
            }
        }
        if (count == 0f) {
            context.write(new Text(name), new FloatWritable(0.0f));
        } else {
            float res = time / count;
            context.write(new Text(name), new FloatWritable(res));
        }
    }
}
