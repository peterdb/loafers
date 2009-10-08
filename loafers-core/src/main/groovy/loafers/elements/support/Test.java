package loafers.elements.support;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import loafers.paint.Gradient;

/**
 * @author Peter De Bruycker
 * 
 */
public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JFrame("test") {
                    private static final long serialVersionUID = 1L;

                    {
                        setDefaultCloseOperation(EXIT_ON_CLOSE);

                        JTextPane textPane = new JTextPane();

                        final SimpleAttributeSet attrs = new SimpleAttributeSet();
                        final SimpleAttributeSet normalAttrs = new SimpleAttributeSet();
                        textPane.setEditorKit(new PaintEditorKit());
                        StyledDocument doc = (StyledDocument) textPane.getDocument();
                        doc.setCharacterAttributes(0, 1, attrs, true);
                        try {
                            attrs.addAttribute("pattern", new Gradient(Color.RED, Color.BLACK));
                            StyleConstants.setFontSize(attrs, 48);
                            StyleConstants.setBold(attrs, true);

                            doc.insertString(doc.getLength(), "just testing", attrs);
                        } catch (Exception e) {

                        }
                        
                        add(textPane);

                        pack();
                    }
                }.setVisible(true);
            }
        });
    }

}
