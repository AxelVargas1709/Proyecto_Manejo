package pmanejo;

import BaseDd.BDEmpleados;
import BaseDd.empleados;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class RegistroFrm extends javax.swing.JInternalFrame {

    DefaultComboBoxModel modeloCB = new DefaultComboBoxModel();
    private String imgPathLogo = "/icons/logo.png";
    private BDEmpleados mBd;

    public RegistroFrm() {
        initComponents();
        mBd = new BDEmpleados("login", "root", "");
        this.setSize(778, 581);
        this.setResizable(false);
        //this.setLocationRelativeTo(null);
        cargarCombo();
    }

    private void cargarCombo() {
        String[] modelo = {
            "GERENTE", "VENDEDOR",
        };
        for (String i : modelo) {
            modeloCB.addElement(i);
        }
        jcbdatos.setModel(modeloCB);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblRegistro = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblInicioSesion = new javax.swing.JLabel();
        cbMostrar = new javax.swing.JCheckBox();
        cbMostrarConfirm = new javax.swing.JCheckBox();
        txtPassword = new javax.swing.JPasswordField();
        txtPasswordConfirm = new javax.swing.JPasswordField();
        jbtnGuardar = new javax.swing.JButton();
        jcbdatos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        lblRegistro.setBackground(new java.awt.Color(255, 255, 255));
        lblRegistro.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblRegistro.setForeground(new java.awt.Color(255, 255, 255));
        lblRegistro.setText("Registro");

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(102, 102, 102));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(102, 102, 102));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nombre");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Apellido");

        txtCedula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(102, 102, 102));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Cedula");

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(102, 102, 102));

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Telefono");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Contraseña");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Confirmar contraseña");

        txtSueldo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSueldo.setForeground(new java.awt.Color(102, 102, 102));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Sueldo");

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Cargo");

        lblInicioSesion.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblInicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        lblInicioSesion.setText("Regresar al inicio de sesión");
        lblInicioSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInicioSesionMouseClicked(evt);
            }
        });

        cbMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMostrarActionPerformed(evt);
            }
        });

        cbMostrarConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMostrarConfirmActionPerformed(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jbtnGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbtnGuardar.setText("GUARDAR");
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

        jcbdatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbdatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(lblRegistro))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(jLabel17)
                            .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(jLabel24)
                            .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbdatos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbMostrar))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(txtPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbMostrarConfirm))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lblInicioSesion)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblInicioSesion)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblRegistro)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbMostrar)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbMostrarConfirm))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbdatos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblInicioSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInicioSesionMouseClicked
        this.dispose();
        LoginFrm mLoginFrm = new LoginFrm();
        mLoginFrm.setVisible(true);
    }//GEN-LAST:event_lblInicioSesionMouseClicked

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed

    }//GEN-LAST:event_txtPasswordActionPerformed

    private void cbMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMostrarActionPerformed
        if (cbMostrar.isSelected()) {
            txtPassword.setEchoChar((char) 0); //password = JPasswordField
        } else {
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_cbMostrarActionPerformed

    private void cbMostrarConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMostrarConfirmActionPerformed
        if (cbMostrarConfirm.isSelected()) {
            txtPasswordConfirm.setEchoChar((char) 0); //password = JPasswordField
        } else {
            txtPasswordConfirm.setEchoChar('*');
        }
    }//GEN-LAST:event_cbMostrarConfirmActionPerformed
    public void limpliartexto() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtSueldo.setText("");
        txtPassword.setText("");
        txtPasswordConfirm.setText("");
        txtTelefono.setText("");
    }

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        // TODO add your handling code here:
        String mensaje;
        mensaje = jcbdatos.getSelectedItem().toString();
        if (!txtNombre.getText().trim().equals("") && !txtCedula.getText().trim().equals("") && !txtApellido.getText().trim().equals("")
                && !txtTelefono.getText().trim().equals("") && !txtSueldo.getText().trim().equals("")
                && !txtPassword.getText().trim().equals("") && !txtPasswordConfirm.getText().trim().equals("")) {
            if (txtPassword.getText().trim().equals(txtPasswordConfirm.getText().trim())) {
                //if (jcbdatos.getSelectedItem() != jcbdatos.getSelectedItem()) {
                    empleados mUsuario = new empleados();
                    mUsuario.setCedula_emp(txtCedula.getText().trim());
                    mUsuario.setNombre_emp(txtNombre.getText().trim());
                    mUsuario.setApellido_emp(txtApellido.getText().trim());
                    mUsuario.setContrasena_emp(txtPassword.getText().trim());
                    mUsuario.setTelefono_emp(txtTelefono.getText().trim());
                    mUsuario.setSueldo_emp(Integer.parseInt(txtSueldo.getText().trim()));
                    mUsuario.setCargo_emp(mensaje);
                    if (mBd.Conectar()) {
                        if (mBd.AddUserEmp(mUsuario)) {
                            JOptionPane.showMessageDialog(null, "Alta usuario exitosa!");
                            limpliartexto();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al conectar");
                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, "Debe Seleccionar cargo");
//                }
            } else {
                JOptionPane.showMessageDialog(null, "las contraseñas no coinciden");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Llena todos los campos");
        }

    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jcbdatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbdatosActionPerformed
    }//GEN-LAST:event_jcbdatosActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroFrm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroFrm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroFrm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroFrm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbMostrar;
    private javax.swing.JCheckBox cbMostrarConfirm;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JComboBox<String> jcbdatos;
    private javax.swing.JLabel lblInicioSesion;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordConfirm;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
