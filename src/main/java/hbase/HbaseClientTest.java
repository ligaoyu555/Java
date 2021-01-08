package hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HbaseClientTest {
    public static void main(String[] args) {
        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", "bxzj-test-bigdata01.bxzj.baixinlocal.com,  " +
                "bxzj-test-bigdata02.bxzj.baixinlocal.com,  " +
                "bxzj-test-bigdata03.bxzj.baixinlocal.com");

        try(Connection connection = ConnectionFactory.createConnection(configuration)) {
            Table table = connection.getTable(TableName.valueOf("twq:webtable"));
            //Put put = new Put(Bytes.toBytes("100"));
            String t = table.getConfiguration().get("hbase.zookeeper.quorum");
            System.out.println(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
