package Thread;

public class Race implements Runnable{
    private String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(gameOver(i)) break;
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"米");
        }
    }

    private boolean gameOver(int meters){
        if(winner != null) return true;
        else{
            if(meters >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is "+winner);
                return true;
            }

        }
        return false;
    }
}
