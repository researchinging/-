import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VoteDialog extends JPanel {
    JLabel label;
    JFrame frame;
    String simpleDialogDesc = "��ѡ��";
    //���캯��
    public VoteDialog(JFrame frame) {
        this.frame = frame;
        JLabel title;
        // �������
        JPanel choicePanel = createSimpleDialogBox();    
        System.out.println("passed createSimpleDialogBox");
        title = new JLabel("��������ѡ��һ����ѡ�ˣ�Ȼ��"
                           + "����\"ͶƱ\" ��ť",
                           JLabel.CENTER);
        label = new JLabel("����ͶƱ��", JLabel.CENTER);
	label.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        choicePanel.setBorder(BorderFactory.createEmptyBorder(20,20,5,20));
        // ���ò���
        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);  
        add(label, BorderLayout.SOUTH);        
        add(choicePanel, BorderLayout.CENTER);
    }
    void setLabel(String newText) {
        label.setText(newText);
    }
    private JPanel createSimpleDialogBox() {
        final int numButtons = 4;
        JRadioButton[] radioButtons = new JRadioButton[numButtons];
        final ButtonGroup group = new ButtonGroup();
        JButton voteButton = null;
        final String defaultMessageCommand = "default";
        final String yesNoCommand = "yesno";
        final String yeahNahCommand = "yeahnah";
        final String yncCommand = "ync";
        radioButtons[0] = new JRadioButton("<html>1�ź�ѡ�ˣ�<font color=red>С��</font></html>");
        radioButtons[0].setActionCommand(defaultMessageCommand);
        radioButtons[1] = new JRadioButton("<html>2�ź�ѡ�ˣ�<font color=green>С��</font></html>");
        radioButtons[1].setActionCommand(yesNoCommand);
        radioButtons[2] = new JRadioButton("<html>3�ź�ѡ�ˣ�<font color=blue>С��</font></html>");
        radioButtons[2].setActionCommand(yeahNahCommand);
        radioButtons[3] = new JRadioButton("<html>4�ź�ѡ�ˣ�<font color=maroon>С��</font></html>");
        radioButtons[3].setActionCommand(yncCommand);
        for (int i = 0; i < numButtons; i++) {
            group.add(radioButtons[i]);
        }
        // ����Ĭ�ϣ�ѡ���һ����ť
        radioButtons[0].setSelected(true);
        voteButton = new JButton("ͶƱ");
        voteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = group.getSelection().getActionCommand();
                // ok �Ի���
                if (command == defaultMessageCommand) {
                    JOptionPane.showMessageDialog(frame,
                                "�ú�ѡ���ǻ�����ͶƱ��Ч��");
                // yes/no �Ի���
                } else if (command == yesNoCommand) {
                    int n = JOptionPane.showConfirmDialog(
                            frame, "�ú�ѡ����һ������ \n������ָ���ͶƱ��",
                            "ȷ����Ϣ��",
                            JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) {
                        setLabel("�õģ���ע���������롣");
                    } else if (n == JOptionPane.NO_OPTION) {
                        setLabel("������ѡ�ĺá�");
                    } else {
                        setLabel("ͶƱ������ʥ��ְ��");
                    }
                // yes/no �Ի���(�Զ���)
                } else if (command == yeahNahCommand) {
                    Object[] options = {"�ǵģ���ͶƱ", "��,�Ҳ�ͶƱ"};
                    int n = JOptionPane.showOptionDialog(frame,
                                    "�ú�ѡ���Ѿ�������\n�������Ͷ��һƱ��",
                                    "ȷ����Ϣ��",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                    if (n == JOptionPane.YES_OPTION) {
                        setLabel("��ϣ������Ҫ�������ѡ���й����ָ����");
                    } else if (n == JOptionPane.NO_OPTION) {
                        setLabel("������ѡ�ĺã�");
                    } else {
                        setLabel("ͶƱ������ʥ��ְ��");
                    }

                // yes/no/cancel �Ի���(�Զ���)
                } else if (command == yncCommand) {
                    Object[] options = {"�ǵģ�",
                                        "������Ҫ��Ȩ",
                                        "������һ��"};
                    int n = JOptionPane.showOptionDialog(frame,
                                    "С������μӣ�����"
                                    + "���Ͷ��һƱ��",
                                    "ȷ����Ϣ��",
                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    options,
                                    options[2]);
                    if (n == JOptionPane.YES_OPTION) {
                        setLabel("�����ѡƱ��");
                    } else if (n == JOptionPane.NO_OPTION) {
                        setLabel("������ô˵����������ѡ��");
                    } else if (n == JOptionPane.CANCEL_OPTION) {
                        setLabel("�ҵ�Ȼ����ǿ����ͶƱ��");
                    } else {
                        setLabel("ͶƱ������ʥ��ְ��");
                    }
                }
                return;
            }
        });
	System.out.println("calling createPane");
        return createPane(simpleDialogDesc + ":",
                          radioButtons, 
                          voteButton);                    
    }
    
    private JPanel createPane(String description,
                              JRadioButton[] radioButtons,
                              JButton showButton) {
        int numChoices = radioButtons.length;
        JPanel box = new JPanel();
        JLabel label = new JLabel(description);

        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.add(label);

        for (int i = 0; i < numChoices; i++) {
            box.add(radioButtons[i]);
        }

        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        pane.add(box, BorderLayout.NORTH);
        pane.add(showButton, BorderLayout.SOUTH);
        System.out.println("returning pane");
        return pane;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ͶƱ�Ի���");

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(1,1));
        contentPane.add(new VoteDialog(frame));

        // ���رմ���ʱ���˳�
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        frame.pack();
        frame.setVisible(true);
    }
}