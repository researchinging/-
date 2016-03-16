import javax.swing.SwingUtilities;

public abstract class SwingWorker {
    private Object value;  
    private Thread thread;
    private static class ThreadVar {
        private Thread thread;
        ThreadVar(Thread t) { thread = t; }
        synchronized Thread get() { return thread; }
        synchronized void clear() { thread = null; }
    }
    private ThreadVar threadVar;
    /** 
     * 获取worker线程产生的值,如果没有被构造，那么返回null 
     */
    protected synchronized Object getValue() { 
        return value; 
    }
    /** 
     * 设置由worker线程产生值 
     */
    private synchronized void setValue(Object x) { 
        value = x; 
    }
    /** 
     * 计算将要被<code>get</code>方法返回的值 
     */
    public abstract Object construct();
    /**
     * 当<code>construct</code>方法返回后，调用事件线程
     */
    public void finished() {
    }
    /**
     * 一个打扰worker线程的方法.调用该方法可以使worker线程停止工作
     */
    public void interrupt() {
        Thread t = threadVar.get();
        if (t != null) {
            t.interrupt();
        }
        threadVar.clear();
    }
    /**
     * 返回由<code>construct</code>方法创建的值，如果在该值产生之前
     * 构造线程或者当前的线程都没有被打扰，那么返回null
     */
    public Object get() {
        while (true) {  
            Thread t = threadVar.get();
            if (t == null) {
                return getValue();
            }
            try {
                t.join();
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                return null;
            }
        }
    }
    /**
     * 启动线程将调用<code>construct</code>方法，然后退出
     */
    public SwingWorker() {
        final Runnable doFinished = new Runnable() {
           public void run() { finished(); }
        };
        Runnable doConstruct = new Runnable() { 
            public void run() {
                try {
                    setValue(construct());
                }
                finally {
                    threadVar.clear();
                }
                SwingUtilities.invokeLater(doFinished);
            }
        };
        Thread t = new Thread(doConstruct);
        threadVar = new ThreadVar(t);
    }
    /**
     * 开启worker线程
     */
    public void start() {
        Thread t = threadVar.get();
        if (t != null) {
            t.start();
        }
    }
}
