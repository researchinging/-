import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CelsiusConverter2 implements ActionListener {
    JFrame converterFrame;
    JPanel converterPanel;
    JTextField tempCelsius;
    JLabel celsiusLabel, fahrenheitLabel;
    JButton convertTemp;
    // ���캯��
    public CelsiusConverter2() {
	// ��������
	converterFrame = new JFrame("�������¶�ת��Ϊ�����¶�");
	converterFrame.setSize(40, 40);
	converterPanel = new JPanel();
	converterPanel.setLayout(new GridLayout(2, 2));
	// ��� widgets.
	addWidgets();
	// ��frame��������
	converterFrame.getContentPane().add(converterPanel, BorderLayout.CENTER);
        // �����ڹر�ʱ���˳�
        converterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	// ��ʾת����.
	converterFrame.pack();
	converterFrame.setVisible(true);
    }
    // Ϊת�������������widgets.
    private void addWidgets() {
	// ���� widgets.
	ImageIcon icon = new ImageIcon("images/convert.gif", "Convert temperature");
	tempCelsius = new JTextField(2);
	celsiusLabel = new JLabel("�����¶�", SwingConstants.LEFT);
	convertTemp = new JButton(icon);
	fahrenheitLabel = new JLabel("�����¶�", SwingConstants.LEFT);
	celsiusLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	fahrenheitLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	// ����ת����ť�������¼�.
	convertTemp.addActionListener(this);
	// ��widgets��ӵ�ת������.
	converterPanel.add(tempCelsius);
	converterPanel.add(celsiusLabel);
	converterPanel.add(convertTemp);
	converterPanel.add(fahrenheitLabel);
    }
    // ʵ��ActionListener�ӿ�.
    public void actionPerformed(ActionEvent event) {
	// �������¶Ƚ���Ϊ˫���Ȳ���ת��Ϊ�����¶�.
        int tempFahr = (int)((Double.parseDouble(tempCelsius.getText())) 
                           * 1.8 + 32);
	// �����ý������fahrenheitLabel��ǩ�����Ҹ����¶�ֵ����������ɫ.
	if (tempFahr <= 32) {
	    fahrenheitLabel.setText("<html><Font Color=blue>" + tempFahr + "&#176 </Font><Font Color=black> �����¶�</font></html>");
	} else if (tempFahr <= 80) {
	    fahrenheitLabel.setText("<html><Font Color=green>" + tempFahr + "&#176 </Font><Font Color=black> �����¶�</Font></html>");
	} else {
	    fahrenheitLabel.setText("<html><Font Color=red>" + tempFahr + "&#176 </Font><Font Color=black> �����¶�</Font></html>");
	}
    }
    // main ����
    public static void main(String[] args) {
	// ������ʾ���
	try {
	    UIManager.setLookAndFeel(
		UIManager.getCrossPlatformLookAndFeelClassName());
	} catch(Exception e) {}

	CelsiusConverter2 converter = new CelsiusConverter2();
	
    }
}
