import javax.swing.*;//引入Swing包         
import java.awt.*;
import java.awt.event.*;

public class ClickCounter {
    private static String labelPrefix = "单击按钮次数： ";
    private int numClicks = 0;
    public Component createComponents() {
    	//创建标签
        final JLabel label = new JLabel(labelPrefix + "0    ");
	//创建按钮
        JButton button = new JButton("请用鼠标单击！");
        button.setMnemonic(KeyEvent.VK_I);
        button.addActionListener(new ActionListener() {//处理按钮事件
            public void actionPerformed(ActionEvent e) {
                numClicks++;
                label.setText(labelPrefix + numClicks);
            }
        });
        label.setLabelFor(button);//支持信息交互技术
        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createEmptyBorder(
                                        30, //上边
                                        30, //左边
                                        10, //下边
                                        30) //右边
                                        );
        pane.setLayout(new GridLayout(0, 1));
        pane.add(button);//向容器中添加按钮
        pane.add(label);//向容器中添加标签
        return pane;
    }
    //main()方法
    public static void main(String[] args) {
        try {//选择界面风格
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) { }
        //创建最顶层的容器
        JFrame frame = new JFrame("ClickCounter");
        ClickCounter app = new ClickCounter();
        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
        //完成frame的初始化工作，并且将其显示出来
        frame.addWindowListener(new WindowAdapter() {//处理窗口事件
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}
