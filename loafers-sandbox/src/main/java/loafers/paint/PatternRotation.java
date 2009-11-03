/*
 * Copyright 2009 Belgian Railways
 */
package loafers.paint;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author Peter De Bruycker
 */
public class PatternRotation {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JFrame("test") {
                    private static final long serialVersionUID = 1L;

                    {
                        setDefaultCloseOperation(EXIT_ON_CLOSE);

                        JPanel panel = new JPanel() {
                            private static final long serialVersionUID = 1L;

                            @Override
                            public void paint(Graphics g) {
                                Graphics2D graphics = (Graphics2D) g;

                                // in loafers gradients go from top to bottom
                                // so we need to rotate the bottom point by the rotation degrees
                                // bottom point is 0, height

                                int startX = 0;
                                int startY = 0;
                                int endX = 0;
                                int endY = 0;

                                AffineTransform transform = new AffineTransform();
                                transform.rotate(Math.toRadians(45));
                                Point2D target = transform.transform(new Point2D.Double(0, getHeight()), null);
                                endX = (int) target.getX();
                                endY = (int) target.getY();
                                System.out.println(target);
                                System.out.println(getSize());

                                if (Math.abs(target.getX()) < getWidth() || Math.abs(target.getY()) < getHeight()) {
                                    double xRatio = ((double)getWidth()) / Math.abs(target.getX());
                                    double yRatio = ((double)getHeight()) / Math.abs(target.getY());

                                    System.out.println(xRatio);
                                    System.out.println(yRatio);
                                    
                                    endX *= Math.max(xRatio, yRatio);
                                    endY *= Math.max(xRatio, yRatio);
                                }

                                if (endX < 0) {
                                    startX = -endX;
                                    endX = 0;
                                }
                                if (endY < 0) {
                                    startY = -endY;
                                    endY = 0;
                                }
                                
                                System.out.println(startX+","+startY);
                                System.out.println(endX+","+endY);

                                graphics.setPaint(new GradientPaint(startX, startY, Color.BLACK, endX, endY,
                                        Color.WHITE));
                                graphics.fillRect(10, 10, getWidth() - 20, getHeight() - 20);
                                graphics.setPaint(Color.BLACK);
                                graphics.drawRect(10, 10, getWidth() - 20, getHeight() - 20);
                            }
                        };

                        add(panel);

                        pack();
                    }
                }.setVisible(true);
            }
        });
    }

}
