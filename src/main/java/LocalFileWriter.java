import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class LocalFileWriter {
    public static void main(String[] args) throws IOException{
        String content = "this is an example";
        String dest = "D:\\java_writer.txt";

        File file = new File(dest);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(content.getBytes("UTF-8"));
        fileOutputStream.close();
    }
}
