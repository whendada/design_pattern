package singleton_pattern.example_02;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 实战案例二：表示全局唯一类

 * 从业务概念上，如果有些数据在系统中只应保存一份，那就比较适合设计为单例类。
 * 比如，配置信息类。在系统中，我们只有一个配置文件，当配置文件被加载到内存之后，以对象的形式存在，也理所应当只有一份。
 */
public class IdGenerator {
    // AtomicLong是一个Java并发库中提供的一个原子变量类型,
    // 它将一些线程不安全需要加锁的复合操作封装为了线程安全的原子操作，
    // 比如下面会用到的incrementAndGet().
    private AtomicLong id = new AtomicLong(0);
    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}

    /**
     * 如何实现一个单例
     *
     * 1、恶汉式，如上
     * 不支持延迟加载，在类加载的时候，instance 静态实例就已经创建并初始化好了
     * 所以，instance 实例的创建过程是线程安全的
     *
     *
     * 2、懒汉式
     * 与恶汉时的区别就是使用时才初始化，而不是在类加载时就初始化
     *
     * public class IdGenerator {
     *         private AtomicLong id = new AtomicLong(0);
     *         private static IdGenerator instance;
     *         private IdGenerator{}
     *
     *         public synchronized static IdGenerator getInstance() {
     *             if (Objects.isNull(instance)) {
     *                 instance = new IdGenerator();
     *             }
     *             return instance;
     *         }
     *
     *         public long getId() {
     *             return id.incrementAndGet();
     *         }
     *     }
     *
     *
     * 3、双重检测
     * 饿汉式不支持延迟加载，懒汉式有性能问题，不支持高并发
     * 双重检测既支持延迟加载、又支持高并发的单例实现方式
     *
     * 在这种实现方式中，只要 instance 被创建之后，即便再调用 getInstance() 函数也不会再进入到加锁逻辑中，
     * 就是第一次为空的时候，都会加锁，但在 instance 被初始化之后，不会像懒汉式那样全得加类锁之后才进行判断。
     *
     * 而第二次判空的逻辑，如果这里不进行判空，第一个线程进入第一次判空，第二个在进入，第一个获取类锁，执行完
     * 之后，第二个此时
     *
     * public class IdGenerator {
     *         private AtomicLong id = new AtomicLong(0);
     *         private static IdGenerator instance;
     *         private IdGenerator() {
     *         }
     *
     *         public static IdGenerator getInstance() {
     *             if (Objects.isNull(instance)) {
     *                 // 类级别锁
     *                 synchronized(IdGenerator.class) {
     *                     // 第二次判空的逻辑，如果这里不进行判空，第一个线程进入第一次判空，第二个再进入，第一个获取类锁，执行完
     *                     // 之后，第二个此时再获取类锁又初始化了，如果在这之间恰好有对象调用 getId 方法，就会造成重复id
     *                     if (Objects.isNull(instance)) {
     *                         instance = new IdGenerator();
     *                     }
     *                 }
     *             }
     *             return instance;
     *         }
     *
     *         public long getId() {
     *             return id.incrementAndGet();
     *         }
     *     }
     *
     *
     * 4、静态内部类
     * SingletonHolder 是一个静态内部类，当外部类 IdGenerator 被加载的时候，并不会创建 SingletonHolder 实例对象。
     * 只有当调用 getInstance() 方法时，SingletonHolder 才会被加载，这个时候才会创建 instance。
     *
     * public class IdGenerator {
     *         private AtomicLong id = new AtomicLong(0);
     *         private IdGenerator() {}
     *         private static class SingletonHolder{
     *             private static final IdGenerator instance = new IdGenerator();
     *         }
     *         public static IdGenerator getInstance() {
     *             return SingletonHolder.instance;
     *         }
     *         public long getId() {
     *             return id.incrementAndGet();
     *         }
     *     }
     *
     *
     * 5、 枚举
     *
     * public enum IdGenerator {
     *         INSTANCE;
     *         private AtomicLong id = new AtomicLong(0);
     *         public long getId() { return id.incrementAndGet();
     *         }
     *     }
     */

