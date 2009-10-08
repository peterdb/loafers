package loafers.performance.simple;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author Peter De Bruycker
 */
public class JavaApp {

    public static void main(String[] args) throws Exception {
        long before = System.currentTimeMillis();

        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("");

                JButton button = new JButton("button");
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("you pushed me");
                    }
                });

                JPanel panel = new JPanel(new FlowLayout());
                panel.add(button);

                frame.add(panel);

                frame.setSize(300, 300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        long after = System.currentTimeMillis();

        System.out.println(JavaApp.class.getName() + " took " + (after - before) + "ms");

        System.exit(0);
    }

}
