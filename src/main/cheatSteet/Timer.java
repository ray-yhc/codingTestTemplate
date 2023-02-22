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

    public String getTimeAsString() {
        long elapsedTime = finishTime - startTime;
        if (elapsedTime < 0) return "null";

        return String.format("실행시간 : %.6fs", (double) elapsedTime / 1_000_000_000.0 );
    }

    public long getElapsedTime () {
        long elapsedTime = finishTime - startTime;
        return (elapsedTime >= 0) ? elapsedTime : -1;
    }
}
