import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.junit.rules.TestWatcher;

import java.io.IOException;

public class Test1 {
    /**
     * 单机连接
     *
     * @throws IOException
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void test1() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:12181", 30000,
                new Watcher() {
                    public void process(WatchedEvent event) {
                        System.out.println("==================1");
                        System.out.println("event.getPath()：" + event.getPath());
                        System.out.println("event.getType()：" + event.getType());
                        System.out.println("event.getState()：" + event.getState());
                        System.out.println("==================2");
                    }
                });
        String node = "/node1";
        Stat stat = zk.exists(node, false);
        if (stat == null) {
            String createResult = zk
                    .create(node, "test1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createResult);
        }

        byte[] b = zk.getData(node, false, stat);
        System.out.println(new String(b));
        zk.close();
    }


    /**
     * 集群连接
     *
     * @throws IOException
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void test2() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:12181,127.0.0.1:12182,127.0.0.1:12183", 30000,
                new Watcher() {
                    public void process(WatchedEvent event) {
                        System.out.println("==================1");
                        System.out.println("event.getPath()：" + event.getPath());
                        System.out.println("event.getType()：" + event.getType());
                        System.out.println("event.getState()：" + event.getState());
                        System.out.println("==================2");
                    }
                });
        String node = "/node1";
        Stat stat = zk.exists(node, false);
        if (stat == null) {
            String createResult = zk
                    .create(node, "test1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("createResult：" + createResult);
        }

        byte[] b = zk.getData(node, false, stat);
        System.out.println("b：" + new String(b));
        zk.close();
    }
}
