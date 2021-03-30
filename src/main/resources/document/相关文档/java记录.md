### 查找windows下java安装路径

java -verbose

### transient

java有个特bai点就是du序列化，简单地来说就是可以将这个类存储在物理空间（当然还zhi是以文件的形式存在），那么当你dao从本地还原这个文件时，你可以将它转换为它本身。这可以极大地方便网络上的一些操作，但同时，因为涉及到安全问题，所以并不希望把类里面所有的东西都能存储（因为那样，别人可以通过序列化知道类里面的内容），那么我们就可以用上transient这个关键字，它的意思是临时的，即不会随类一起序列化到本地，所以当还原后，这个关键字定义的变量也就不再存在。



### 线程相关的文章 

https://www.cnblogs.com/lixin-link/p/10998058.html

https://blog.csdn.net/lsr40/article/details/106770113

### wait/notify/notifyAll

#### wait

* wait()方法的作用是将当前运行的线程挂起（即让其进入阻塞状态），直到notify或notifyAll方法来唤醒线程
* wait(long timeout)，该方法与wait()方法类似，唯一的区别就是在指定时间内，如果没有notify或notifAll方法的唤醒，也会自动唤醒。
* 至于wait(long timeout,long nanos)，本意在于更精确的控制调度时间，不过从目前版本来看，该方法貌似没有完整的实现该功能

注意：wait方法的使用必须在同步的范围内，否则就会抛出IllegalMonitorStateException异常，wait方法的作用就是阻塞当前线程等待notify/notifyAll方法的唤醒，或等待超时后自动唤醒。 

```java
/**
     * @return void
     * @author zhengyang.chen
     * @date 2020/11/9 16:34
     */
    public synchronized void getMes() {
        System.out.println(Thread.currentThread().getName()+"Start-----");
        try {
            wait(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"End-------");
    }

    public static void main(String[] args) throws InterruptedException {

        Test test = new Test();

        for (int i = 1; i < 6; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.getMes();
                }
            }).start();
        }

        synchronized (test){
            test.notify();
        }
        Thread.sleep(10000);
        synchronized (test){
            test.notifyAll();
        }
    }
```

#### 总结

* 调用wait方法后，线程是会释放对monitor对象的所有权的。

* 一个通过wait方法阻塞的线程，必须同时满足以下两个条件才能被真正执行：

  * 线程需要被唤醒（超时唤醒或调用notify/notifyll）
  * 线程唤醒后需要竞争到锁（monitor）

  

### sleep/yield/join

#### sleep

sleep方法的作用是让当前线程暂停指定的时间（毫秒）



#### yield

yield方法的作用是暂停当前线程，以便其他线程有机会执行，不能指定暂停的时间，也不能保证当前线程马上停止。yield方法只是将Running转变为Runnable状态。

```java
    public static void main(String[] args) throws InterruptedException {

        Test test = new Test();
        new Thread(test,"Thread0").start();
        new Thread(test,"Thread1").start();

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Start-----");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "Start-----"+i);
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "End-------");
    }
```

注意：

1. 调度器可能会忽略该方法。
2. 使用的时候要仔细分析和测试，确保能达到预期的效果。
3. 很少有场景要用到该方法，主要使用的地方是调试和测试。

#### join

join方法的作用是父线程等待子线程执行完成后再执行，换句话说就是将异步执行的线程合并为同步的线程。JDK中提供三个版本的join方法，其实现与wait方法类似，join()方法实际上执行的join(0)，而join(long millis, int nanos)也与wait(long millis, int nanos)的实现方式一致，暂时对纳秒的支持也是不完整的。

```java
public static void main(String[] args) throws InterruptedException {
    Test test = new Test();
    for (int i = 0; i < 5; i++) {
        Thread thread = new Thread(test, "Thread" + i);
        thread.start();
        thread.join();
    }

}

@Override
public void run() {
    System.out.println(Thread.currentThread().getName() + "-----Start-----");
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    for (int i = 0; i < 5; i++) {
        System.out.println(Thread.currentThread().getName() + "Start-----"+i);
        Thread.yield();
    }
    System.out.println(Thread.currentThread().getName() + "End-------");
}
```

### sleep和wait方法的区别

1. wait方法依赖于同步，而sleep方法可以直接调用
2. sleep方法只是暂时让出CPU的执行权，并不释放锁。而wait方法则需要释放锁。



## DelayQueue详解[相关地址](https://www.cnblogs.com/myseries/p/10944211.html)



### 一、DelayQueue是什么

　　DelayQueue是一个无界的BlockingQueue，用于放置实现了Delayed接口的对象，其中的对象只能在其到期时才能从队列中取走。这种队列是有序的，即队头对象的延迟到期时间最长。注意：不能将null元素放置到这种队列中。

### 二、DelayQueue能做什么

　1. 淘宝订单业务:下单之后如果三十分钟之内没有付款就自动取消订单。 
　2. 饿了吗订餐通知:下单成功后60s之后给用户发送短信通知。

　3. 关闭空闲连接。服务器中，有很多客户端的连接，空闲一段时间之后需要关闭之。

　4. 缓存。缓存中的对象，超过了空闲时间，需要从缓存中移出。

　5. 任务超时处理。在网络协议滑动窗口请求应答式交互时，处理超时未响应的请求等。



