package Thread;

public class TestThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0;i < 200;i++){
            System.out.println("这里是分线程----"+i);
        }
    }
}
