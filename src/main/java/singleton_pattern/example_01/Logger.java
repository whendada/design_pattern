package singleton_pattern.example_01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 实战案例一：处理资源访问冲突
 *
 * 存在的问题是两个 Controller 同时调用 Logger 类时，因为写入的都是同一个文件，所以会造成后面写的内容把前面的内容给覆盖掉
 * 因为此时每个线程保存的是自己的信息，并不知道其他线程的情况，所以很可能出现覆盖的情况
 *
 * 参考极客时间 《设计模式》 专栏单例模式一讲
 */

public class Logger {
        private FileWriter writer;

        public Logger() {
            File file = new File("/Users/whendada/log.txt");
            try {
                writer = new FileWriter(file, true); //true表示追加写入
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void log(String message) {
            try {
                writer.write(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class UserController {
        private Logger logger = new Logger();

        public void login(String userName, String passWord) {
            logger.log(userName + " " + passWord);
        }
    }

    class OrderController {
        private Logger logger = new Logger();

        public void createOrder(String orderId) {
            logger.log(orderId);
        }
    }

    /**
     * 如何解决呢，加锁，在log方法上加上synchronized
     * public void log(String message) {
     *         synchronized (this) {
     *             try {
     *                 writer.write(message);
     *             } catch (IOException e) {
     *                 e.printStackTrace();
     *             }
     *         }
     *     }
     *
     * 但这里有问题，synchronized 锁住的是实例，而不是类，应该加类级别的锁，如下
     * public void log(String message) {
     *         synchronized (Logger.class) {
     *             try {
     *                 writer.write(message);
     *             } catch (IOException e) {
     *                 e.printStackTrace();
     *             }
     *         }
     *     }
     *
     * 最后，对于这种情况，除了加类锁、分布式锁和由并发队列（多个线程写入队列，一个线程把内容写入到文件）来实现之外，
     * 还可以用单例模式来实现
     *
     * 单例模式
     *
     * public class Logger {
     *         private FileWriter writer;
     *         private static final Logger instance = new Logger();
     *
     *         public static Logger getInstance() {
     *             return instance;
     *         }
     *
     *         public Logger() {
     *             File file = new File("/Users/whendada/log.txt");
     *             try {
     *                 writer = new FileWriter(file, true); //true表示追加写入
     *             } catch (Exception e) {
     *                 e.printStackTrace();
     *             }
     *         }
     *
     *         public void log(String message) {
     *             try {
     *                 writer.write(message);
     *             } catch (IOException e) {
     *                 e.printStackTrace();
     *             }
     *         }
     *     }
     */
