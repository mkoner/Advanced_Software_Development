package lab;

public class Main {
    public static void main(String[] args) {
        org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(Main.class);
        LoggerAdapter loggerAdapter = new LoggerAdapter(logger);
        loggerAdapter.log(LogLevel.DEBUG, "Log debug");
        loggerAdapter.log(LogLevel.TRACE, "Log trace");
        loggerAdapter.log(LogLevel.INFO, "Log info");
        loggerAdapter.log(LogLevel.FATAL, "Log fatal");
        loggerAdapter.log(LogLevel.ERROR, "Log error");
        loggerAdapter.log(LogLevel.WARNING, "Log warning");

        System.out.println("Hello world!");
    }
}