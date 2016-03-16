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
    // ���캯��
    public LunarPhases() {
	// ��������ʽѡ�������ʾ���.
	selectPanel = new JPanel();
	displayPanel = new JPanel();
	// �����������Ӹ���widgets.
	addWidgets();
	// ��������������������������
	mainPanel = new JPanel();
	mainPanel.setLayout(new GridLayout(2,1,5,5));
	mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	// �����������������
	mainPanel.add(selectPanel);
	mainPanel.add(displayPanel);
    }
    // Ϊѡ�����ʾ���ഴ��widgets
    private void addWidgets() {
	// ���ͼƬ���ҽ����Ǵ����һ��ImageIcon������.
	for (int i = 0; i < NUM_IMAGES; i++) {
	    String imageName = "images/image" + i + ".jpg";
	    System.out.println("getting image: " + imageName);
	    URL iconURL = ClassLoader.getSystemResource(imageName);
	    ImageIcon icon = new ImageIcon(iconURL);
	    images[i] = icon;
	}
	// Ϊ��ʾ���ഴ��һ����ǩ�������Ϊ�����ñ߽�.
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
	// ����һ������ʽѡ���.
	String[] phases = { "New", "Waxing Crescent", "First Quarter", 
			    "Waxing Gibbous", "Full", "Waning Gibbous", 
			    "Third Quarter", "Waning Crescent" };
	phaseChoices = new JComboBox(phases);
	phaseChoices.setSelectedIndex(START_INDEX);
	// ��ʾ��һ��ͼƬ.
	phaseIconLabel.setIcon(images[START_INDEX]);
	phaseIconLabel.setText("");
    	// Ϊѡ�����ӱ߽�
	selectPanel.setBorder(BorderFactory.createCompoundBorder(
		BorderFactory.createTitledBorder("Select Phase"), 
		BorderFactory.createEmptyBorder(5,5,5,5)));
    	// Ϊ��ʾ����ӱ߽�
    	displayPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Display Phase"), 
            BorderFactory.createEmptyBorder(5,5,5,5)));
	// ��ѡ�����ӵ�select panel����ͼ����ʾ����ӵ�displayPanel.
	selectPanel.add(phaseChoices);
	displayPanel.add(phaseIconLabel);
	// ��������ѡ�����¼�
	phaseChoices.addActionListener(this);
    }
    // ʵ���¼������ӿ�.
    public void actionPerformed(ActionEvent event) {
	if ("comboBoxChanged".equals(event.getActionCommand())) {
	    // ������ʾͼ��
	    phaseIconLabel.setIcon(images[phaseChoices.getSelectedIndex()]);
	}
    }
    // main ����
    public static void main(String[] args) {
	// ����LunarPhases��һ����ʵ��
	LunarPhases phases = new LunarPhases();
	// ����frame����������panel������.
	JFrame lunarPhasesFrame = new JFrame("Lunar Phases");
	// ������ʾ���
	try {
	    UIManager.setLookAndFeel(
		UIManager.getCrossPlatformLookAndFeelClassName());
	} catch(Exception e) {}
	
	lunarPhasesFrame.setContentPane(phases.mainPanel);
        // �رմ���ʱ�˳�
        lunarPhasesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	// ��ʾ����
	lunarPhasesFrame.pack();
	lunarPhasesFrame.setVisible(true);
    }
}
