import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;       //Ϊ��ʵ�ֲ��ֹ���
import java.awt.event.*; //Ϊ�˴����¼�����
import java.net.URL;
import java.io.IOException;

public class TextSamplerDemo extends JFrame
                             implements ActionListener {
    private String newline = "\n";
    protected static final String textFieldString = "�������û���";
    protected static final String passwordFieldString = "����������";
    protected JLabel actionLabel;
    public TextSamplerDemo() {
        super("TextSamplerDemo");
        //����һ�������ı������.
        JTextField textField = new JTextField(10);
        textField.setActionCommand(textFieldString);
        textField.addActionListener(this);
        //����һ�������ı���.
        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setActionCommand(passwordFieldString);
        passwordField.addActionListener(this);
        //����һЩ��ǩ.
        JLabel textFieldLabel = new JLabel(textFieldString + "��");
        textFieldLabel.setLabelFor(textField);
        JLabel passwordFieldLabel = new JLabel(passwordFieldString + "��");
        passwordFieldLabel.setLabelFor(passwordField);
        //����һ����ǩ��������¼�������Ϣ.
        actionLabel = new JLabel("�����ı���������������֣�Ȼ���»س���.");
	actionLabel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        //���ı�����ͱ�ǩ���в��ֹ���.
        JPanel textControlsPane = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        textControlsPane.setLayout(gridbag);
        JLabel[] labels = {textFieldLabel, passwordFieldLabel};
        JTextField[] textFields = {textField, passwordField};
        addLabelTextRows(labels, textFields, gridbag, textControlsPane);
        c.gridwidth = GridBagConstraints.REMAINDER; //���
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1.0;
        gridbag.setConstraints(actionLabel, c);
        textControlsPane.add(actionLabel);
        textControlsPane.setBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("�ı������"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));
        //����һ���ı�����.
        JTextArea textArea = new JTextArea(
                "This is an editable JTextArea " +
                "that has been initialized with the setText method. " +
                "A text area is a \"plain\" text component, " +
                "which means that although it can display text " +
                "in any font, all of the text is in the same font."
        );
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(250, 250));
        areaScrollPane.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("��ͨ����"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                areaScrollPane.getBorder()));
        //����һ���༭���.
        JEditorPane editorPane = createEditorPane();
        JScrollPane editorScrollPane = new JScrollPane(editorPane);
        editorScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        editorScrollPane.setPreferredSize(new Dimension(250, 145));
        editorScrollPane.setMinimumSize(new Dimension(10, 10));
        //����һ���ı����.
        JTextPane textPane = createTextPane();
        JScrollPane paneScrollPane = new JScrollPane(textPane);
        paneScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        paneScrollPane.setPreferredSize(new Dimension(250, 155));
        paneScrollPane.setMinimumSize(new Dimension(10, 10));
        //���ɱ༭�ı�����ı������һ��split pane�����.
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                                              editorScrollPane,
                                              paneScrollPane);
        splitPane.setOneTouchExpandable(true);
        JPanel rightPane = new JPanel();
        rightPane.add(splitPane);
        rightPane.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("��������"),
                        BorderFactory.createEmptyBorder(5,5,5,5)));
        //�����еĶ���������applet��.
        JPanel leftPane = new JPanel();
        BoxLayout leftBox = new BoxLayout(leftPane, BoxLayout.Y_AXIS);
        leftPane.setLayout(leftBox);
        leftPane.add(textControlsPane);
        leftPane.add(areaScrollPane);
        JPanel contentPane = new JPanel();
        BoxLayout box = new BoxLayout(contentPane, BoxLayout.X_AXIS);
        contentPane.setLayout(box);
        contentPane.add(leftPane);
        contentPane.add(rightPane);
        setContentPane(contentPane);
    }
    private void addLabelTextRows(JLabel[] labels,
                                  JTextField[] textFields,
                                  GridBagLayout gridbag,
                                  Container container) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        int numLabels = labels.length;
        for (int i = 0; i < numLabels; i++) {
            c.gridwidth = GridBagConstraints.RELATIVE; //�����ڶ�
            c.fill = GridBagConstraints.NONE;      //��������ΪĬ��ֵ
            c.weightx = 0.0;                       //��������ΪĬ��ֵ
            gridbag.setConstraints(labels[i], c);
            container.add(labels[i]);
            c.gridwidth = GridBagConstraints.REMAINDER;     //���һ��
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 1.0;
            gridbag.setConstraints(textFields[i], c);
            container.add(textFields[i]);
        }
    }
    public void actionPerformed(ActionEvent e) {
        String prefix = "�������� \"";
        if (e.getActionCommand().equals(textFieldString)) {
            JTextField source = (JTextField)e.getSource();
            actionLabel.setText(prefix + source.getText() + "\"");
        } else {
            JPasswordField source = (JPasswordField)e.getSource();
            actionLabel.setText(prefix + new String(source.getPassword())
                                + "\"");
        }
    }
    private JEditorPane createEditorPane() {
        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false);
        String s = null;
        try {
            s = "file:"
                + System.getProperty("user.dir")
                + System.getProperty("file.separator")
                + "TextSamplerDemoHelp.html";
            URL helpURL = new URL(s);
            displayURL(helpURL, editorPane);
        } catch (Exception e) {
            System.err.println("Couldn't create help URL: " + s);
        }

        return editorPane;
    }
    private void displayURL(URL url, JEditorPane editorPane) {
        try {
            editorPane.setPage(url);
        } catch (IOException e) {
            System.err.println("Attempted to read a bad URL: " + url);
        }
    }
    private JTextPane createTextPane() {
        JTextPane textPane = new JTextPane();
        String[] initString =
                { "This is an editable JTextPane, ",		//����
                  "another ",					//б��
                  "styled ",					//����
                  "text ",					//С
                  "component, ",				//��
                  "which supports embedded components..." + newline,//����
                  " " + newline,				//��ť
                  "...and embedded icons..." + newline,		//����
                  " ", 						//ͼ��
                  newline + "JTextPane is a subclass of JEditorPane that " +
                    "uses a StyledEditorKit and StyledDocument, and provides " +
                    "cover methods for interacting with those objects."
                 };
        String[] initStyles = 
                { "regular", "italic", "bold", "small", "large",
                  "regular", "button", "regular", "icon",
                  "regular"
                };
        initStylesForTextPane(textPane);
        Document doc = textPane.getDocument();
        try {
            for (int i=0; i < initString.length; i++) {
                doc.insertString(doc.getLength(), initString[i],
                                 textPane.getStyle(initStyles[i]));
            }
        } catch (BadLocationException ble) {
            System.err.println("Couldn't insert initial text.");
        }
        return textPane;
    }
    protected void initStylesForTextPane(JTextPane textPane) {
        //��ʼ��һЩ��ʾ���.
        Style def = StyleContext.getDefaultStyleContext().
                                        getStyle(StyleContext.DEFAULT_STYLE);
        Style regular = textPane.addStyle("regular", def);
        StyleConstants.setFontFamily(def, "SansSerif");
        Style s = textPane.addStyle("italic", regular);
        StyleConstants.setItalic(s, true);
        s = textPane.addStyle("bold", regular);
        StyleConstants.setBold(s, true);
        s = textPane.addStyle("small", regular);
        StyleConstants.setFontSize(s, 10);
        s = textPane.addStyle("large", regular);
        StyleConstants.setFontSize(s, 16);
        s = textPane.addStyle("icon", regular);
        StyleConstants.setAlignment(s, StyleConstants.ALIGN_CENTER);
        StyleConstants.setIcon(s, new ImageIcon("images/Pig.gif"));
        s = textPane.addStyle("button", regular);
        StyleConstants.setAlignment(s, StyleConstants.ALIGN_CENTER);
        JButton button = new JButton(new ImageIcon("images/sound.gif"));
        button.setMargin(new Insets(0,0,0,0));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Toolkit.getDefaultToolkit().beep();
            }
        });
        StyleConstants.setComponent(s, button);
    }
    public static void main(String[] args) {
        JFrame frame = new TextSamplerDemo();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}
