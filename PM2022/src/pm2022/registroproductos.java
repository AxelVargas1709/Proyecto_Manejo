/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm2022;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import BaseDd.*;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author PERSONAL
 */
public class registroproductos extends javax.swing.JInternalFrame {

    /**
     * Creates new form empleados
     */
    DefaultTableModel modelo= new DefaultTableModel();
    DefaultComboBoxModel modeloCB = new DefaultComboBoxModel();
    Integer fila;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public registroproductos() {
        initComponents();
        cargarCombo();
        cargarTablas();
        cargarTextos();
        bloquearTextos();
        bloquearBotones();
        
    }
 private void cargarCombo() {
        String[] modelo = {
            "Linea Blanca", "Linea Gris", "Linea amarilla"
        };
        for (String i : modelo) {
            modeloCB.addElement(i);
        }
        jcbxClasificacion.setModel(modeloCB);
    }
 
    public void bloquearTextos() {
        jtxtNombrePro.setEnabled(false);
        jtxtPrecio.setEnabled(false);
        jtxtCantidad.setEnabled(false);
        jtxtModelo.setEnabled(false);
        jtxtMarca.setEnabled(false);
    }

    public void desbloquearTextos() {
        jtxtNombrePro.setEnabled(true);
        jtxtPrecio.setEnabled(true);
        jtxtCantidad.setEnabled(true);
        jtxtModelo.setEnabled(true);
        jtxtMarca.setEnabled(true);
    }

    public void bloquearBotones() {
        jbtnNuevo.setEnabled(true);
        jbtnAgregar.setEnabled(false);
        jbtnCancelar.setEnabled(false);
        jbtnEditar.setEnabled(false);
        jbtnSalir.setEnabled(true);
        jbtnEliminar.setEnabled(false);
    }

    public void desbloquearBotones() {
        jbtnNuevo.setEnabled(false);
        jbtnAgregar.setEnabled(true);
        jbtnCancelar.setEnabled(true);
        jbtnEditar.setEnabled(false);
        jbtnSalir.setEnabled(true);
        jbtnEliminar.setEnabled(false);
    }

    public void desbloquearBotonesEditarEliminar() {
        jbtnNuevo.setEnabled(false);
        jbtnAgregar.setEnabled(false);
        jbtnCancelar.setEnabled(true);
        jbtnEditar.setEnabled(true);
        jbtnSalir.setEnabled(true);
        jbtnEliminar.setEnabled(true);
    }

    public void desbloquearTextosEditarEliminar() {
        jtxtNombrePro.setEnabled(true);
        jtxtPrecio.setEnabled(true);
        jtxtCantidad.setEnabled(true);
        jtxtModelo.setEnabled(true);
        jtxtMarca.setEnabled(true);
    }

    public void limpliartexto() {
        jtxtNombrePro.setText("");
        jtxtPrecio.setText("");
        jtxtCantidad.setText("");
        jtxtModelo.setText("");
        jtxtMarca.setText("");
        

    }

    public void cargarTextos() {
        String mensaje;
        mensaje = jcbxClasificacion.getSelectedItem().toString();
        jtblTablaProductos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtblTablaProductos.getSelectedRow() != -1) {
                    fila = jtblTablaProductos.getSelectedRow();
                    txtCodPro.setText(jtblTablaProductos.getValueAt(fila, 0).toString());
                    jtxtNombrePro.setText(jtblTablaProductos.getValueAt(fila, 1).toString());
                    jtxtMarca.setText(jtblTablaProductos.getValueAt(fila, 2).toString());
                    jtxtModelo.setText(jtblTablaProductos.getValueAt(fila, 3).toString());
                    mensaje.valueOf(jtblTablaProductos.getValueAt(fila, 4).toString());
                    jtxtCantidad.setText(jtblTablaProductos.getValueAt(fila, 5).toString());
                    jtxtPrecio.setText(jtblTablaProductos.getValueAt(fila, 6).toString());
                    desbloquearBotonesEditarEliminar();
                    desbloquearTextosEditarEliminar();
                }
            }
        });
    }

    public void cargarTablas() {
        try {
            String[] titulos = {"CODIGO","NOMBRE", "MARCA", "MODELO", "CLASIFICACION", "CANTIDAD","PRECIO UNITARIO"};
            String[] registros = new String[7];
            modelo = new DefaultTableModel(null, titulos);
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "select * from productos";

            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("COD_PRO");
                registros[1] = rs.getString("NOM_PRO");
                registros[2] = rs.getString("MARC_PRO");
                registros[3] = rs.getString("MODE_PRO");
                registros[4] = rs.getString("CLAS_PRO");
                registros[5] = rs.getString("CANT_PRO");
                registros[6] = rs.getString("PRE_PRO");
                modelo.addRow(registros);
            }
            jtblTablaProductos.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            //Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void agregarDatosProductos() {
        String mensaje;
        mensaje = jcbxClasificacion.getSelectedItem().toString();
        
        if (jtxtNombrePro.getText().isEmpty() || jtxtNombrePro.getText() == "") {
            JOptionPane.showMessageDialog(this, "Debe ingresar la cedula");
            jtxtNombrePro.requestFocus();
        } else if (jtxtMarca.getText().isEmpty() || jtxtMarca.getText() == "") {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre");
            jtxtMarca.requestFocus();
        } else if (jtxtModelo.getText().isEmpty() || jtxtModelo.getText() == "") {
            JOptionPane.showMessageDialog(this, "Debe ingresar la cedula");
            jtxtModelo.requestFocus();
        } else {
            try {
                // TODO add your handling code here:
                Conexion cc = new Conexion();
                Connection cn = cc.conectar();
                String sql = "";
                sql = "insert into productos(COD_PRO,NOM_PRO, MARC_PRO,"
                        + "MODE_PRO,CLAS_PRO,CANT_PRO,PRE_PRO)values(?,?,?,?,?,?,?)";

                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setString(1, txtCodPro.getText());
                psd.setString(2, jtxtNombrePro.getText());
                psd.setString(3, jtxtMarca.getText());
                psd.setString(4, jtxtModelo.getText());
                psd.setString(5, mensaje);
                psd.setString(6, jtxtCantidad.getText());
                psd.setString(7, jtxtPrecio.getText());

                int n = psd.executeUpdate();
                if (n > 0) {
                    JOptionPane.showConfirmDialog(null, "Agregado");
                    cargarTablas();
                    bloquearTextos();
                    bloquearBotones();
                    limpliartexto();
                }
            } catch (SQLException ex) {
                // Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    private void actualizarDatos() {
        String mensaje;
        mensaje = jcbxClasificacion.getSelectedItem().toString();
            try {
                Conexion cc = new Conexion();
                Connection cn = cc.conectar();
                String sql = "";
                sql = "update productos set NOM_PRO='" + jtxtNombrePro.getText()
                        + "',MARC_PRO='" + jtxtMarca.getText()
                        + "',MODE_PRO='" + jtxtModelo.getText()
                        + "',CANT_PRO='" + jtxtCantidad.getText()
                        + "',CLAS_PRO='" + mensaje
                        + "',PRE_PRO='" + jtxtPrecio.getText()
                        + "'where NOM_PRO='" + jtxtNombrePro.getText() + "'";

                PreparedStatement psd = cn.prepareStatement(sql);
                int n = psd.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Se actualizo Correctamente");
                    cargarTablas();
                    limpliartexto();
                    bloquearTextos();
                    bloquearBotones();
                }
            } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error: " + ex);
            }
        
    }

    public void EliminarDatos() {
        
            if (JOptionPane.showConfirmDialog(new JInternalFrame(), "Estas seguro de borrar el registro",
                    "Borrar registro", JOptionPane.WARNING_MESSAGE,
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                try {
                    // TODO add your handling code here:
                    Conexion cc = new Conexion();
                    Connection cn = cc.conectar();
                    String sql = "";
                    sql = "delete from productos where NOM_PRO='" + jtxtNombrePro.getText() + "'";
                    PreparedStatement psd = cn.prepareStatement(sql);
                    int n = psd.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "Se elimino correctamente");
                        limpliartexto();
                        cargarTablas();
                        //bloquearBotones();
                        bloquearTextos();
                    }

                } catch (SQLException ex) {
                    //Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error: " + ex);
                }

            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtNombrePro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtModelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jbtnEliminar = new javax.swing.JButton();
        jbtnNuevo = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jbtnSalir = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtxtCantidad = new javax.swing.JTextField();
        jbtnAgregar = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtxtPrecio = new javax.swing.JTextField();
        jcbxClasificacion = new javax.swing.JComboBox<>();
        txtCodPro = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblTablaProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("REGISTRO DE PRODUCTOS");

        jLabel2.setText("NOMBRE:");

        jLabel3.setText("MARCA:");

        jLabel4.setText("MODELO:");

        jLabel5.setText("CLASIFICACIÓN:");

        jbtnEliminar.setText("ELIMINAR");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jbtnNuevo.setText("NUEVO");
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");

        jbtnCancelar.setText("CANCELAR");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jbtnSalir.setText("SALIR");
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });

        jButton6.setText("jButton6");

        jLabel6.setText("CANTIDAD:");

        jbtnAgregar.setText("AGREGAR");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        jbtnEditar.setText("EDITAR");
        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });

        jLabel7.setText("PRECIO UNITARIO:");

        jcbxClasificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jtxtNombrePro, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jtxtMarca))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jtxtModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jcbxClasificacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtnAgregar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jButton6)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbtnEliminar)
                                        .addGap(13, 13, 13)
                                        .addComponent(jbtnCancelar))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtNombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnEliminar)
                        .addComponent(jbtnAgregar)
                        .addComponent(jbtnCancelar)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3))
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbxClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnNuevo)
                            .addComponent(jbtnEditar)
                            .addComponent(jbtnSalir))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane1.setViewportView(jtblTablaProductos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        // TODO add your handling code here:
        agregarDatosProductos();
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed
        // TODO add your handling code here:
        actualizarDatos();
    }//GEN-LAST:event_jbtnEditarActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        // TODO add your handling code here:
        EliminarDatos();
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
        // TODO add your handling code here:
        desbloquearTextos();
        desbloquearBotones();
    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        // TODO add your handling code here:
        limpliartexto();
        bloquearBotones();
        bloquearTextos();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbtnSalirActionPerformed
    public registroproductos BuscarPro(String cod){
        registroproductos producto = new registroproductos();
        Connection con;
        Conexion cn = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM productos WHERE COD_PRO = ?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.rs.getInt("COD_PRO");
                producto.rs.getString("NOM_PRO");
                producto.rs.getDouble("MARC_PRO");
                producto.rs.getInt("MOD_PRO");
                producto.rs.getInt("PRE_PRO");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return producto;
    }
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
            java.util.logging.Logger.getLogger(registroproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroproductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JButton jbtnSalir;
    private javax.swing.JComboBox<String> jcbxClasificacion;
    private javax.swing.JTable jtblTablaProductos;
    private javax.swing.JTextField jtxtCantidad;
    private javax.swing.JTextField jtxtMarca;
    private javax.swing.JTextField jtxtModelo;
    private javax.swing.JTextField jtxtNombrePro;
    private javax.swing.JTextField jtxtPrecio;
    private javax.swing.JTextField txtCodPro;
    // End of variables declaration//GEN-END:variables
}
