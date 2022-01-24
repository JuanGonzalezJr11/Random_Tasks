package vista;

import controlador.GestorBaseDatos;
import javax.swing.DefaultListModel;
import modelo.*;

public class Principal extends javax.swing.JFrame {
    private GestorBaseDatos g;
    DefaultListModel modeloPersonal = new DefaultListModel();
    DefaultListModel modeloTareas = new DefaultListModel();
    public Principal() {
        initComponents();
        g = new GestorBaseDatos();
        lstPersonal.setModel(modeloPersonal);
        for (Empleado e : g.listadoEmpleados()) {
            modeloPersonal.addElement(e);
        }
        lstTareas.setModel(modeloTareas);
        for (Tarea ta : g.listadoTareas()) {
            modeloTareas.addElement(ta);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAgregarPersona = new javax.swing.JButton();
        btnAgregarTarea = new javax.swing.JButton();
        btnAsignarTareas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPersonal = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstTareas = new javax.swing.JList<>();
        lblPersonas = new javax.swing.JLabel();
        lblTareas = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 0, 0);

        btnAgregarPersona.setText("Gestionar personal");
        btnAgregarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPersonaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarPersona);
        btnAgregarPersona.setBounds(20, 390, 160, 23);

        btnAgregarTarea.setText("Gestionar tarea");
        btnAgregarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTareaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarTarea);
        btnAgregarTarea.setBounds(250, 390, 160, 23);

        btnAsignarTareas.setText("Asignar tareas");
        getContentPane().add(btnAsignarTareas);
        btnAsignarTareas.setBounds(470, 190, 130, 70);

        jScrollPane1.setViewportView(lstPersonal);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 80, 160, 297);

        jScrollPane2.setViewportView(lstTareas);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(200, 80, 253, 297);

        lblPersonas.setText("Personal:");
        getContentPane().add(lblPersonas);
        lblPersonas.setBounds(20, 60, 70, 14);

        lblTareas.setText("Tareas:");
        getContentPane().add(lblTareas);
        lblTareas.setBounds(200, 60, 60, 14);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Asignación de tareas");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 10, 250, 29);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 40, 590, 10);

        setBounds(0, 0, 649, 477);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPersonaActionPerformed
        Personal p = new Personal();
        p.setVisible(true);
        p.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnAgregarPersonaActionPerformed

    private void btnAgregarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTareaActionPerformed
        Tareas t = new Tareas();
        t.setVisible(true);
        t.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnAgregarTareaActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPersona;
    private javax.swing.JButton btnAgregarTarea;
    private javax.swing.JButton btnAsignarTareas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblPersonas;
    private javax.swing.JLabel lblTareas;
    private javax.swing.JList<String> lstPersonal;
    private javax.swing.JList<String> lstTareas;
    // End of variables declaration//GEN-END:variables
}
