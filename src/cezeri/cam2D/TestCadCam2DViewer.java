/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cezeri.cam2D;

import cezeri.cad2D.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kabeja.parser.ParseException;

/**
 *
 * @author BAP1
 */
public class TestCadCam2DViewer extends javax.swing.JFrame {

    /**
     * Creates new form TestCadViewer
     */
    public TestCadCam2DViewer() {
        initComponents();
        initialize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2DCad = new PanelCadViewer();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel2DCad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panel2DCadLayout = new javax.swing.GroupLayout(panel2DCad);
        panel2DCad.setLayout(panel2DCadLayout);
        panel2DCadLayout.setHorizontalGroup(
            panel2DCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        panel2DCadLayout.setVerticalGroup(
            panel2DCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2DCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2DCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestCadCam2DViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestCadCam2DViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestCadCam2DViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestCadCam2DViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestCadCam2DViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel2DCad;
    // End of variables declaration//GEN-END:variables

    public PanelCadViewer getCad2DViewer(){
        return (PanelCadViewer)panel2DCad;
    }
    private void initialize() {
        List<Cad2DShape> lst=readDXF("feeder.dxf");        
        getCad2DViewer().populateShapeList(lst);
    }

    private List<Cad2DShape> readDXF(String path) {
        List<Cad2DShape> lst=new ArrayList<>();
        try {
            File file = new File(path);
            ArrayList<CadLine> lines = ReadFileDXF.getLinesFromAutocadFile(file.getAbsolutePath());
            if (lines != null) {
                for (int index = 0; index < lines.size(); index++) {
                    System.out.println("Line " + (index + 1));
                    double x1=((CadLine)lines.get(index)).p1x;
                    double y1=((CadLine)lines.get(index)).p1y;
                    double x2=((CadLine)lines.get(index)).p2x;
                    double y2=((CadLine)lines.get(index)).p2y;
                    System.out.print("(" + x1 + "," + y1 + ")");
                    System.out.print(" to (" + x2 + "," + y2 + ")\n");
                    lst.add(lines.get(index));
                }
            }
            ArrayList<CadCircle> circles = ReadFileDXF.getCirclesFromAutocadFile(file.getAbsolutePath());
            if (circles != null) {
                for (int index = 0; index < circles.size(); index++) {
                    System.out.println("Circle " + (index + 1));
                    double cx=((CadCircle)circles.get(index)).cx;
                    double cy=((CadCircle)circles.get(index)).cy;
                    double r=((CadCircle)circles.get(index)).radious;
                    System.out.print("(Center pos:" + cx + "," + cy + ")");
                    System.out.print(" radious: (" + r + ")\n");
                    lst.add(circles.get(index));
                }
            }
            ArrayList<CadArc> arcs = ReadFileDXF.getArcsFromAutocadFile(file.getAbsolutePath());
            if (arcs != null) {
                for (int index = 0; index < arcs.size(); index++) {
                    System.out.println("arcs " + (index + 1));
                    double cx=((CadArc)arcs.get(index)).cx;
                    double cy=((CadArc)arcs.get(index)).cy;
                    double r=((CadArc)arcs.get(index)).radious;
                    double sa=((CadArc)arcs.get(index)).startAngle;
                    double ea=((CadArc)arcs.get(index)).endAngle;
                    double exta=((CadArc)arcs.get(index)).extentAngle;
                    System.out.print("(topleft pos:" + cx + "," + cy + ") start angle:"+sa+ " end angle:"+ea+" extentAngle:"+exta);
                    System.out.print(" iscounterClock:"+((CadArc)arcs.get(index)).isCounterClockWise+" radious: (" + r + ")\n");
                    lst.add(arcs.get(index));
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(TestCadCam2DViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
}