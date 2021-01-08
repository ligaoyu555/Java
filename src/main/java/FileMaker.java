import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsAction;
import org.apache.hadoop.fs.permission.FsPermission;

import java.io.IOException;
import java.net.URI;

public class FileMaker {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();

        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://10.3.2.64:8020"), configuration);
        fileSystem.mkdirs(new Path("hdfs://10.3.2.64:8020/tmp/java"));
        fileSystem.mkdirs(new Path("hdfs://10.3.2.64:8020/tmp/java"),
                new FsPermission(FsAction.ALL, FsAction.EXECUTE, FsAction.NONE));

    }
}
