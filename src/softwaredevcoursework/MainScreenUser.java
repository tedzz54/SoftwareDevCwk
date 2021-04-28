/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredevcoursework;

import java.sql.ResultSet;
import java.awt.BorderLayout;
<<<<<<< Updated upstream
=======
import java.awt.Color;
>>>>>>> Stashed changes
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
<<<<<<< Updated upstream
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
=======
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
>>>>>>> Stashed changes
import org.jfree.data.jdbc.JDBCPieDataset;

/**
 *
<<<<<<< Updated upstream
 * @author theod, Marcin Markowski
 */
public class MainScreenUser extends javax.swing.JFrame {
    String direction = "N";
    String date = "04/05/2005";
=======
 * @author theod, Marcin Markowski, Dylan Neyaz, Mohammad Waraich 
 */
public class MainScreenUser extends javax.swing.JFrame {
    //Standard data so that if user clicks on one of the charts before confirming the data selection the charts aren't empty but instead display something.
    String direction = "N";
    String date = "04/05/2005";
    String vehicleType = "allMotorVehicle";
>>>>>>> Stashed changes
    int countPoint = 20716;
    
    /**
     * Creates new form MainScreenUser
     */
    public MainScreenUser() {
        initComponents();
        this.setLocationRelativeTo(null);
        jPanelCharts.setLayout(new java.awt.BorderLayout());
        
    }
    
    public MainScreenUser(String userEmail){
        initComponents();      
        userEmailMain.setText(userEmail);
        this.setLocationRelativeTo(null);
        jPanelCharts.setLayout(new java.awt.BorderLayout());
        
    }
    
<<<<<<< Updated upstream
    public void drawPie(){
=======
    public void drawPie(){       
>>>>>>> Stashed changes
        JFrame frame = new JFrame("Error");
        Connection connection = TrafficDatabaseConnect.getConnection();
        Statement stmt = null;     
        DefaultPieDataset pieDataset = null;
<<<<<<< Updated upstream
        String Query = "SELECT  time, allMotorVehicle FROM countPoint JOIN vehicleType ON countPoint.countPointId = vehicleType.countPointId WHERE countPoint = " + countPoint + " AND directionOfTravel = '" + direction + "' AND date = '" + date + "';";
=======
        //Query to find the selected vehicle type volume at times when the traffic was measured with selected direction date and count point
        String Query = "SELECT  time, " + vehicleType + " FROM countPoint JOIN vehicleType ON countPoint.countPointId = vehicleType.countPointId WHERE countPoint = " + countPoint + " AND directionOfTravel = '" + direction + "' AND date = '" + date + "';";
>>>>>>> Stashed changes

        try {      
                  
            stmt = connection.createStatement( );
            pieDataset = new JDBCPieDataset(connection, Query);           
            ResultSet rs = stmt.executeQuery(Query);   
            if (rs.next() == false) {
                System.out.println("ResultSet in empty in Java");
<<<<<<< Updated upstream
=======
                //Pop up with error if the query has failed since not all count points are measured west east or north south same with date.
>>>>>>> Stashed changes
                JOptionPane.showMessageDialog(frame,
                "Count Point: " + countPoint +" was not measured on the selected date or direction",
                "Query Error",
                JOptionPane.ERROR_MESSAGE);              
              } 
                
                
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
<<<<<<< Updated upstream
       JFreeChart chart = ChartFactory.createPieChart3D("Hourly traffic volume at Count Point: " + countPoint + " on: " + date + " direction: " + direction , pieDataset, true, true, false );
=======
       JFreeChart chart = ChartFactory.createPieChart3D("Hourly " + vehicleType +" volume at Count Point: " + countPoint + " on: " + date + " direction: " + direction , pieDataset, true, true, false );
>>>>>>> Stashed changes
       //Custom label that displays the times + values
       PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {1}");
       final PiePlot3D plot = (PiePlot3D) chart.getPlot();
       plot.setStartAngle(270);
       plot.setForegroundAlpha(0.60f);
       plot.setInteriorGap(0.02);
       plot.setLabelGenerator(labelGenerator);
       //Printing the chart on the Panel
       ChartPanel chartPanel = new ChartPanel(chart);
<<<<<<< Updated upstream
       jPanelCharts.removeAll();
       jPanelCharts.add(chartPanel, BorderLayout.CENTER);
       jPanelCharts.validate();          
    }
    
    
=======
       //Removing previous chart
       jPanelCharts.removeAll();
       jPanelCharts.add(chartPanel, BorderLayout.CENTER);
       //Refreshing panel
       jPanelCharts.validate();          
    }
    
    public void drawBarChart(){
        JFrame frame = new JFrame("Error");
        Connection connection = TrafficDatabaseConnect.getConnection();
        Statement stmt = null;   
        JDBCCategoryDataset dataset = null;
        String sql = "SELECT  time, " + vehicleType + " FROM countPoint JOIN vehicleType ON countPoint.countPointId = vehicleType.countPointId WHERE countPoint = " + countPoint + " AND directionOfTravel = '" + direction + "' AND date = '" + date + "';";
        try {      
                  
            stmt = connection.createStatement( );
            dataset = new JDBCCategoryDataset(TrafficDatabaseConnect.getConnection(), sql);          
            ResultSet rs = stmt.executeQuery(sql);   
            if (rs.next() == false) {
                System.out.println("ResultSet in empty in Java");
                JOptionPane.showMessageDialog(frame,
                "Count Point: " + countPoint +" was not measured on the selected date or direction",
                "Query Error",
                JOptionPane.ERROR_MESSAGE);              
              } 
                
                
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
            
        JFreeChart barChart = ChartFactory.createBarChart("Query Bar Chart", "Time", "Amount", dataset, PlotOrientation.VERTICAL, false, true, true);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.ORANGE);
        
        ChartPanel barPanel = new ChartPanel(barChart);
        jPanelCharts.removeAll();
        jPanelCharts.add(barPanel,BorderLayout.CENTER);
        jPanelCharts.validate();
    }
    
    public void drawLineChart(){
        JFrame frame = new JFrame("Error");
        Connection connection = TrafficDatabaseConnect.getConnection();
        Statement stmt = null;   
        JDBCCategoryDataset dataset = null;
        String sql = "SELECT  time, " + vehicleType + " FROM countPoint JOIN vehicleType ON countPoint.countPointId = vehicleType.countPointId WHERE countPoint = " + countPoint + " AND directionOfTravel = '" + direction + "' AND date = '" + date + "';";
        try {      
                  
            stmt = connection.createStatement( );
            dataset = new JDBCCategoryDataset(TrafficDatabaseConnect.getConnection(), sql);          
            ResultSet rs = stmt.executeQuery(sql);   
            if (rs.next() == false) {
                System.out.println("ResultSet in empty in Java");
                JOptionPane.showMessageDialog(frame,
                "Count Point: " + countPoint +" was not measured on the selected date or direction",
                "Query Error",
                JOptionPane.ERROR_MESSAGE);              
              } 
                
                
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
            
        JFreeChart lineChart = ChartFactory.createLineChart("Query Line Chart", "Time", "Amount", dataset, PlotOrientation.VERTICAL, true,true,false);
        CategoryPlot barchrt = lineChart .getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.ORANGE);
        
        ChartPanel linePanel = new ChartPanel(lineChart);
        jPanelCharts.removeAll();
        jPanelCharts.add(linePanel,BorderLayout.CENTER);
        jPanelCharts.validate();
    }
>>>>>>> Stashed changes
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

<<<<<<< Updated upstream
        jFrame1 = new javax.swing.JFrame();
        buttonGroupDirection = new javax.swing.ButtonGroup();
=======
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
>>>>>>> Stashed changes
        barChartButton = new javax.swing.JButton();
        lineChartButton = new javax.swing.JButton();
        pieChartButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        userEmailMain = new javax.swing.JLabel();
<<<<<<< Updated upstream
        signOut = new javax.swing.JButton();
        textFieldCountPoint = new java.awt.TextField();
=======
>>>>>>> Stashed changes
        jRadioButtonNorth = new javax.swing.JRadioButton();
        jRadioButtonSouth = new javax.swing.JRadioButton();
        jRadioButtonWest = new javax.swing.JRadioButton();
        jRadioButtonEast = new javax.swing.JRadioButton();
        textFieldDate = new java.awt.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        signOut1 = new javax.swing.JButton();
        jPanelCharts = new javax.swing.JPanel();
<<<<<<< Updated upstream
=======
        textFieldCountPoint = new java.awt.TextField();
        jComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
>>>>>>> Stashed changes

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        barChartButton.setText("Bar Chart");
        barChartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barChartButtonActionPerformed(evt);
            }
        });

        lineChartButton.setText("Line Chart");
        lineChartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineChartButtonActionPerformed(evt);
            }
        });

        pieChartButton.setText("Pie Chart");
        pieChartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieChartButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Fourth Chart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        userEmailMain.setText("jLabel1");
        userEmailMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userEmailMainMouseClicked(evt);
            }
        });

        signOut.setText("Sign Out");
        signOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutActionPerformed(evt);
            }
        });

        textFieldCountPoint.setText("20716");
        textFieldCountPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountPointTextFieldActionPerformed(evt);
            }
        });

<<<<<<< Updated upstream
        buttonGroupDirection.add(jRadioButtonNorth);
=======
        jRadioButtonNorth.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(jRadioButtonNorth);
        jRadioButtonNorth.setForeground(new java.awt.Color(255, 255, 255));
>>>>>>> Stashed changes
        jRadioButtonNorth.setSelected(true);
        jRadioButtonNorth.setText("North");
        jRadioButtonNorth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
<<<<<<< Updated upstream
                NorthRadioActionPerformed(evt);
            }
        });

        buttonGroupDirection.add(jRadioButtonSouth);
        jRadioButtonSouth.setText("South");
        jRadioButtonSouth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SouthRadioActionPerformed(evt);
            }
        });

        buttonGroupDirection.add(jRadioButtonWest);
        jRadioButtonWest.setText("West");
        jRadioButtonWest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WestRadioActionPerformed(evt);
            }
        });

        buttonGroupDirection.add(jRadioButtonEast);
        jRadioButtonEast.setText("East");
        jRadioButtonEast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EastRadioActionPerformed(evt);
=======
                jRadioButtonNorthNorthRadioActionPerformed(evt);
            }
        });

        jRadioButtonSouth.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(jRadioButtonSouth);
        jRadioButtonSouth.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonSouth.setText("South");
        jRadioButtonSouth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSouthSouthRadioActionPerformed(evt);
            }
        });

        jRadioButtonWest.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(jRadioButtonWest);
        jRadioButtonWest.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonWest.setText("West");
        jRadioButtonWest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonWestWestRadioActionPerformed(evt);
            }
        });

        jRadioButtonEast.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(jRadioButtonEast);
        jRadioButtonEast.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonEast.setText("East");
        jRadioButtonEast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEastEastRadioActionPerformed(evt);
>>>>>>> Stashed changes
            }
        });

        textFieldDate.setText("04/05/2005");
        textFieldDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
<<<<<<< Updated upstream
                DateTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Date");

        jLabel2.setText("Count Point");

        jLabel3.setText("Direction");

        signOut1.setText("Confirm");
        signOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
=======
                textFieldDateDateTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Date");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Count Point");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Direction");

        signOut1.setBackground(new java.awt.Color(153, 0, 0));
        signOut1.setForeground(new java.awt.Color(255, 255, 255));
        signOut1.setText("Confirm");
        signOut1.setBorder(null);
        signOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOut1confirmActionPerformed(evt);
>>>>>>> Stashed changes
            }
        });

        jPanelCharts.setAutoscrolls(true);
        jPanelCharts.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanelCharts.setFocusTraversalPolicyProvider(true);
        jPanelCharts.setInheritsPopupMenu(true);
        jPanelCharts.setPreferredSize(new java.awt.Dimension(0, 700));

        javax.swing.GroupLayout jPanelChartsLayout = new javax.swing.GroupLayout(jPanelCharts);
        jPanelCharts.setLayout(jPanelChartsLayout);
        jPanelChartsLayout.setHorizontalGroup(
            jPanelChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelChartsLayout.setVerticalGroup(
            jPanelChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );

<<<<<<< Updated upstream
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(barChartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lineChartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pieChartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(userEmailMain)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(signOut)
                        .addGap(14, 14, 14))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCharts, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldCountPoint, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jRadioButtonWest))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonSouth)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jRadioButtonNorth))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonEast)
                        .addGap(32, 32, 32)
                        .addComponent(signOut1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
=======
        textFieldCountPoint.setText("20716");
        textFieldCountPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCountPointCountPointTextFieldActionPerformed(evt);
            }
        });

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pedalCycles", "twoWheelMotorVehicles", "carsAndTaxis", "busesAndCoaches", "lgvs", "allHgvs", "allMotorVehicle" }));
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Vehicle Type");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelCharts, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(barChartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lineChartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pieChartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(signOut, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(userEmailMain)
                                .addGap(23, 23, 23))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldCountPoint, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jRadioButtonWest))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButtonSouth)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jRadioButtonNorth))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonEast)
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addComponent(signOut1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))))
>>>>>>> Stashed changes
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jRadioButtonEast, jRadioButtonNorth, jRadioButtonSouth, jRadioButtonWest});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(barChartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lineChartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pieChartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userEmailMain)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
<<<<<<< Updated upstream
                        .addComponent(signOut)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCharts, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldCountPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jRadioButtonNorth)
                                        .addGap(15, 15, 15))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jRadioButtonWest)
                                            .addComponent(jRadioButtonEast))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                        .addComponent(jRadioButtonSouth))
                    .addComponent(signOut1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
=======
                        .addComponent(signOut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanelCharts, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldCountPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(10, 10, 10))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jRadioButtonNorth)
                                    .addGap(15, 15, 15))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButtonWest)
                                        .addComponent(jRadioButtonEast))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(signOut1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jRadioButtonSouth)
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> Stashed changes
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userEmailMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userEmailMainMouseClicked

    }//GEN-LAST:event_userEmailMainMouseClicked

    private void signOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutActionPerformed
        JOptionPane.showMessageDialog(this,"You are now signed out. Redirecting to Sign in page!");

        Date date = new Date();
        long time = date.getTime();
        java.sql.Timestamp LogoutTime = new java.sql.Timestamp(time);
        String userEmail1 = userEmailMain.getText();
        userActivityTable.update(userEmail1, LogoutTime);
        


        SignIn signin = new SignIn();
        signin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_signOutActionPerformed

    private void barChartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barChartButtonActionPerformed
        drawBarChart();
    }//GEN-LAST:event_barChartButtonActionPerformed

    private void lineChartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineChartButtonActionPerformed
        drawLineChart();
    }//GEN-LAST:event_lineChartButtonActionPerformed

    private void pieChartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieChartButtonActionPerformed
        drawPie();
    }//GEN-LAST:event_pieChartButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FourthChartDashboard fourthchart = new FourthChartDashboard();
        fourthchart.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NorthRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NorthRadioActionPerformed
     
    }//GEN-LAST:event_NorthRadioActionPerformed

    private void CountPointTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountPointTextFieldActionPerformed
      
    }//GEN-LAST:event_CountPointTextFieldActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        if (jRadioButtonNorth.isSelected())
            direction = "N";           
        if (jRadioButtonSouth.isSelected())
            direction = "S";
        if (jRadioButtonWest.isSelected())
            direction = "W";
        if (jRadioButtonEast.isSelected())
            direction = "E";
        date = textFieldDate.getText();
        countPoint = Integer.parseInt(textFieldCountPoint.getText());
        System.out.println(date + " " + countPoint + " " + direction);
        drawPie();
    }//GEN-LAST:event_confirmActionPerformed

    private void DateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateTextFieldActionPerformed
       
    }//GEN-LAST:event_DateTextFieldActionPerformed

<<<<<<< Updated upstream
    private void SouthRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SouthRadioActionPerformed
      
    }//GEN-LAST:event_SouthRadioActionPerformed

    private void WestRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WestRadioActionPerformed
        
    }//GEN-LAST:event_WestRadioActionPerformed

    private void EastRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EastRadioActionPerformed
       
    }//GEN-LAST:event_EastRadioActionPerformed

    
=======
    private void jRadioButtonSouthSouthRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSouthSouthRadioActionPerformed

    }//GEN-LAST:event_jRadioButtonSouthSouthRadioActionPerformed

    private void jRadioButtonWestWestRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonWestWestRadioActionPerformed

    }//GEN-LAST:event_jRadioButtonWestWestRadioActionPerformed

    private void jRadioButtonEastEastRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEastEastRadioActionPerformed

    }//GEN-LAST:event_jRadioButtonEastEastRadioActionPerformed

    private void textFieldDateDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldDateDateTextFieldActionPerformed

    }//GEN-LAST:event_textFieldDateDateTextFieldActionPerformed

    private void signOut1confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOut1confirmActionPerformed
        if (jRadioButtonNorth.isSelected())
        direction = "N";
        if (jRadioButtonSouth.isSelected())
        direction = "S";
        if (jRadioButtonWest.isSelected())
        direction = "W";
        if (jRadioButtonEast.isSelected())
        direction = "E";
        date = textFieldDate.getText();
        countPoint = Integer.parseInt(textFieldCountPoint.getText());
        vehicleType = String.valueOf(jComboBox.getSelectedItem());
        System.out.println(date + " " + countPoint + " " + direction + " " + vehicleType);
    }//GEN-LAST:event_signOut1confirmActionPerformed

    private void textFieldCountPointCountPointTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCountPointCountPointTextFieldActionPerformed

    }//GEN-LAST:event_textFieldCountPointCountPointTextFieldActionPerformed

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxActionPerformed

    private void jRadioButtonNorthNorthRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNorthNorthRadioActionPerformed

    }//GEN-LAST:event_jRadioButtonNorthNorthRadioActionPerformed

>>>>>>> Stashed changes
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
            java.util.logging.Logger.getLogger(MainScreenUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreenUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreenUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreenUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreenUser().setVisible(true);
            }           
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton barChartButton;
<<<<<<< Updated upstream
    private javax.swing.ButtonGroup buttonGroupDirection;
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
=======
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
>>>>>>> Stashed changes
    private javax.swing.JPanel jPanelCharts;
    private javax.swing.JRadioButton jRadioButtonEast;
    private javax.swing.JRadioButton jRadioButtonNorth;
    private javax.swing.JRadioButton jRadioButtonSouth;
    private javax.swing.JRadioButton jRadioButtonWest;
    private javax.swing.JButton lineChartButton;
    private javax.swing.JButton pieChartButton;
    private javax.swing.JButton signOut;
    private javax.swing.JButton signOut1;
    private java.awt.TextField textFieldCountPoint;
    private java.awt.TextField textFieldDate;
    private javax.swing.JLabel userEmailMain;
    // End of variables declaration//GEN-END:variables
}
