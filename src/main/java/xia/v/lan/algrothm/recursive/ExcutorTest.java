package xia.v.lan.algrothm.recursive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author chenhao
 * @description <p>
 * created by chenhao 2020/7/22 20:38
 */
public class ExcutorTest {

    public static void main(String[] args) throws IOException {
        testScheduled();
    }

    public static void test3(){
        String str = "122.01240333333334";
        float f = Float.valueOf(str);
        double d = Double.valueOf(str);
        System.out.println(f);
        System.out.println(d);
        float other = (float)d;
        System.out.println(other);
    }

    public static void test1(){

        ExecutorService fix = Executors.newFixedThreadPool(5);

        while(true){
            fix.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void test2(){
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                5,5,10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        while (true){
            threadPool.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());//执行 方法
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void testJson() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("D:/tmp/road_pic_selection_20200723"));
        String json = new String(bytes);
        System.out.println(json);
    }

    public static void tableTest(){
        
    }

    public static void testScheduled(){
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor =
                new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            System.out.println(new Random().nextDouble());
        },0,2,TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName());
        },0,1,TimeUnit.SECONDS);
    }


}
