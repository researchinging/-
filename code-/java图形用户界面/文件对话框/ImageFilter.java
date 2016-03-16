import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

public class ImageFilter extends FileFilter {
    
    // �������е�·�������е�gif, jpg, �Լ�tiff �ļ�.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String extension = Utils.getExtension(f);
	if (extension != null) {
            if (extension.equals(Utils.tiff) ||
                extension.equals(Utils.tif) ||
                extension.equals(Utils.gif) ||
                extension.equals(Utils.jpeg) ||
                extension.equals(Utils.jpg)) {
                    return true;
            } else {
                return false;
            }
    	}
        return false;
    }
    // ������������
    public String getDescription() {
        return "ͼ���ļ�";
    }
}
