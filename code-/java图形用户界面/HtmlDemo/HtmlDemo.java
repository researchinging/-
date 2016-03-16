import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HtmlDemo extends JPanel {
    JLabel theLabel;
    JTextArea htmlTextArea;
    public HtmlDemo() {
        String initialText = "<html>\n" +
                "颜色和字体测试：\n" +
                "<ul>\n" +
                "<li><font color=red>红色</font>\n" +
                "<li><font color=blue>蓝色</font>\n" +
                "<li><font color=green>绿色</font>\n" +
                "<li><font size=-2>小</font>\n" +
                "<li><font size=+2>大</font>\n" +
                "<li><i>斜体</i>\n" +
                "<li><b>粗体</b>\n" +
                "</ul>\n";
        htmlTextArea = new JTextArea(10, 20);
        htmlTextArea.setText(initialText);
        JScrollPane scrollPane = new JScrollPane(htmlTextArea);
        JButton changeTheLabel = new JButton("改变标签显示内容");
        changeTheLabel.setMnemonic(KeyEvent.VK_C);
        changeTheLabel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    theLabel.setText(htmlTextArea.getText());
                } catch (Throwable exc) {
                    JOptionPane.showMessageDialog(
                            HtmlDemo.this,
                            "您指定的HTML无效.");
                }
            }
        });
        changeTheLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        theLabel = new JLabel(initialText) {
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }
            public Dimension getMinimumSize() {
                return new Dimension(200, 200);
            }
            public Dimension getMaximumSize() {
                return new Dimension(200, 200);
            }
        };
        theLabel.setVerticalAlignment(SwingConstants.CENTER);
        theLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                    "首先编辑HTML，然后单击按钮"),
                BorderFactory.createEmptyBorder(10,10,10,10)));
        leftPanel.add(scrollPane);
        leftPanel.add(Box.createRigidArea(new Dimension(0,10)));
        leftPanel.add(changeTheLabel);
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("使用HTML标记的标签"),
                        BorderFactory.createEmptyBorder(10,10,10,10)));
        rightPanel.add(theLabel);

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(leftPanel);
        add(Box.createRigidArea(new Dimension(10,0)));
        add(rightPanel);
    }

    public static void main(String args[]) {
        JFrame f = new JFrame("HtmlDemo");

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.getContentPane().add(new HtmlDemo());
        f.pack();
        f.setVisible(true);
    }
}
