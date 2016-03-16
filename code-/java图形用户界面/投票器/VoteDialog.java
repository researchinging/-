import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VoteDialog extends JPanel {
    JLabel label;
    JFrame frame;
    String simpleDialogDesc = "候选人";
    //构造函数
    public VoteDialog(JFrame frame) {
        this.frame = frame;
        JLabel title;
        // 创建组件
        JPanel choicePanel = createSimpleDialogBox();    
        System.out.println("passed createSimpleDialogBox");
        title = new JLabel("请您首先选择一个候选人，然后"
                           + "单击\"投票\" 按钮",
                           JLabel.CENTER);
        label = new JLabel("现在投票！", JLabel.CENTER);
	label.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        choicePanel.setBorder(BorderFactory.createEmptyBorder(20,20,5,20));
        // 设置布局
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
        radioButtons[0] = new JRadioButton("<html>1号候选人：<font color=red>小王</font></html>");
        radioButtons[0].setActionCommand(defaultMessageCommand);
        radioButtons[1] = new JRadioButton("<html>2号候选人：<font color=green>小张</font></html>");
        radioButtons[1].setActionCommand(yesNoCommand);
        radioButtons[2] = new JRadioButton("<html>3号候选人：<font color=blue>小李</font></html>");
        radioButtons[2].setActionCommand(yeahNahCommand);
        radioButtons[3] = new JRadioButton("<html>4号候选人：<font color=maroon>小刘</font></html>");
        radioButtons[3].setActionCommand(yncCommand);
        for (int i = 0; i < numButtons; i++) {
            group.add(radioButtons[i]);
        }
        // 设置默认：选择第一个按钮
        radioButtons[0].setSelected(true);
        voteButton = new JButton("投票");
        voteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = group.getSelection().getActionCommand();
                // ok 对话框
                if (command == defaultMessageCommand) {
                    JOptionPane.showMessageDialog(frame,
                                "该候选人是坏蛋，投票无效！");
                // yes/no 对话框
                } else if (command == yesNoCommand) {
                    int n = JOptionPane.showConfirmDialog(
                            frame, "该候选人是一个傀儡 \n您还坚持给她投票吗？",
                            "确认信息；",
                            JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) {
                        setLabel("好的，请注意您的收入。");
                    } else if (n == JOptionPane.NO_OPTION) {
                        setLabel("哇塞！选的好。");
                    } else {
                        setLabel("投票是您神圣的职责！");
                    }
                // yes/no 对话框(自定义)
                } else if (command == yeahNahCommand) {
                    Object[] options = {"是的，我投票", "不,我不投票"};
                    int n = JOptionPane.showOptionDialog(frame,
                                    "该候选人已经逝世，\n您还坚持投他一票吗？",
                                    "确认信息：",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                    if (n == JOptionPane.YES_OPTION) {
                        setLabel("我希望您不要对这个候选人有过多的指望。");
                    } else if (n == JOptionPane.NO_OPTION) {
                        setLabel("哇塞！选的好！");
                    } else {
                        setLabel("投票是您神圣的职责！");
                    }

                // yes/no/cancel 对话框(自定义)
                } else if (command == yncCommand) {
                    Object[] options = {"是的！",
                                        "不，我要弃权",
                                        "让我想一想"};
                    int n = JOptionPane.showOptionDialog(frame,
                                    "小刘不想参加，您还"
                                    + "坚持投他一票吗？",
                                    "确认信息：",
                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    options,
                                    options[2]);
                    if (n == JOptionPane.YES_OPTION) {
                        setLabel("优秀的选票。");
                    } else if (n == JOptionPane.NO_OPTION) {
                        setLabel("不管怎么说，这是您的选择。");
                    } else if (n == JOptionPane.CANCEL_OPTION) {
                        setLabel("我当然不能强迫您投票。");
                    } else {
                        setLabel("投票是您神圣的职责！");
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
        JFrame frame = new JFrame("投票对话框");

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(1,1));
        contentPane.add(new VoteDialog(frame));

        // 当关闭窗口时，退出
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        frame.pack();
        frame.setVisible(true);
    }
}