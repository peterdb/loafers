package loafers;

import java.awt.Color
import javax.swing.JOptionPane
import javax.swing.JColorChooser
import javax.swing.JFileChooser

/**
 * Provides methods for working with dialogs.
 * 
 * @author Peter De Bruycker
 */
public class DialogMethods {

    public void alert(String message) {
        // TODO set the current jframe as parent
        JOptionPane.showMessageDialog(null, message)
    }
    
    public String ask(String message){
        return ask(message, null)
    }
    
    public String ask(String message, String value){
        // TODO set the current jframe as parent
        return JOptionPane.showInputDialog(null, message, value)
    }

    public Color ask_color(String title) {
        return ask_color(title, null)
    }
    
    public Color ask_color(String title, Color defaultColor) {
        // TODO set the current jframe as parent
        return JColorChooser.showDialog(null, title, defaultColor);
    }
    
    public File ask_save_file() {
        JFileChooser chooser = new JFileChooser();
        
        if(JFileChooser.APPROVE_OPTION == chooser.showSaveDialog(null)) {
            return chooser.getSelectedFile()
        }
    }
    
    public File ask_open_file() {
        JFileChooser chooser = new JFileChooser();
        
        if(JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null)) {
            return chooser.getSelectedFile()
        }
    }
    
    public File ask_open_folder() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY)
        
        if(JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null)) {
            return chooser.getSelectedFile()
        }
    }
    
    public File ask_save_folder() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY)
        
        if(JFileChooser.APPROVE_OPTION == chooser.showSaveDialog(null)) {
            return chooser.getSelectedFile()
        }
    }
    
    public boolean confirm(String message) {
        return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, message, "Confirm", JOptionPane.YES_NO_OPTION)
    }

    
}
