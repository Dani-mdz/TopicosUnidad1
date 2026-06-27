package Visual;

import Clases.Auto;
import Clases.GestorDatos;
import Clases.Servicios;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class SalidaVehiculo extends javax.swing.JFrame {

    private Auto autoActivo = null;
    private GestorDatos.Orden ordenActiva = null;
    private DefaultTableModel modeloVenta;

    public SalidaVehiculo() {
        initComponents();
        this.setLocationRelativeTo(null);
        modeloVenta = new DefaultTableModel(new Object[][] {}, new String[] {"DESCRIPCIÓN", "PRECIO"});
        jtVenta.setModel(modeloVenta);
        txtTicket.setFont(new Font("Monospaced", Font.PLAIN, 12));
        configurarTiempoAutomatico();
    }

    private void configurarTiempoAutomatico() {
        Date ahora = new Date();
        jdcFechaSalida.setDate(ahora);
        jdcFechaSalida.setEnabled(false);
        spnHora.setValue(ahora.getHours());
        spnMinuto.setValue(ahora.getMinutes());
        spnHora.setEnabled(false);
        spnMinuto.setEnabled(false);
    }

    public void generarTicketPdf(String contenidoTicket, int numeroOrden) {
        try {
            String fechaHoy = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String rutaDestino = "C:\\Users\\alanm\\OneDrive\\Desktop\\Tickets\\" + fechaHoy;
            File directorioDia = new File(rutaDestino);
            if (!directorioDia.exists()) directorioDia.mkdirs(); 
            
            File archivoPdf = new File(directorioDia, "Ticket_Orden_" + numeroOrden + ".pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(archivoPdf));
            documento.open();
            
            com.lowagie.text.Font fuenteTicket = com.lowagie.text.FontFactory.getFont(com.lowagie.text.FontFactory.COURIER, 10);
            for (String linea : contenidoTicket.split("\n")) {
                documento.add(new Paragraph(linea, fuenteTicket));
            }
            documento.close();
            if (Desktop.isDesktopSupported()) Desktop.getDesktop().open(archivoPdf);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al generar PDF: " + ex.getMessage());
        }
    }

    private String centrarLinea(String texto, int ancho) {
        if (texto == null || texto.length() >= ancho) return texto;
        int espacios = (ancho - texto.length()) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < espacios; i++) sb.append(" ");
        sb.append(texto);
        return sb.toString();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTicket = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        txtTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder("TELEFONO"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 254;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        jPanel1.add(txtTelefono, gridBagConstraints);

        btnVerificar.setText("VERIFICAR");
        btnVerificar.addActionListener(this::btnVerificarActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        jPanel1.add(btnVerificar, gridBagConstraints);

        btnTicket.setText("GENERAR TICKET");
        btnTicket.addActionListener(this::btnTicketActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        jPanel1.add(btnTicket, gridBagConstraints);

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        jPanel1.add(btnRegresar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 14, 0, 0);
        jPanel1.add(spnHora, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 17, 0, 0);
        jPanel1.add(spnMinuto, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 190;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        jPanel1.add(jdcFechaSalida, gridBagConstraints);

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 478;
        gridBagConstraints.ipady = 380;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(36, 6, 6, 65);
        jPanel1.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        txtTicket.setColumns(20);
        txtTicket.setRows(5);
        jScrollPane1.setViewportView(txtTicket);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 394;
        gridBagConstraints.ipady = 535;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(32, 7, 7, 34);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 25);
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed

        String telBuscado = txtTelefono.getText().replaceAll("[^\\d]", "");
        boolean encontrado = false;
        
        // Limpiamos tabla antes de buscar
        modeloVenta.setRowCount(0);
        
        for (GestorDatos.Orden o : GestorDatos.obtenerOrdenesPendientes()) {
            String telOrden = o.getAuto().getTelefono().replaceAll("[^\\d]", "");
            
            if (telOrden.equals(telBuscado)) {
                this.ordenActiva = o;
                for (Servicios s : o.getServicios()) {
                    modeloVenta.addRow(new Object[]{s.getNombre(), s.getCosto()});
                }
                
                encontrado = true;
                JOptionPane.showMessageDialog(this, "Orden encontrada. Servicios cargados.");
                break;
            }
        }
        
        if (!encontrado) {
            this.ordenActiva = null;
            JOptionPane.showMessageDialog(this, "No se encontró orden pendiente para este teléfono.");
        }
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketActionPerformed
        // TODO add your handling code here
        if (ordenActiva == null) { 
            JOptionPane.showMessageDialog(this, "Verifique primero."); 
            return; 
        }
        
        StringBuilder sb = new StringBuilder();
        double total = 0;
        sb.append("--- TICKET DE SALIDA ---\n");
        sb.append("ORDEN: ").append(ordenActiva.getNumeroOrden()).append("\n\n");
        
        for (int i = 0; i < modeloVenta.getRowCount(); i++) {
            String desc = modeloVenta.getValueAt(i, 0).toString();
            // Limpiamos el formato por si el string tiene signos de pesos
            double precio = Double.parseDouble(modeloVenta.getValueAt(i, 1).toString().replace("$", ""));
            sb.append(String.format("%-25s $%.2f\n", desc, precio));
            total += precio;
        }
        sb.append("------------------------\nTOTAL: $").append(String.format("%.2f", total));
        
        txtTicket.setText(sb.toString());
        generarTicketPdf(sb.toString(), ordenActiva.getNumeroOrden());
        
        // Opcional: Si quieres que la orden desaparezca tras imprimir el ticket:
        // GestorDatos.eliminarOrden(ordenActiva);
        // modeloVenta.setRowCount(0);
        // ordenActiva = null;
    }//GEN-LAST:event_btnTicketActionPerformed

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
                java.util.logging.Logger.getLogger(SalidaVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new SalidaVehiculo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnTicket;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcFechaSalida;
    private javax.swing.JTable jtVenta;
    private javax.swing.JSpinner spnHora;
    private javax.swing.JSpinner spnMinuto;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextArea txtTicket;
    // End of variables declaration//GEN-END:variables
}