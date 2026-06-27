package Visual;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());

    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRegistrarCliente = new javax.swing.JButton();
        btnEntradaVehiculo = new javax.swing.JButton();
        btnSalidaVehiculo = new javax.swing.JButton();
        btnLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Shock Graffiti", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("AUTOLAVADO EL RAYO MCQUEEN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 120, 0, 121);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setText("SELECCIONE UNA OPCION PARA CONTINUAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 248, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        btnRegistrarCliente.setText("REGISTRAR CLIENTE NUEVO");
        btnRegistrarCliente.addActionListener(this::btnRegistrarClienteActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 272, 0, 0);
        jPanel1.add(btnRegistrarCliente, gridBagConstraints);

        btnEntradaVehiculo.setText("ENTRADA DE VEHICULO");
        btnEntradaVehiculo.addActionListener(this::btnEntradaVehiculoActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 272, 0, 0);
        jPanel1.add(btnEntradaVehiculo, gridBagConstraints);

        btnSalidaVehiculo.setText("SALIDA DE VEHICULO");
        btnSalidaVehiculo.addActionListener(this::btnSalidaVehiculoActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 272, 0, 0);
        jPanel1.add(btnSalidaVehiculo, gridBagConstraints);

        btnLista.setText("LISTA DE CLIENTES");
        btnLista.addActionListener(this::btnListaActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 272, 139, 0);
        jPanel1.add(btnLista, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        // TODO add your handling code here:
        Registro vr = new Registro();
        vr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed
    private void btnEntradaVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradaVehiculoActionPerformed
        // TODO add your handling code here:
        EntradaVehiculo ev = new EntradaVehiculo();
        ev.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnEntradaVehiculoActionPerformed
    private void btnSalidaVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaVehiculoActionPerformed
        // TODO add your handling code here:
        SalidaVehiculo sv = new SalidaVehiculo();
        sv.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnSalidaVehiculoActionPerformed
    private void btnListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaActionPerformed
        // TODO add your handling code here:
        ListaClientes lc = new ListaClientes();
        lc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnListaActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntradaVehiculo;
    private javax.swing.JButton btnLista;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnSalidaVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}