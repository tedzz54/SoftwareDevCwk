/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredevcoursework;

//import com.sun.jdi.connect.spi.Connection;
//import java.beans.Statement;
//import java.awt.Color;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartFrame;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.renderer.category.BarRenderer;
//import org.jfree.data.jdbc.JDBCCategoryDataset;
//import java.util.Date;
//import javax.swing.JOptionPane;

/**
 *
 * @author theod
 */
public class PieChartDashboard extends javax.swing.JFrame {
    
//    ChartFrame frame;

    /**
     * Creates new form PieChartDashboard
     */
    public PieChartDashboard() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(PieChartDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PieChartDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PieChartDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PieChartDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PieChartDashboard().setVisible(true);
            }
        });
    }
    
//    public void drawPie() {
//        Connection connection = TrafficDatabaseConnect.getConnection();
//        Statement stmt = null;
//        JDBCCategoryDataset dataset = null;
//
//       
//        try {
//            /**
//            stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("Select * from employee limit 6");
//            
//            int n = 0;
//            while (rs.next()) {
//                int numColumns = rs.getMetaData().getColumnCount();
//                n++;
//                for (int i = 1; i <= numColumns; i++) {
//                    System.out.print(" " + rs.getObject(i));
//                }
//
//                System.out.println("");
//            }
//
//            rs.close();
//            */
//
//            String sql = "SELECT countPointId, count(*) As Number_Of FROM vehicleType GROUP BY allMotorVehicles ";
//
//            dataset = new JDBCCategoryDataset(connection, sql);
//
//            System.out.println("dataset cols and rows : " + dataset.getColumnCount() + "  " + dataset.getRowCount());
//            
//        } catch (SQLException ex) {
//            System.err.println("SQLException: " + ex.getMessage());
//        } finally {
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    System.err.println("SQLException: " + e.getMessage());
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    System.err.println("SQLException: " + e.getMessage());
//                }
//            }
//        }
//        JFreeChart chart = ChartFactory.createBarChart("Volume of Vehicle at Count Point: ",
//                "Vehicle Type", "Volume", dataset, PlotOrientation.VERTICAL, false, true, false);
//        chart.setBackgroundPaint(Color.white);
//        chart.getTitle().setPaint(Color.blue);
//
//        CategoryPlot p = chart.getCategoryPlot();
//        p.setRangeGridlinePaint(Color.blue);
//        BarRenderer renderer = (BarRenderer) p.getRenderer();
//        renderer.setDrawBarOutline(true);
//        renderer.setShadowVisible(true);
//        renderer.setItemMargin(-4);
//        renderer.setSeriesPaint(0, Color.blue);
//
//        frame = new ChartFrame("Vehicle Volume", chart);
//        frame.setVisible(true);
//        frame.setSize(400, 350);
//       
//
//    }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
