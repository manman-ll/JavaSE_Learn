package Thread;


//创建线程方式2:实现runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
public class TestThread3 implements Runnable{
    @Override
    public void run() {
        for(int i = 0;i < 100;i++){
            System.out.println("I'm learning thread ---"+i);
        }
    }
}
