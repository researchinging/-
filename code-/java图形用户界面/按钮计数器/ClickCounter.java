import javax.swing.*;//����Swing��         
import java.awt.*;
import java.awt.event.*;

public class ClickCounter {
    private static String labelPrefix = "������ť������ ";
    private int numClicks = 0;
    public Component createComponents() {
    	//������ǩ
        final JLabel label = new JLabel(labelPrefix + "0    ");
	//������ť
        JButton button = new JButton("������굥����");
        button.setMnemonic(KeyEvent.VK_I);
        button.addActionListener(new ActionListener() {//����ť�¼�
            public void actionPerformed(ActionEvent e) {
                numClicks++;
                label.setText(labelPrefix + numClicks);
            }
        });
        label.setLabelFor(button);//֧����Ϣ��������
        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createEmptyBorder(
                                        30, //�ϱ�
                                        30, //���
                                        10, //�±�
                                        30) //�ұ�
                                        );
        pane.setLayout(new GridLayout(0, 1));
        pane.add(button);//����������Ӱ�ť
        pane.add(label);//����������ӱ�ǩ
        return pane;
    }
    //main()����
    public static void main(String[] args) {
        try {//ѡ�������
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) { }
        //������������
        JFrame frame = new JFrame("ClickCounter");
        ClickCounter app = new ClickCounter();
        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
        //���frame�ĳ�ʼ�����������ҽ�����ʾ����
        frame.addWindowListener(new WindowAdapter() {//�������¼�
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}
