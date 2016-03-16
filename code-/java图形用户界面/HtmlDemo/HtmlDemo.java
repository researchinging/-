import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HtmlDemo extends JPanel {
    JLabel theLabel;
    JTextArea htmlTextArea;
    public HtmlDemo() {
        String initialText = "<html>\n" +
                "��ɫ��������ԣ�\n" +
                "<ul>\n" +
                "<li><font color=red>��ɫ</font>\n" +
                "<li><font color=blue>��ɫ</font>\n" +
                "<li><font color=green>��ɫ</font>\n" +
                "<li><font size=-2>С</font>\n" +
                "<li><font size=+2>��</font>\n" +
                "<li><i>б��</i>\n" +
                "<li><b>����</b>\n" +
                "</ul>\n";
        htmlTextArea = new JTextArea(10, 20);
        htmlTextArea.setText(initialText);
        JScrollPane scrollPane = new JScrollPane(htmlTextArea);
        JButton changeTheLabel = new JButton("�ı��ǩ��ʾ����");
        changeTheLabel.setMnemonic(KeyEvent.VK_C);
        changeTheLabel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    theLabel.setText(htmlTextArea.getText());
                } catch (Throwable exc) {
                    JOptionPane.showMessageDialog(
                            HtmlDemo.this,
                            "��ָ����HTML��Ч.");
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
                    "���ȱ༭HTML��Ȼ�󵥻���ť"),
                BorderFactory.createEmptyBorder(10,10,10,10)));
        leftPanel.add(scrollPane);
        leftPanel.add(Box.createRigidArea(new Dimension(0,10)));
        leftPanel.add(changeTheLabel);
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("ʹ��HTML��ǵı�ǩ"),
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
