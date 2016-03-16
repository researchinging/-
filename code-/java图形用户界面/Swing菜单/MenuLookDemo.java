import java.awt.*;
import java.awt.event.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

public class MenuLookDemo extends JFrame {
    JTextArea output;
    JScrollPane scrollPane;
    //���캯��
    public MenuLookDemo() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JCheckBoxMenuItem cbMenuItem;
        JRadioButtonMenuItem rbMenuItem;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //�������ӵ������У�����ʹ��Ĭ�ϵĲ��ֹ���
        Container contentPane = getContentPane();
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        //�����˵������
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        //�����˵�
        menu = new JMenu("�˵�1");
        menu.setMnemonic(KeyEvent.VK_A);//������ݷ�ʽ
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);
        //һ��˵���
        menuItem = new JMenuItem("���ı��˵���",
                                 KeyEvent.VK_T);
        //menuItem.setMnemonic(KeyEvent.VK_T); //ʹ�ù��캯��
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);
        menuItem = new JMenuItem("����ͼ����ı��Ĳ˵���", 
                                 new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);
        menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu.add(menuItem);
        //���һ�������ѡ��ť�˵���
        menu.addSeparator();//����ָ���
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("һ����ѡ��ť�˵���");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);
        rbMenuItem = new JRadioButtonMenuItem("��һ����ѡ��ť�˵���");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);
        //���һ�������ѡ��ť�Ĳ˵���
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("һ����ѡ��ť�˵���");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);
        cbMenuItem = new JCheckBoxMenuItem("��һ����ѡ��ť�˵���");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);
        //һ���Ӳ˵�
        menu.addSeparator();
        submenu = new JMenu("�Ӳ˵�");
        submenu.setMnemonic(KeyEvent.VK_S);
        menuItem = new JMenuItem("�Ӳ˵��µĲ˵���");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);
        menuItem = new JMenuItem("��һ���˵���");
        submenu.add(menuItem);
        menu.add(submenu);
        //�ڲ˵����д����ڶ����˵�
        menu = new JMenu("�˵�2");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);
    }
    public static void main(String[] args) {
        MenuLookDemo window = new MenuLookDemo();
        window.setTitle("������ʹ�ò˵�");//���ô��ڲ˵���
        window.setSize(450, 260);//���ô��ڴ�С
        window.setVisible(true);//��ʾ����
    }
}
