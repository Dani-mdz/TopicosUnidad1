package Visual;

import Clases.Auto;
import Clases.GestorDatos;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Registro extends javax.swing.JFrame {

    private Auto autoEdicion = null;

    public Registro() {
        initComponents();
        this.setLocationRelativeTo(null);
        configurarRestricciones();
        txtIdCliente.setEnabled(false);
        txtIdCliente.setText(String.valueOf(GestorDatos.generarSiguienteIdCliente()));
    }

    public Registro(Auto auto) {
        initComponents();
        this.setLocationRelativeTo(null);
        configurarRestricciones();
        this.autoEdicion = auto;
        
        txtIdCliente.setEnabled(false);
        if (auto.getCliente() != null) {
            txtIdCliente.setText(String.valueOf(auto.getCliente().getIdCliente()));
            txtNombre.setText(auto.getCliente().getNombre());
            txtApellido.setText(auto.getCliente().getApellido());
        }
        
        txtTelefono.setText(auto.getTelefono());
        txtMarca.setText(auto.getMarca());
        txtModelo.setText(auto.getModelo());
        txtColor.setText(auto.getColor());
        txtObservaciones.setText(auto.getObservaciones());
        jcbVehiculo.setSelectedItem(auto.getTipoVehiculo()); 
    }

    private void configurarRestricciones() {
        ((AbstractDocument) txtTelefono.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);
                
                String digitsOnly = newText.replaceAll("\\D", "");
                
                if (digitsOnly.length() > 10) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < digitsOnly.length(); i++) {
                    sb.append(digitsOnly.charAt(i));
                    if (i == 2 && digitsOnly.length() > 3) {
                        sb.append(" - ");
                    }
                    if (i == 5 && digitsOnly.length() > 6) {
                        sb.append(" - ");
                    }
                }
                fb.replace(0, fb.getDocument().getLength(), sb.toString(), attrs);
            }
            
            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
         
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = currentText.substring(0, offset) + currentText.substring(offset + length);
                String digitsOnly = newText.replaceAll("\\D", "");
                
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < digitsOnly.length(); i++) {
                    sb.append(digitsOnly.charAt(i));
                    if (i == 2 && digitsOnly.length() > 3) {
                        sb.append(" - ");
                    }
                    if (i == 5 && digitsOnly.length() > 6) {
                        sb.append(" - ");
                    }
                }
                fb.replace(0, fb.getDocument().getLength(), sb.toString(), null);
            }
        });

        KeyAdapter soloLetras = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' && c != KeyEvent.VK_BACK_SPACE) {
                    evt.consume();
                }
            }
        };

        txtNombre.addKeyListener(soloLetras);
        txtApellido.addKeyListener(soloLetras);
        txtMarca.addKeyListener(soloLetras);
        txtColor.addKeyListener(soloLetras);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblIdCliente = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblVehiculo = new javax.swing.JLabel();
        jcbVehiculo = new javax.swing.JComboBox<>();
        lblMarca = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS CLIENTE"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblNombre.setText("NOMBRE:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 19, 0, 0);
        jPanel1.add(lblNombre, gridBagConstraints);

        lblApellido.setText("APELLIDO:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 19, 0, 0);
        jPanel1.add(lblApellido, gridBagConstraints);

        lblIdCliente.setText("ID CLIENTE:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 19, 0, 0);
        jPanel1.add(lblIdCliente, gridBagConstraints);

        lblTelefono.setText("TELEFONO:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 19, 0, 0);
        jPanel1.add(lblTelefono, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 6, 0, 0);
        jPanel1.add(txtIdCliente, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 132;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 465);
        jPanel1.add(txtNombre, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 132;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 465);
        jPanel1.add(txtApellido, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 132;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 11, 465);
        jPanel1.add(txtTelefono, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS VEHICULO"));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lblVehiculo.setText("VEHICULO:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 11, 0, 0);
        jPanel2.add(lblVehiculo, gridBagConstraints);

        jcbVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Automovil", "Camioneta", "Motocicleta", "Motoneta" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 6, 0, 0);
        jPanel2.add(jcbVehiculo, gridBagConstraints);

        lblMarca.setText("MARCA:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 11, 0, 0);
        jPanel2.add(lblMarca, gridBagConstraints);

        lblModelo.setText("MODELO:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 11, 0, 0);
        jPanel2.add(lblModelo, gridBagConstraints);

        lblColor.setText("COLOR:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 11, 0, 0);
        jPanel2.add(lblColor, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 112;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
        jPanel2.add(txtMarca, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 112;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 6, 0, 0);
        jPanel2.add(txtModelo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 112;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 6, 0, 0);
        jPanel2.add(txtColor, gridBagConstraints);

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        txtObservaciones.setBorder(javax.swing.BorderFactory.createTitledBorder("OBSERVACIONES"));
        jScrollPane1.setViewportView(txtObservaciones);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 698;
        gridBagConstraints.ipady = 87;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 11, 21, 34);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 340, 0, 0);
        jPanel2.add(btnGuardar, gridBagConstraints);

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 340, 0, 0);
        jPanel2.add(btnLimpiar, gridBagConstraints);

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 340, 0, 0);
        jPanel2.add(btnRegresar, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String marca = txtMarca.getText().trim();
        String modelo = txtModelo.getText().trim();
        String color = txtColor.getText().trim();
        String observaciones = txtObservaciones.getText().trim();
        String tipoVehiculo = jcbVehiculo.getSelectedItem().toString();

        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || marca.isEmpty() || modelo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellena todos los campos", "Error de Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (autoEdicion == null) {
            if (GestorDatos.buscarPorTelefono(telefono) != null) {
                JOptionPane.showMessageDialog(this, "Error", "Ya existe un vehículo registrado con este numero", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int nuevoId = Integer.parseInt(txtIdCliente.getText());
            Auto nuevoAuto = new Auto(nuevoId, marca, modelo, color, observaciones, telefono);
            if (nuevoAuto.getCliente() != null) {
                nuevoAuto.getCliente().setNombre(nombre);
                nuevoAuto.getCliente().setApellido(apellido);
            }
            nuevoAuto.setTipoVehiculo(tipoVehiculo);
            GestorDatos.agregarCliente(nuevoAuto);
            JOptionPane.showMessageDialog(this, "Vehículo y cliente registrados");
        } else {
            if (autoEdicion.getCliente() != null) {
                autoEdicion.getCliente().setNombre(nombre);
                autoEdicion.getCliente().setApellido(apellido);
            }
            autoEdicion.setTelefono(telefono);
            autoEdicion.setMarca(marca);
            autoEdicion.setModelo(modelo);
            autoEdicion.setColor(color);
            autoEdicion.setObservaciones(observaciones);
            autoEdicion.setTipoVehiculo(tipoVehiculo);
            GestorDatos.actualizarRegistro(autoEdicion);
            JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.");
        }
        new ListaClientes().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtColor.setText("");
        txtObservaciones.setText("");
        jcbVehiculo.setSelectedIndex(0);
        
        // Si no estamos editando, reasignar el Id
        if (autoEdicion == null) {
            txtIdCliente.setText(String.valueOf(GestorDatos.generarSiguienteIdCliente()));
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new Registro().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbVehiculo;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblVehiculo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}