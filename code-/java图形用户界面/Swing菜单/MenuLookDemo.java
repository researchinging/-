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
    //构造函数
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
        //将组件添加到窗口中，并且使用默认的布局管理
        Container contentPane = getContentPane();
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        //创建菜单栏组件
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        //创建菜单
        menu = new JMenu("菜单1");
        menu.setMnemonic(KeyEvent.VK_A);//创建快捷方式
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);
        //一组菜单项
        menuItem = new JMenuItem("纯文本菜单项",
                                 KeyEvent.VK_T);
        //menuItem.setMnemonic(KeyEvent.VK_T); //使用构造函数
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);
        menuItem = new JMenuItem("包含图标和文本的菜单项", 
                                 new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);
        menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu.add(menuItem);
        //添加一组包含单选按钮菜单项
        menu.addSeparator();//加入分隔线
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("一个单选按钮菜单项");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);
        rbMenuItem = new JRadioButtonMenuItem("另一个单选按钮菜单项");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);
        //添加一组包含复选按钮的菜单项
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("一个复选按钮菜单项");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);
        cbMenuItem = new JCheckBoxMenuItem("另一个复选按钮菜单项");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);
        //一个子菜单
        menu.addSeparator();
        submenu = new JMenu("子菜单");
        submenu.setMnemonic(KeyEvent.VK_S);
        menuItem = new JMenuItem("子菜单下的菜单项");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);
        menuItem = new JMenuItem("另一个菜单项");
        submenu.add(menuItem);
        menu.add(submenu);
        //在菜单栏中创建第二个菜单
        menu = new JMenu("菜单2");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);
    }
    public static void main(String[] args) {
        MenuLookDemo window = new MenuLookDemo();
        window.setTitle("创建和使用菜单");//设置窗口菜单栏
        window.setSize(450, 260);//设置窗口大小
        window.setVisible(true);//显示窗口
    }
}
