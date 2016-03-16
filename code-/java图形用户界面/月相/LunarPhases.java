import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

public class LunarPhases implements ActionListener {
    final static int NUM_IMAGES = 8;
    final static int START_INDEX = 3;

    ImageIcon[] images = new ImageIcon[NUM_IMAGES];
    JPanel mainPanel, selectPanel, displayPanel;
    JComboBox phaseChoices = null;
    JLabel phaseIconLabel = null;
    // 构造函数
    public LunarPhases() {
	// 创建下拉式选择框并且显示面板.
	selectPanel = new JPanel();
	displayPanel = new JPanel();
	// 向子面板上添加各种widgets.
	addWidgets();
	// 创建包含两个子面板的主面板组件
	mainPanel = new JPanel();
	mainPanel.setLayout(new GridLayout(2,1,5,5));
	mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	// 向主面板中添加子面板
	mainPanel.add(selectPanel);
	mainPanel.add(displayPanel);
    }
    // 为选择和显示月相创建widgets
    private void addWidgets() {
	// 获得图片并且将它们存放在一个ImageIcon数组中.
	for (int i = 0; i < NUM_IMAGES; i++) {
	    String imageName = "images/image" + i + ".jpg";
	    System.out.println("getting image: " + imageName);
	    URL iconURL = ClassLoader.getSystemResource(imageName);
	    ImageIcon icon = new ImageIcon(iconURL);
	    images[i] = icon;
	}
	// 为显示月相创建一个标签组件并且为它设置边界.
	phaseIconLabel = new JLabel();
	phaseIconLabel.setHorizontalAlignment(JLabel.CENTER);
	phaseIconLabel.setVerticalAlignment(JLabel.CENTER);
	phaseIconLabel.setVerticalTextPosition(JLabel.CENTER);
	phaseIconLabel.setHorizontalTextPosition(JLabel.CENTER);
	phaseIconLabel.setBorder(BorderFactory.createCompoundBorder(
			    BorderFactory.createLoweredBevelBorder(),
			    BorderFactory.createEmptyBorder(5,5,5,5)));	
	phaseIconLabel.setBorder(BorderFactory.createCompoundBorder(
			    BorderFactory.createEmptyBorder(0,0,10,0),
			    phaseIconLabel.getBorder()));
	// 创建一个下拉式选择框.
	String[] phases = { "New", "Waxing Crescent", "First Quarter", 
			    "Waxing Gibbous", "Full", "Waning Gibbous", 
			    "Third Quarter", "Waning Crescent" };
	phaseChoices = new JComboBox(phases);
	phaseChoices.setSelectedIndex(START_INDEX);
	// 显示第一幅图片.
	phaseIconLabel.setIcon(images[START_INDEX]);
	phaseIconLabel.setText("");
    	// 为选择框添加边界
	selectPanel.setBorder(BorderFactory.createCompoundBorder(
		BorderFactory.createTitledBorder("Select Phase"), 
		BorderFactory.createEmptyBorder(5,5,5,5)));
    	// 为显示框添加边界
    	displayPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Display Phase"), 
            BorderFactory.createEmptyBorder(5,5,5,5)));
	// 将选择框添加到select panel，将图像显示框添加到displayPanel.
	selectPanel.add(phaseChoices);
	displayPanel.add(phaseIconLabel);
	// 监听来自选择框的事件
	phaseChoices.addActionListener(this);
    }
    // 实现事件监听接口.
    public void actionPerformed(ActionEvent event) {
	if ("comboBoxChanged".equals(event.getActionCommand())) {
	    // 更新显示图像
	    phaseIconLabel.setIcon(images[phaseChoices.getSelectedIndex()]);
	}
    }
    // main 方法
    public static void main(String[] args) {
	// 创建LunarPhases的一个新实例
	LunarPhases phases = new LunarPhases();
	// 创建frame和用来包含panel的容器.
	JFrame lunarPhasesFrame = new JFrame("Lunar Phases");
	// 设置显示风格
	try {
	    UIManager.setLookAndFeel(
		UIManager.getCrossPlatformLookAndFeelClassName());
	} catch(Exception e) {}
	
	lunarPhasesFrame.setContentPane(phases.mainPanel);
        // 关闭窗口时退出
        lunarPhasesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	// 显示窗口
	lunarPhasesFrame.pack();
	lunarPhasesFrame.setVisible(true);
    }
}
