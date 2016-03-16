import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class TumbleItem extends JApplet
                        implements ActionListener {
    int loopslot = -1;  //当前帧数
    String dir;         //载入图片的相对路径 
    Timer timer;        //产生动画的timer
    int pause;          //暂停时间
    int offset;         
    int off;            
    int speed;          //动画速度
    int nimgs;          //产生动画的图片数目
    int width;          //applet的宽度
    JComponent contentPane; //applet的content pane
    ImageIcon imgs[];   //存放图片的数组
    int maxWidth;       //最宽图片的宽度
    boolean finishedLoading = false;
    JLabel statusLabel;
    static Color[] labelColor = { Color.black, Color.black,
                                  Color.black, Color.black,
                                  Color.black, Color.white,
                                  Color.white, Color.white,
                                  Color.white, Color.white };
    public void init() {
        //获取小应用程序的各个参数
        String at = getParameter("img");
        dir = (at != null) ? at : "images/tumble";
        at = getParameter("pause");
        pause = (at != null) ? Integer.valueOf(at).intValue() : 1900;
        at = getParameter("offset");
        offset = (at != null) ? Integer.valueOf(at).intValue() : 0;
        at = getParameter("speed");
        speed = (at != null) ? (1000 / Integer.valueOf(at).intValue()) : 100;
        at = getParameter("nimgs");
        nimgs = (at != null) ? Integer.valueOf(at).intValue() : 16;
        at = getParameter("maxwidth");
        maxWidth = (at != null) ? Integer.valueOf(at).intValue() : 0;
        //如果offset为负数，则从右向左产生动画
        width = getSize().width;
        if (offset < 0) {
            off = width - maxWidth;
        }
        //自定义组件使之在特定的坐标处画当前的图片
        contentPane = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (finishedLoading &&
                    (loopslot > -1) && (loopslot < nimgs)) {
                    imgs[loopslot].paintIcon(this, g, off, 0);
                } 
            }
        };
        contentPane.setBackground(Color.white);
        setContentPane(contentPane);
        //在content pane的正中央放置一个"正在载入图片..."标签
        //为了使该标签的文字显示在applet的中央，将它放置
        //在BorderLayout控制的容器中，并且将该组件的
        //对齐方式设置为center-align方式
        statusLabel = new JLabel("正在载入图片...",
                                 JLabel.CENTER);
        statusLabel.setForeground(labelColor[0]);
        contentPane.setLayout(new BorderLayout());
        contentPane.add(statusLabel, BorderLayout.CENTER);
        //设置产生动画的timer，并且等所有的图片上载后才启动该timer
        timer = new Timer(speed, this);
        timer.setInitialDelay(pause);
        timer.setCoalesce(false);
        //载入图片需要一段时间 
        //在SwingWorker线程中载入图片
        imgs = new ImageIcon[nimgs];
        timer.start(); //开始动画.
        final SwingWorker worker = new SwingWorker() {
            public Object construct() {
                URL baseURL = getCodeBase();
                String prefix = dir + "/T";
                for (int i = 0; i < nimgs; i++) {
                    imgs[i] = new ImageIcon(getURL(baseURL,
                                     prefix + (i+1) + ".gif"));
                }
                finishedLoading = true;
                return imgs;
            }
            public void finished() {
                //去掉"正在载入图片"标签
                contentPane.removeAll();
                contentPane.repaint();
                loopslot = -1;
            }
        };
        worker.start();
    }
    //更新循环状态参数和起始坐标，如果显示的是最后一帧，
    //重新设置timer，暂停循环
    public void actionPerformed(ActionEvent e) {
        loopslot++;
        if (!finishedLoading) {
            int colorIndex = loopslot % labelColor.length;
            try {
                statusLabel.setForeground(labelColor[colorIndex]);
            } catch (NullPointerException exc) {}
            return;
        }
        if (loopslot >= nimgs) {
            loopslot = 0;
            off += offset;
            if (off < 0) {
                off = width - maxWidth;
            } else if (off + maxWidth > width) {
                off = 0;
            }
        }
        contentPane.repaint();
        if (loopslot == nimgs - 1) {
            timer.restart();
        }
    }
    public void start() {
        if (finishedLoading && (nimgs > 1)) {
            timer.restart();
        }
    }
    public void stop() {
        timer.stop();
    }
    protected URL getURL(URL codeBase, String filename) {
        URL url = null;
        try {
            url = new URL(codeBase, filename);
        } catch (java.net.MalformedURLException e) {
            System.out.println("Couldn't create image: badly specified URL");
            return null;
        }
        return url;
    }  
    public String[][] getParameterInfo() {
        String[][] info = {
          {"img", "string", "the directory containing the images to loop"},
          {"pause", "int", "pause between complete loops; default is 3900"},
          {"offset", "int", "offset of each image to simulate left (-) or "
                            + "right (+) motion; default is 0 (no motion)"},
          {"speed", "int", "the speed at which the frames are looped; "
                           + "default is 100"},
          {"nimgs", "int", "the number of images to be looped; default is 16"},
          {"maxwidth", "int", "the maximum width of any image in the loop; "
                              + "default is 0"}
        };
        return info;
    }
}
