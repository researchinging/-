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
     * ��ȡworker�̲߳�����ֵ,���û�б����죬��ô����null 
     */
    protected synchronized Object getValue() { 
        return value; 
    }
    /** 
     * ������worker�̲߳���ֵ 
     */
    private synchronized void setValue(Object x) { 
        value = x; 
    }
    /** 
     * ���㽫Ҫ��<code>get</code>�������ص�ֵ 
     */
    public abstract Object construct();
    /**
     * ��<code>construct</code>�������غ󣬵����¼��߳�
     */
    public void finished() {
    }
    /**
     * һ������worker�̵߳ķ���.���ø÷�������ʹworker�߳�ֹͣ����
     */
    public void interrupt() {
        Thread t = threadVar.get();
        if (t != null) {
            t.interrupt();
        }
        threadVar.clear();
    }
    /**
     * ������<code>construct</code>����������ֵ������ڸ�ֵ����֮ǰ
     * �����̻߳��ߵ�ǰ���̶߳�û�б����ţ���ô����null
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
     * �����߳̽�����<code>construct</code>������Ȼ���˳�
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
     * ����worker�߳�
     */
    public void start() {
        Thread t = threadVar.get();
        if (t != null) {
            t.start();
        }
    }
}
