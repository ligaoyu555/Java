import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.net.URI;
import org.apache.hadoop.conf.Configuration;

public class fileSize {
//    public static void main(String[] args) {
//
//    }


    @Test
    public void listFile() throws Exception {
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://10.3.2.64:8020"), new Configuration());
        FileStatus[] fileStatuses = fileSystem.listStatus(new Path("/user/lgy11/warehouse/test1"));
        for (FileStatus fileStatus : fileStatuses) {
            if (fileStatus.isDirectory()) {
                Path path = fileStatus.getPath();
                listAllFile(fileSystem, path);
            } else {
                System.out.println("文件路径为 " + fileStatus.getPath().toString() + " 文件大小为 " + fileSystem.getContentSummary(fileStatus.getPath()).getLength());
            }
        }
    }


    public void listAllFile(FileSystem fileSystem, Path path) throws Exception {
        //System.out.println(fileSystem.getContentSummary(path));
        FileStatus[] fileStatuses = fileSystem.listStatus(path);
        for (FileStatus fileStatus : fileStatuses) {
            if (fileStatus.isDirectory()) {
                listAllFile(fileSystem, fileStatus.getPath());
                //System.out.println("file size is "+fileSystem.getContentSummary(fileStatus.getPath()));
            } else {
                Path path1 = fileStatus.getPath();
                System.out.println("文件路径为" + path1 + "文件大小为" + fileSystem.getContentSummary(path1).getLength());
            }
        }
    }
}