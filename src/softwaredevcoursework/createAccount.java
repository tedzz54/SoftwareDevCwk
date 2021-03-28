/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredevcoursework;
import java.sql.ResultSet;
import java.util.Base64;
import javax.swing.JOptionPane;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author theod
 */
public class createAccount extends javax.swing.JFrame {

    /**
     * Creates new form createAccount
     */
    public createAccount() {
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

        jButton1 = new javax.swing.JButton();
        uname = new javax.swing.JTextField();
        uemail = new javax.swing.JTextField();
        upass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(upass, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(uemail)
                    .addComponent(uname)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(uemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(upass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          String userName = uname.getText();
          String userEmail = uemail.getText();
          String userPass = upass.getText();
          
          ResultSet userResultSet = UserTable.get(userEmail);
          
          String encryptedString = getEncodedString(userPass);
          
         
          
        try {
            
            String emailRegex = "^(.+)@(.+)$";
            
            if (userName.trim().equals("")){
            JOptionPane.showMessageDialog(this,"Please enter your username!");
            
            } else if (userEmail.trim().equals("")){
                JOptionPane.showMessageDialog(this,"Please enter your email!");
                
            }else if (!userEmail.matches(emailRegex)){
                JOptionPane.showMessageDialog(this,"Email is not in valid format!");

            } else if (userResultSet.next()){
                JOptionPane.showMessageDialog(this,"An account is already registered with this email");
                
            } else {
                UserTable.insert(0, userName, userEmail,encryptedString);
                JOptionPane.showMessageDialog(this,"User successfully registered!");
                TimeUnit.SECONDS.sleep(2);
                SignIn signin = new SignIn();
                signin.setVisible(true);
                this.setVisible(false);
                
                
            }
            
        
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

 
 
    private static String getEncodedString(String userPassEncrypted){
        return Base64.getEncoder().encodeToString(userPassEncrypted.getBytes());
    }
    public static void main(String args[]) {
        
       
        
        
       

        
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField uemail;
    private javax.swing.JTextField uname;
    private javax.swing.JPasswordField upass;
    // End of variables declaration//GEN-END:variables
}