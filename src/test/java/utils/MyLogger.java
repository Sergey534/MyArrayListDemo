package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * MyLogger is a simple logging utility class that provides methods for logging messages at INFO level.
 */
public class MyLogger {

  /**
   * Logger instance for logging messages.
   */
  private static final Logger logger = LogManager.getLogger("Logger");

  /**
   * Logs an informational message.
   *
   * @param message the message to log
   */
  public static void info(String message) {
    logger.info(message);
  }

}