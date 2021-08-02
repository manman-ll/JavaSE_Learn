package Thread;

public class TestThread4 implements Runnable{
    private int ticketNums = 10;
    @Override
    public void run() {
        while (true){
            if(ticketNums<=0) break;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNums--+"张票");
        }
    }
}
