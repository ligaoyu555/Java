import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

public class FileReader {
    public static void main(String[] args) throws IOException {
        String dest = "hdfs://10.3.2.64:8020/tmp/java_writer.txt";

        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create(dest), configuration);
        FSDataInputStream in = fileSystem.open(new Path(dest));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        in.close();
    }
}
