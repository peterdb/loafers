package loafers.text.gradient.html;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

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

                        JTextPane textPane = new JTextPane();
                        textPane.setEditable(false);
                        textPane.setEnabled(false);
                        textPane.setEditorKit(new PatternHtmlEditorKit(textPane, new Gradient(Color.RED, Color.BLACK)));
                        textPane.setText("<html><body><h1>test</h1> blah");

                        add(textPane);

                        pack();
                    }
                }.setVisible(true);
            }
        });
    }

}
