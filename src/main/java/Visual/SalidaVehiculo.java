package Visual;

import Clases.Auto;
import Clases.GestorDatos;
import Clases.Servicios;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class SalidaVehiculo extends javax.swing.JFrame {

    private DefaultTableModel modeloVenta;
    private Auto autoActivo = null; 

    public SalidaVehiculo() {
        initComponents();
        this.setLocationRelativeTo(null);
        configurarFechaHora();
        inicializarTabla();
        configurarSelectorClientes();
    }

    private void configurarFechaHora() {
        Date ahora = new Date();
        jdcFechaSalida.setDate(ahora);
        jdcFechaSalida.setEnabled(false);
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(ahora);
        
        spnHora.setModel(new SpinnerNumberModel(cal.get(Calendar.HOUR_OF_DAY), 0, 23, 1));
        spnHora.setEnabled(false);
        spnMinuto.setModel(new SpinnerNumberModel(cal.get(Calendar.MINUTE), 0, 59, 1));
        spnMinuto.setEnabled(false);
    }

    private void inicializarTabla() {
        modeloVenta = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Categoría / Servicio", "Precio Unitario", "Precio Total" }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jtVenta.setModel(modeloVenta);
    }
    
    private void configurarSelectorClientes() {
    // Llena el combo con todos los clientes ya registrados
    DefaultComboBoxModel<Auto> modelo = new DefaultComboBoxModel<>();
    modelo.addElement(null); // opción vacía para no seleccionar a nadie
    for (Auto auto : GestorDatos.obtenerListaClientes()) {
        modelo.addElement(auto);
    }
    jcbClienteRegistrado.setModel(modelo);

    // Muestra "Nombre Apellido - Telefono" en vez del toString() por defecto
    jcbClienteRegistrado.setRenderer(new DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value == null) {
                setText("-- Seleccione un cliente --");
            } else {
                Auto auto = (Auto) value;
                String nombreCompleto = (auto.getCliente() != null) ? auto.getCliente().toString() : "Sin nombre";
                setText(nombreCompleto + " - " + auto.getTelefono());
            }
            return this;
        }
    });

    // Al elegir un cliente del combo, autollena el telefono y dispara el mismo "Verificar"
    jcbClienteRegistrado.addActionListener((java.awt.event.ActionEvent e) -> {
        Auto seleccionado = (Auto) jcbClienteRegistrado.getSelectedItem();
        if (seleccionado != null) {
            txtTelefono.setText(seleccionado.getTelefono());
            btnVerificarActionPerformed(e);
        }
    });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTelefono = new javax.swing.JTextField();
        btnVerificar = new javax.swing.JButton();
        btnTicket = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        spnHora = new javax.swing.JSpinner();
        spnMinuto = new javax.swing.JSpinner();
        jdcFechaSalida = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtVenta = new javax.swing.JTable();
        jcbClienteRegistrado = new javax.swing.JComboBox<>();
        btnRegistrarSalida = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTicket = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(235, 245, 251));

        txtTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder("TELEFONO"));

        btnVerificar.setText("VERIFICAR");
        btnVerificar.addActionListener(this::btnVerificarActionPerformed);

        btnTicket.setText("GENERAR TICKET");
        btnTicket.addActionListener(this::btnTicketActionPerformed);

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);

        jtVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtVenta);

        btnRegistrarSalida.setText("Registrar Salida");
        btnRegistrarSalida.addActionListener(this::btnRegistrarSalidaActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelefono)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(spnHora, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(spnMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnVerificar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRegresar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegistrarSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbClienteRegistrado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerificar)
                    .addComponent(btnRegresar)
                    .addComponent(btnTicket)
                    .addComponent(jcbClienteRegistrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarSalida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdcFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(235, 245, 251));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTicket.setColumns(20);
        txtTicket.setRows(5);
        jScrollPane1.setViewportView(txtTicket);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
String telefonoBuscar = txtTelefono.getText().trim();
    Auto autoEncontrado = GestorDatos.buscarPorTelefono(telefonoBuscar);
    
    if (autoEncontrado != null) {
        this.autoActivo = autoEncontrado;
        
        // 1. Limpiar la tabla por si había datos de una consulta anterior
        modeloVenta.setRowCount(0);
        
        // 2. Buscar la orden para conseguir sus servicios
        GestorDatos.Orden ordenActiva = null;
        for (GestorDatos.Orden orden : GestorDatos.obtenerOrdenesPendientes()) {
            if (orden.getAuto().getTelefono().equals(autoActivo.getTelefono())) {
                ordenActiva = orden;
                break;
            }
        }
        
        // 3. Si encontramos la orden, llenamos la tabla de la interfaz
        if (ordenActiva != null) {
            for (Clases.Servicios servicio : ordenActiva.getServiciosAplicados()) {
                Object[] fila = new Object[]{
                    servicio.getNombreServicio(), // Columna 1: Nombre
                    servicio.getCosto(),          // Columna 2: Precio Unitario
                    servicio.getCosto()           // Columna 3: Precio Total (o tu variable de total)
                };
                modeloVenta.addRow(fila); // Agrega la fila a la tabla visual
            }
        }
        
        javax.swing.JOptionPane.showMessageDialog(this, "Vehículo localizado: " + autoActivo.getMarca() + " " + autoActivo.getModelo());
    } else {
        this.autoActivo = null;
        modeloVenta.setRowCount(0); // Limpia si no hay resultados
        javax.swing.JOptionPane.showMessageDialog(this, "No se encontró ningún vehículo con ese número de teléfono.");
    }
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketActionPerformed
        // TODO add your handling code here:
if (autoActivo == null) {
        JOptionPane.showMessageDialog(this, "Verifique un vehículo por teléfono antes de generar el ticket.");
        return;
    }

    // 1. Buscar la orden del cliente en las órdenes pendientes
    GestorDatos.Orden ordenActiva = null;
    for (GestorDatos.Orden orden : GestorDatos.obtenerOrdenesPendientes()) {
        if (orden.getAuto().getTelefono().equals(autoActivo.getTelefono())) {
            ordenActiva = orden;
            break;
        }
    }

    if (ordenActiva == null) {
        JOptionPane.showMessageDialog(this, "No se encontró una orden activa para este vehículo.");
        return;
    }

    // 2. Estilos del ticket físico
    String lineaGruesa = "=========================================\n";
    String lineaFina   = "-----------------------------------------\n";
    StringBuilder ticket = new StringBuilder();
    
    // Encabezado
    ticket.append(lineaGruesa);
    ticket.append("       AUTOLAVADO EL RAYO MCQUEEN        \n");
    ticket.append("  \"Cuchau! Limpios en un abrir y cerrar\" \n");
    ticket.append(lineaGruesa);
    
    // Número de orden automático, fecha limpia y hora con formato 00:00
    ticket.append(String.format("TICKET #: %04d\n", ordenActiva.getNumeroOrden()));
    ticket.append(String.format("FECHA: %-15s  HORA: %02d:%02d\n", 
            new java.text.SimpleDateFormat("dd/MM/yyyy").format(jdcFechaSalida.getDate()), 
            spnHora.getValue(), spnMinuto.getValue()));
    ticket.append(lineaFina);
    
    // Datos del Cliente y Vehículo
    ticket.append("TELÉFONO : ").append(autoActivo.getTelefono()).append("\n");
    ticket.append("VEHÍCULO : ").append(autoActivo.getMarca()).append(" ").append(autoActivo.getModelo()).append("\n");
    ticket.append("COLOR    : ").append(autoActivo.getColor()).append("\n");
    ticket.append(lineaGruesa);
    
    // Encabezado de la tabla de costos
    ticket.append(String.format("%-28s %11s\n", "DESCRIPCIÓN", "PRECIO"));
    ticket.append(lineaFina);
    
    // 3. RECORRER Y RECOGER LOS PRECIOS REALES
    // Este ciclo lee cada servicio aplicado y pone su nombre y costo real alineados
    for (Servicios servicio : ordenActiva.getServiciosAplicados()) {
        ticket.append(String.format("%-28s $%10.2f\n", servicio.getNombreServicio(), servicio.getCosto()));
    }
    
    ticket.append(lineaFina);
    
    // Total Real de la orden
    ticket.append(String.format("%-28s $%10.2f\n", "TOTAL A PAGAR:", ordenActiva.getTotalCosto()));
    ticket.append(lineaGruesa);
    
    // Despedida
    ticket.append("       ¡GRACIAS POR SU PREFERENCIA!      \n");
    ticket.append("             ¡REGRESE PRONTO!            \n");
    ticket.append(lineaGruesa);

    // Estampar todo en el JTextArea
    txtTicket.setText(ticket.toString());
    }//GEN-LAST:event_btnTicketActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarSalidaActionPerformed
        // TODO add your handling code here:
        
    if (autoActivo == null) {
        JOptionPane.showMessageDialog(this, "Verifique un vehículo por teléfono antes de registrar la salida.");
        return;
    }

    GestorDatos.Orden ordenActiva = null;
    for (GestorDatos.Orden orden : GestorDatos.obtenerOrdenesPendientes()) {
        if (orden.getAuto().getTelefono().equals(autoActivo.getTelefono())) {
            ordenActiva = orden;
            break;
        }
    }

    if (ordenActiva == null) {
        JOptionPane.showMessageDialog(this, "No se encontró una orden activa para este vehículo.");
        return;
    }

    GestorDatos.eliminarOrdenPendiente(ordenActiva.getNumeroOrden());

    JOptionPane.showMessageDialog(this, "Salida registrada con éxito.");

    autoActivo = null;
    txtTelefono.setText("");
    txtTicket.setText("");
    modeloVenta.setRowCount(0);
    configurarSelectorClientes();
    
    }//GEN-LAST:event_btnRegistrarSalidaActionPerformed

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
                java.util.logging.Logger.getLogger(SalidaVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new SalidaVehiculo().setVisible(true));
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarSalida;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnTicket;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<Clases.Auto> jcbClienteRegistrado;
    private com.toedter.calendar.JDateChooser jdcFechaSalida;
    private javax.swing.JTable jtVenta;
    private javax.swing.JSpinner spnHora;
    private javax.swing.JSpinner spnMinuto;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextArea txtTicket;
    // End of variables declaration//GEN-END:variables
}