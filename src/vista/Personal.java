package vista;

import controlador.GestorBaseDatos;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Empleado;

public class Personal extends javax.swing.JFrame {
    private GestorBaseDatos g;
    DefaultListModel modelo = new DefaultListModel();
    public Personal() {
        initComponents();
        g = new GestorBaseDatos();
        txtIdEmpleado.setEditable(false);
        txtIdEmpleado.setVisible(false);
        btnGuardarCambios.setEnabled(false);
        lstPersonal.setModel(modelo);
        for (Empleado e : g.listadoEmpleados()) {
            modelo.addElement(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAgregar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPersonal = new javax.swing.JList<>();
        btnModificar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        txtIdEmpleado = new javax.swing.JTextField();
        btnGuardarCambios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 60, 90, 14);

        jLabel2.setText("Descripción:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 110, 90, 14);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(20, 80, 360, 20);

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 130, 360, 80);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Personal");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 10, 120, 29);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 40, 360, 10);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(291, 220, 90, 23);

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBorrar);
        btnBorrar.setBounds(510, 220, 90, 23);

        jScrollPane2.setViewportView(lstPersonal);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(410, 40, 240, 170);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar);
        btnModificar.setBounds(410, 220, 90, 23);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver);
        btnVolver.setBounds(20, 220, 80, 23);

        txtIdEmpleado.setFocusable(false);
        getContentPane().add(txtIdEmpleado);
        txtIdEmpleado.setBounds(320, 50, 60, 20);

        btnGuardarCambios.setText("Guardar cambios");
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarCambios);
        btnGuardarCambios.setBounds(140, 220, 140, 23);

        setBounds(0, 0, 682, 303);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            if(!txtNombre.getText().isEmpty()){
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                Empleado em = new Empleado(nombre, descripcion);
                g.agregarEmpleado(em);
                modelo.removeAllElements();
                lstPersonal.setModel(modelo);
                for (Empleado e : g.listadoEmpleados()) {
                    modelo.addElement(e);
                }
                JOptionPane.showMessageDialog(this, "El personal fue cargado con éxito.");
            }
            else{
                JOptionPane.showMessageDialog(this, "Debe ingresar el nombre del personal.");
            }
            txtNombre.setText(null);
            txtDescripcion.setText(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo agregar el personal.");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Principal p = new Principal();
        p.setVisible(true);
        p.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            Empleado empleado = (Empleado) lstPersonal.getSelectedValue();
            txtNombre.setText(empleado.getNombre());
            txtDescripcion.setText(empleado.getDescripcion());
            txtIdEmpleado.setText(String.valueOf(empleado.getIdEmpleado()));
            btnAgregar.setEnabled(false);
            btnGuardarCambios.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un personal de la lista.");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        try {
            if(!txtNombre.getText().isEmpty()){
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                int idEmpleado = Integer.parseInt(txtIdEmpleado.getText());
                g.modificarEmpleado(new Empleado(idEmpleado, nombre, descripcion));
                modelo.removeAllElements();
                lstPersonal.setModel(modelo);
                for (Empleado e : g.listadoEmpleados()) {
                    modelo.addElement(e);
                }
                JOptionPane.showMessageDialog(this, "Los cambios fueron realizados con éxito.");
            }
            txtNombre.setText(null);
            txtDescripcion.setText(null);
            btnGuardarCambios.setEnabled(false);
            btnAgregar.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo guardar los cambios.");
        }
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try {
            String opciones[] = {"Sí", "No"};
            Empleado empleado = (Empleado) lstPersonal.getSelectedValue();
            int pregunta = JOptionPane.showOptionDialog(this, "¿Seguro que desea borrar a " + empleado.toString() + "?", "Borrar", 0, 0, null, opciones, NORMAL);
            if (pregunta == JOptionPane.YES_OPTION) {
                g.borrarEmpleado(empleado.getIdEmpleado());
                modelo.removeAllElements();
                lstPersonal.setModel(modelo);
                for (Empleado e : g.listadoEmpleados()) {
                    modelo.addElement(e);
                }
                JOptionPane.showMessageDialog(this, "El personal fue borrado.");
            }
            if (pregunta == JOptionPane.NO_OPTION) {
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un personal de la lista.");
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

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
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<Object> lstPersonal;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
