import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// 这个例子讲述JButton,JTextField,JLabel的用法
public class CelsiusConverter implements ActionListener {
    JFrame converterFrame;
    JPanel converterPanel;
    JTextField tempCelsius;
    JLabel celsiusLabel, fahrenheitLabel;
    JButton convertTemp;
    // 构造函数
    public CelsiusConverter() {
	//创建容器
	converterFrame = new JFrame("温度转换器");
	converterFrame.setSize(40, 40);
	converterPanel = new JPanel();
	converterPanel.setLayout(new GridLayout(2, 2));
	// 增加widgets.
	addWidgets();
	// 向frame中添加panel
	converterFrame.getContentPane().add(converterPanel, BorderLayout.CENTER);
	// 关闭窗口时退出
        converterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// 显示转换器
	converterFrame.pack();
	converterFrame.setVisible(true);
    }
    // 为转换器创建和增加widgets
    private void addWidgets() {
	// 创建 widgets.
	tempCelsius = new JTextField(2);
	celsiusLabel = new JLabel("摄氏温度", SwingConstants.LEFT);
	convertTemp = new JButton("转换...");
	fahrenheitLabel = new JLabel("华氏温度", SwingConstants.LEFT);
	// 诊听转换器按钮发出的事件
	convertTemp.addActionListener(this);
	// 向容器中添加widgets
	converterPanel.add(tempCelsius);
	converterPanel.add(celsiusLabel);
	converterPanel.add(convertTemp);
	converterPanel.add(fahrenheitLabel);
        celsiusLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	fahrenheitLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
    // 实现ActionListener接口.
    public void actionPerformed(ActionEvent event) {
      	// 将摄氏温度转换为双精度小数，并且转换为华氏温度.
        int tempFahr = (int)((Double.parseDouble(tempCelsius.getText()))
                             * 1.8 + 32);
	fahrenheitLabel.setText(tempFahr + " Fahrenheit");
    }
    // main 方法
    public static void main(String[] args) {
	// 处理异常
	try {
	    UIManager.setLookAndFeel(
		UIManager.getCrossPlatformLookAndFeelClassName());
	} catch(Exception e) {}

	CelsiusConverter converter = new CelsiusConverter();
    }
}
