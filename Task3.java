public class BankStatementBatchProcessor {
    private AtomicInteger processedCount = new AtomicInteger(0); // FIX: AtomicInteger for thread safety

    public void process(List<StatementRecord> records) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (StatementRecord record : records) {
            executor.submit(() -> {
                processRecord(record);
                processedCount.incrementAndGet(); // FIX: Atomic increment
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);
    }

    public int getProcessedCount() {
        return processedCount.get(); // FIX: return atomic value
    }
}