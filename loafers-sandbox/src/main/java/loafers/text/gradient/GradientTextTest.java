package loafers.text.gradient;

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
 */
public class GradientTextTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JFrame("test") {
                    private static final long serialVersionUID = 1L;

                    {
                        setDefaultCloseOperation(EXIT_ON_CLOSE);

                        final SimpleAttributeSet attrs = new SimpleAttributeSet();

                        JTextPane textPane = new JTextPane();

                        textPane.setEditorKit(new PatternEditorKit());
                        StyledDocument doc = (StyledDocument) textPane.getDocument();
                        doc.setCharacterAttributes(0, 1, attrs, true);
                        try {
                            attrs.addAttribute("textPane", textPane);
                            attrs.addAttribute("pattern", new Gradient(Color.RED, Color.BLACK));
                            StyleConstants.setFontSize(attrs, 48);
                            StyleConstants.setBold(attrs, true);

                            doc.insertString(doc.getLength(), "just testing", attrs);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        add(textPane);

                        pack();
                    }
                }.setVisible(true);
            }
        });
    }

}
