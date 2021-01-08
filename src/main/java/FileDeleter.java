import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

public class FileDeleter {
    public static void main(String[] args) throws IOException {
        String dest = "hdfs://10.3.2.64:8020/tmp/java_writer.txt";

        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create(dest), configuration);

       // fileSystem.delete(new Path(dest), false);

        fileSystem.delete(new Path("hdfs://10.3.2.64:8020/tmp/java"), true);
    }
}
