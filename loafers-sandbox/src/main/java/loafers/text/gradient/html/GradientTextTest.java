package loafers.text.gradient.html;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.html.HTMLDocument;

import loafers.paint.Gradient;

/**
 * @author Peter De Bruycker
 */
public class GradientTextTest {

    // TODO adapt this code so it words with a HtmlEditorKit

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JFrame("test") {
                    private static final long serialVersionUID = 1L;

                    {
                        setDefaultCloseOperation(EXIT_ON_CLOSE);

                        final SimpleAttributeSet attrs = new SimpleAttributeSet();

                        JTextPane textPane = new JTextPane();
                        textPane.setEditorKit(new PatternHtmlEditorKit());
                        textPane.setText("<html><body><b>test</b> blah");

                        HTMLDocument doc = (HTMLDocument) textPane.getDocument();
                        doc.setCharacterAttributes(0, textPane.getText().length(), attrs, true);
                        attrs.addAttribute("textPane", textPane);
                        attrs.addAttribute("pattern", new Gradient(Color.RED, Color.BLACK));

                        add(textPane);

                        pack();
                    }
                }.setVisible(true);
            }
        });
    }

}
