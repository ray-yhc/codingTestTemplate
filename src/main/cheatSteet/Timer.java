package cheatSteet;

public class Timer {
    private long startTime;
    private long finishTime;

    public void start() {
        startTime = System.nanoTime();
        finishTime = 0;
    }

    public long end() {
        finishTime = System.nanoTime();
        long elapsedTime = finishTime - startTime;
        return (elapsedTime >= 0) ? elapsedTime : -1;
    }

    public long getElapsedTime () {
        long elapsedTime = finishTime - startTime;
        return (elapsedTime >= 0) ? elapsedTime : -1;
    }
}
