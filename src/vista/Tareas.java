package vista;

import controlador.GestorBaseDatos;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Tarea;

public class Tareas extends javax.swing.JFrame {
    private GestorBaseDatos g;
    DefaultListModel modelo = new DefaultListModel();
    public Tareas() {
        initComponents();
        g = new GestorBaseDatos();
        txtIdTarea.setEditable(false);
        txtIdTarea.setVisible(false);
        btnGuardarCambios.setEnabled(false);
        lstTareas.setModel(modelo);
        for (Tarea t : g.listadoTareas()) {
            modelo.addElement(t);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTarea = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAgregar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstTareas = new javax.swing.JList<>();
        btnModificar = new javax.swing.JButton();
        txtIdTarea = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        btnGuardarCambios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Tarea:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 60, 90, 14);

        jLabel2.setText("Descripción:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 110, 90, 14);
        getContentPane().add(txtTarea);
        txtTarea.setBounds(20, 80, 360, 20);

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 130, 360, 80);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Tareas");
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

        jScrollPane2.setViewportView(lstTareas);

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
        getContentPane().add(txtIdTarea);
        txtIdTarea.setBounds(320, 50, 60, 20);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver);
        btnVolver.setBounds(20, 220, 80, 23);

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
            if(!txtTarea.getText().isEmpty()){
                String tarea = txtTarea.getText();
                String descripcion = txtDescripcion.getText();
                Tarea t = new Tarea(tarea, descripcion);
                g.agregarTarea(t);
                modelo.removeAllElements();
                lstTareas.setModel(modelo);
                for (Tarea ta : g.listadoTareas()) {
                    modelo.addElement(ta);
                }
                JOptionPane.showMessageDialog(this, "La tarea fue cargado con éxito.");
            }
            else{
                JOptionPane.showMessageDialog(this, "Debe ingresar el nombre de la tarea.");
            }
            txtTarea.setText(null);
            txtDescripcion.setText(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo agregar la tarea.");
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
            Tarea tarea = (Tarea) lstTareas.getSelectedValue();
            txtTarea.setText(tarea.getTarea());
            txtDescripcion.setText(tarea.getDescripcion());
            txtIdTarea.setText(String.valueOf(tarea.getIdTarea()));
            btnAgregar.setEnabled(false);
            btnGuardarCambios.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una tarea de la lista.");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        try {
            if(!txtTarea.getText().isEmpty()){
                String tarea = txtTarea.getText();
                String descripcion = txtDescripcion.getText();
                int idTarea = Integer.parseInt(txtIdTarea.getText());
                g.modificarTarea(new Tarea(idTarea, tarea, descripcion));
                modelo.removeAllElements();
                lstTareas.setModel(modelo);
                for (Tarea ta : g.listadoTareas()) {
                    modelo.addElement(ta);
                }
                JOptionPane.showMessageDialog(this, "Los cambios fueron realizados con éxito.");
            }
            txtTarea.setText(null);
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
            Tarea tarea = (Tarea) lstTareas.getSelectedValue();
            int pregunta = JOptionPane.showOptionDialog(this, "¿Seguro que desea borrar la tarea " + tarea.toString() + "?", "Borrar", 0, 0, null, opciones, NORMAL);
            if (pregunta == JOptionPane.YES_OPTION) {
                g.borrarTarea(tarea.getIdTarea());
                modelo.removeAllElements();
                lstTareas.setModel(modelo);
                for (Tarea ta : g.listadoTareas()) {
                    modelo.addElement(ta);
                }
                JOptionPane.showMessageDialog(this, "La tarea fue eliminada.");
            }
            if (pregunta == JOptionPane.NO_OPTION) {
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una tarea de la lista.");
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
            java.util.logging.Logger.getLogger(Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tareas().setVisible(true);
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
    private javax.swing.JList<Object> lstTareas;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIdTarea;
    private javax.swing.JTextField txtTarea;
    // End of variables declaration//GEN-END:variables
}
