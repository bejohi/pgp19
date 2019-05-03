import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;

enum LogLevel {
    Trace,
    Debug,
    Info,
    Warn,
    Error;
}

public interface Logger {
    default void trace(String format, Object... args) {
        this.log(LogLevel.Trace, format, args);
    }
    default void debug(String format, Object... args) {
        this.log(LogLevel.Debug, format, args);
    }
    default void info(String format, Object... args) {
        this.log(LogLevel.Info, format, args);
    }
    default void warn(String format, Object... args) {
        this.log(LogLevel.Warn, format, args);
    }
    default void error(String format, Object... args) {
        this.log(LogLevel.Error, format, args);
    }
    void setLogLevel(LogLevel level);
    void log(LogLevel level, String format, Object... args);
}

class ConsoleLogger implements Logger{

    private Logger feature;

    public ConsoleLogger(Logger feature){
        this.feature = feature;
    }
    public ConsoleLogger(){
    }

    private LogLevel logLevel;
    @Override
    public void setLogLevel(LogLevel level) {
        this.logLevel = level;
        if(this.feature != null){
            this.feature.setLogLevel(this.logLevel);
        }
    }

    @Override
    public void log(LogLevel level, String format, Object... args) {
        System.out.println(String.format(format,args));
        if(this.feature != null){
            this.feature.log(level,format,args);
        }
    }
}

class TimestampedLogger implements Logger{

    private Logger feature;

    public TimestampedLogger(Logger feature){
        this.feature = feature;
    }
    public TimestampedLogger(){
    }

    private LogLevel logLevel;
    @Override
    public void setLogLevel(LogLevel level) {
        this.logLevel = level;
        if(this.feature != null){
            this.feature.setLogLevel(this.logLevel);
        }
    }

    @Override
    public void log(LogLevel level, String format, Object... args) {
        String dateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
        String resultString = dateTime + " "+ format;
        if(this.feature != null){
            this.feature.log(level,resultString,args);
        }
    }
}

class FileLogger implements Logger{

    private LogLevel logLevel;
    private String filePath;
    private Logger feature;

    public FileLogger(Logger feature){
        this.feature = feature;

    }
    public FileLogger(String filePath, Logger feature){
        this.feature = feature;
        this.filePath = filePath;
    }
    @Override
    public void setLogLevel(LogLevel level) {
        this.logLevel = level;
        if(this.feature != null){
            this.feature.setLogLevel(this.logLevel);
        }
    }

    @Override
    public void log(LogLevel level, String format, Object... args) {
        try(FileWriter writer = new FileWriter(this.filePath)){
            writer.append(String.format(format,args));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(this.feature != null){
            this.feature.log(level,format,args);
        }
    }
}

class LeveledLogger implements Logger{

    private LogLevel logLevel;
    private Logger feature;

    public LeveledLogger(LogLevel level, Logger feature){
        this.feature = feature;
        this.setLogLevel(level);
    }
    @Override
    public void setLogLevel(LogLevel level) {
        this.logLevel = level;
        if(this.feature != null){
            this.feature.setLogLevel(this.logLevel);
        }
    }

    @Override
    public void log(LogLevel level, String format, Object... args) {
        if(level.compareTo(this.logLevel) >= 0){
            this.feature.log(level,format,args);
        }
    }
}

class Tests{
    public static void main(String... args){
        Logger sysoLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger("test.log",sysoLogger);
        fileLogger.log(LogLevel.Error,"An error occurred");
        Logger timeLogger = new TimestampedLogger(fileLogger);
        timeLogger.log(LogLevel.Debug,"Just an info");
        Logger leveledLogger = new LeveledLogger(LogLevel.Info,timeLogger);
        leveledLogger.log(LogLevel.Debug,"Should not appear on screen");
    }
}
