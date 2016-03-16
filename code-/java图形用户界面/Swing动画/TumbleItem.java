import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class TumbleItem extends JApplet
                        implements ActionListener {
    int loopslot = -1;  //��ǰ֡��
    String dir;         //����ͼƬ�����·�� 
    Timer timer;        //����������timer
    int pause;          //��ͣʱ��
    int offset;         
    int off;            
    int speed;          //�����ٶ�
    int nimgs;          //����������ͼƬ��Ŀ
    int width;          //applet�Ŀ��
    JComponent contentPane; //applet��content pane
    ImageIcon imgs[];   //���ͼƬ������
    int maxWidth;       //���ͼƬ�Ŀ��
    boolean finishedLoading = false;
    JLabel statusLabel;
    static Color[] labelColor = { Color.black, Color.black,
                                  Color.black, Color.black,
                                  Color.black, Color.white,
                                  Color.white, Color.white,
                                  Color.white, Color.white };
    public void init() {
        //��ȡСӦ�ó���ĸ�������
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
        //���offsetΪ����������������������
        width = getSize().width;
        if (offset < 0) {
            off = width - maxWidth;
        }
        //�Զ������ʹ֮���ض������괦����ǰ��ͼƬ
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
        //��content pane�����������һ��"��������ͼƬ..."��ǩ
        //Ϊ��ʹ�ñ�ǩ��������ʾ��applet�����룬��������
        //��BorderLayout���Ƶ������У����ҽ��������
        //���뷽ʽ����Ϊcenter-align��ʽ
        statusLabel = new JLabel("��������ͼƬ...",
                                 JLabel.CENTER);
        statusLabel.setForeground(labelColor[0]);
        contentPane.setLayout(new BorderLayout());
        contentPane.add(statusLabel, BorderLayout.CENTER);
        //���ò���������timer�����ҵ����е�ͼƬ���غ��������timer
        timer = new Timer(speed, this);
        timer.setInitialDelay(pause);
        timer.setCoalesce(false);
        //����ͼƬ��Ҫһ��ʱ�� 
        //��SwingWorker�߳�������ͼƬ
        imgs = new ImageIcon[nimgs];
        timer.start(); //��ʼ����.
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
                //ȥ��"��������ͼƬ"��ǩ
                contentPane.removeAll();
                contentPane.repaint();
                loopslot = -1;
            }
        };
        worker.start();
    }
    //����ѭ��״̬��������ʼ���꣬�����ʾ�������һ֡��
    //��������timer����ͣѭ��
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
