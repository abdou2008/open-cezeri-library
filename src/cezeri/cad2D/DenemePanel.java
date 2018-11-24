/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cezeri.cad2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author BAP1
 */
public class DenemePanel extends javax.swing.JPanel {

    /**
     * Creates new form DenemePanel
     */
    public DenemePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        gr.setColor(Color.red);
//        gr.translate(0.0, h);      // Move the origin to the lower left for actual cartesian coordinate system
//        gr.scale(1.0, -1.0);       // Flip the sign of the coordinate system
//        gr.rotate(90*Math.PI/180,180,180);
        Arc2D.Double arc = new Arc2D.Double(150,150,60,60, 180, -270, Arc2D.OPEN);
        AffineTransform afft=gr.getTransform();
        gr.draw(afft.createTransformedShape(arc));
    }
    
    public static void main(String[] args){
        JFrame frm=new JFrame();
        frm.setContentPane(new DenemePanel());
        frm.setVisible(true);
        frm.setBounds(0, 0, 500, 500);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}