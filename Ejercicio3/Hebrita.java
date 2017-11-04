import java.lang.Thread;

class Hebrita extends Thread implements Runnable {
    private ProcesadorYodafy yodita;

    public Hebrita(ProcesadorYodafy yoda) {
        yodita = yoda;
    }

    public void run() {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            return;
        }

        yodita.procesa();  
    }
}