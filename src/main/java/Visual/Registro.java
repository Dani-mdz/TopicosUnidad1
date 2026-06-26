package Visual;

import Clases.Auto;
import Clases.GestorDatos;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Registro extends javax.swing.JFrame {

    private Auto autoEdicion = null;
    public Registro() {
        initComponents();
        this.setLocationRelativeTo(null);
        configurarRestricciones();        
        // id automatico
        txtIdCliente.setEnabled(false);
        txtIdCliente.setText(String.valueOf(GestorDatos.generarSiguienteIdCliente()));
    }
    // modificar cliente existente
    public Registro(Auto auto) {
        initComponents();
        this.setLocationRelativeTo(null);
        configurarRestricciones();
        this.autoEdicion = auto;
        // Bloquear ID
        txtIdCliente.setEnabled(false);
        // Rellenar el formulario
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
        
        // Seleccionar tipo de vehículo en el ComboBox si coincide
        jcbVehiculo.setSelectedItem(auto.getTipoVehiculo()); 
    }

    private void configurarRestricciones() {
        // solo numeros en telefono
        txtTelefono.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume(); // Ignora el carácter si no es un dígito
                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        setBackground(new java.awt.Color(235, 245, 251));

        jPanel1.setBackground(new java.awt.Color(235, 245, 251));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS CLIENTE"));

        lblNombre.setText("NOMBRE:");

        lblApellido.setText("APELLIDO:");

        lblIdCliente.setText("ID CLIENTE:");

        lblTelefono.setText("TELEFONO:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdCliente)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(235, 245, 251));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS VEHICULO"));

        lblVehiculo.setText("VEHICULO:");

        jcbVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Automovil", "Camioneta", "Motocicleta", "Motoneta" }));

        lblMarca.setText("MARCA:");

        lblModelo.setText("MODELO:");

        lblColor.setText("COLOR:");

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        txtObservaciones.setBorder(javax.swing.BorderFactory.createTitledBorder("OBSERVACIONES"));
        jScrollPane1.setViewportView(txtObservaciones);

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblColor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblModelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(lblMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(txtModelo)
                                    .addComponent(txtColor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVehiculo)
                            .addComponent(jcbVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMarca)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblModelo)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblColor)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegresar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
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

        // validacion cliente y vehiculo
        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || marca.isEmpty() || modelo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellena todos los campos", "Error de Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (autoEdicion == null) {
            // registro nuevo
            if (GestorDatos.buscarPorTelefono(telefono) != null) {
                JOptionPane.showMessageDialog(this, "Ya existe un vehículo registrado con este numero", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int nuevoId = Integer.parseInt(txtIdCliente.getText());
            Auto nuevoAuto = new Auto(nuevoId, marca, modelo, color, observaciones, telefono);
            // asignar datos cliente a auto
            if (nuevoAuto.getCliente() != null) {
                nuevoAuto.getCliente().setNombre(nombre);
                nuevoAuto.getCliente().setApellido(apellido);
            }
            nuevoAuto.setTipoVehiculo(tipoVehiculo);

            GestorDatos.agregarCliente(nuevoAuto);
            JOptionPane.showMessageDialog(this, "vehiculo y cliente registrados");
            
        } else {
            // editar / modificar
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
        // Regresar automáticamente a la lista de clientes para ver los cambios
        ListaClientes lc = new ListaClientes();
        lc.setVisible(true);
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