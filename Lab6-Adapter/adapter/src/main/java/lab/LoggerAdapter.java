package lab;

public class LoggerAdapter implements Logger{
    org.apache.logging.log4j.Logger logger;
    public LoggerAdapter(org.apache.logging.log4j.Logger logger) {
        this.logger = logger;
    }
    @Override
    public void log(LogLevel logLevel, String message) {
        if (logLevel == LogLevel.DEBUG) {
            logger.debug(message);
        }
        else if (logLevel == LogLevel.INFO) {
            logger.info(message);
        }
        else if (logLevel == LogLevel.ERROR) {
            logger.error(message);
        }
        else if (logLevel == LogLevel.FATAL) {
            logger.fatal(message);
        }
        else if (logLevel == LogLevel.TRACE) {
            logger.trace(message);
        }
        else{
            logger.warn(message);
        }
    }
}
