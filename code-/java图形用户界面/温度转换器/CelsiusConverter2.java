import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CelsiusConverter2 implements ActionListener {
    JFrame converterFrame;
    JPanel converterPanel;
    JTextField tempCelsius;
    JLabel celsiusLabel, fahrenheitLabel;
    JButton convertTemp;
    // 构造函数
    public CelsiusConverter2() {
	// 创建容器
	converterFrame = new JFrame("将摄氏温度转换为华氏温度");
	converterFrame.setSize(40, 40);
	converterPanel = new JPanel();
	converterPanel.setLayout(new GridLayout(2, 2));
	// 添加 widgets.
	addWidgets();
	// 向frame中添加面板
	converterFrame.getContentPane().add(converterPanel, BorderLayout.CENTER);
        // 当窗口关闭时，退出
        converterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	// 显示转换器.
	converterFrame.pack();
	converterFrame.setVisible(true);
    }
    // 为转换器创建和添加widgets.
    private void addWidgets() {
	// 创建 widgets.
	ImageIcon icon = new ImageIcon("images/convert.gif", "Convert temperature");
	tempCelsius = new JTextField(2);
	celsiusLabel = new JLabel("摄氏温度", SwingConstants.LEFT);
	convertTemp = new JButton(icon);
	fahrenheitLabel = new JLabel("华氏温度", SwingConstants.LEFT);
	celsiusLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	fahrenheitLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	// 监听转换按钮触发的事件.
	convertTemp.addActionListener(this);
	// 将widgets添加到转换器中.
	converterPanel.add(tempCelsius);
	converterPanel.add(celsiusLabel);
	converterPanel.add(convertTemp);
	converterPanel.add(fahrenheitLabel);
    }
    // 实现ActionListener接口.
    public void actionPerformed(ActionEvent event) {
	// 将摄氏温度解析为双精度并且转换为华氏温度.
        int tempFahr = (int)((Double.parseDouble(tempCelsius.getText())) 
                           * 1.8 + 32);
	// 将所得结果赋给fahrenheitLabel标签，并且根据温度值设置字体颜色.
	if (tempFahr <= 32) {
	    fahrenheitLabel.setText("<html><Font Color=blue>" + tempFahr + "&#176 </Font><Font Color=black> 华氏温度</font></html>");
	} else if (tempFahr <= 80) {
	    fahrenheitLabel.setText("<html><Font Color=green>" + tempFahr + "&#176 </Font><Font Color=black> 华氏温度</Font></html>");
	} else {
	    fahrenheitLabel.setText("<html><Font Color=red>" + tempFahr + "&#176 </Font><Font Color=black> 华氏温度</Font></html>");
	}
    }
    // main 方法
    public static void main(String[] args) {
	// 设置显示风格
	try {
	    UIManager.setLookAndFeel(
		UIManager.getCrossPlatformLookAndFeelClassName());
	} catch(Exception e) {}

	CelsiusConverter2 converter = new CelsiusConverter2();
	
    }
}
