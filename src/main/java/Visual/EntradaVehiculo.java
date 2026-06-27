package Visual;

import Clases.Auto;
import Clases.GestorDatos;
import Clases.Servicios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class EntradaVehiculo extends javax.swing.JFrame {

    private final ArrayList<Servicios> serviciosActuales = new ArrayList<>();
    private Auto autoActivo = null;

    public EntradaVehiculo() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        // --- INICIALIZACIONES ---
        configurarBloqueoEdicion();
        configurarRestriccionesTelefono();
        inicializarComponentesPorDefecto();
        
        // --- OBLIGATORIO: Lógica de eventos para cálculos ---
        configurarEventosCalculo();
    }

    private void configurarBloqueoEdicion() {
        txtMarca.setEditable(false);
        txtModelo.setEditable(false);
        txtColor.setEditable(false);
        txtReferencia.setEditable(false);
        jdcFechaEntrada.setEnabled(false);
        spnHora.setEnabled(false);
        spnMinuto.setEnabled(false);
    }

    private void configurarRestriccionesTelefono() {
        ((AbstractDocument) txtTelefono.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()).substring(0, offset) + text;
                if (newText.replaceAll("[^\\d]", "").length() <= 10) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }

    private void inicializarComponentesPorDefecto() {
        txtNumeroOrden.setText(String.valueOf(GestorDatos.obtenerSiguienteNumeroOrden()));
        txtNumeroOrden.setEditable(false);
        Date ahora = new Date();
        jdcFechaEntrada.setDate(ahora);
        spnHora.setValue(ahora.getHours());
        spnMinuto.setValue(ahora.getMinutes());
        
        // Agrupar los JRadioButton para que solo se seleccione uno a la vez
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(jrbExpress);
        grupo.add(jrbBasico);
        grupo.add(jrbDetallado);
    }
    
    private void limpiarCampos() {
        txtMarca.setText("-");
        txtModelo.setText("-");
        txtColor.setText("-");
        txtReferencia.setText("");
        txtComentarios.setText("");
    }

    private void configurarEventosCalculo() {
        ActionListener calculador = (ActionEvent e) -> calcularPreciosEnTiempoReal();
        
        // Añadir listeners a botones y checkboxes
        jrbExpress.addActionListener(calculador);
        jrbBasico.addActionListener(calculador);
        jrbDetallado.addActionListener(calculador);
        jcbLavadoMotor.addActionListener(calculador);
        jcbAire.addActionListener(calculador);
        jcbChasis.addActionListener(calculador);
        jcbNiveles.addActionListener(calculador);
        jcbPulido.addActionListener(calculador);
        jcbPañoMicrofibra.addActionListener(calculador);
        jcbAromatizante.addActionListener(calculador);
        jcbLimpiaparabrisas.addActionListener(calculador);
    }

    private void calcularPreciosEnTiempoReal() {
        serviciosActuales.clear();
        double total = 0;
        double precioPrincipal = 0; 

        if (jrbExpress.isSelected()) {
            precioPrincipal = 90;
            agregarServicio(90, "Express", "Servicio");
            total += 90;
            txtDescripcion.setText("• Lavado exterior rápido");
        } else if (jrbBasico.isSelected()) {
            precioPrincipal = 180;
            agregarServicio(180, "Básico", "Servicio");
            total += 180;
            txtDescripcion.setText("• Lavado de carrocería y rines\n• Aspirado completo de interiores\n• Limpieza profunda de tablero");
        } else if (jrbDetallado.isSelected()) {
            precioPrincipal = 950;
            agregarServicio(950, "Detallado", "Servicio");
            total += 950;
            txtDescripcion.setText("• Lavado premium\n• Motor y chasis\n• Pulido y encerado");
        }

        // Suma de extras
        if (jcbLavadoMotor.isSelected()) { agregarServicio(250, "Lavado de Motor", "Extra"); total += 250; }
        if (jcbAire.isSelected()) { agregarServicio(15, "Aire llantas", "Extra"); total += 15; }
        if (jcbChasis.isSelected()) { agregarServicio(150, "Lavado Chasis", "Extra"); total += 150; }
        if (jcbNiveles.isSelected()) { agregarServicio(10, "Verificar Niveles", "Extra"); total += 10; }
        if (jcbPulido.isSelected()) { agregarServicio(950, "Pulido y Encerado", "Extra"); total += 950; }
        if (jcbPañoMicrofibra.isSelected()) { agregarServicio(30, "Paño Microfibra", "Producto"); total += 30; }
        if (jcbAromatizante.isSelected()) { agregarServicio(80, "Aromatizante", "Producto"); total += 80; }
        if (jcbLimpiaparabrisas.isSelected()) { agregarServicio(80.0, "Limpia Parabrisas", "Producto"); total += 80; }

        txtPrecioUnitario.setText("$" + String.format("%.2f", precioPrincipal));
        txtPrecioFinal.setText(String.format("%.2f", total));
    }

    private void agregarServicio(double costo, String nombre, String tipo) {
        serviciosActuales.add(new Servicios(0, nombre, costo, tipo));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        txtTelefono = new javax.swing.JTextField();
        btnRellenar = new javax.swing.JButton();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtReferencia = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jrbExpress = new javax.swing.JRadioButton();
        jrbBasico = new javax.swing.JRadioButton();
        jrbDetallado = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jcbLavadoMotor = new javax.swing.JCheckBox();
        jcbNiveles = new javax.swing.JCheckBox();
        jcbAire = new javax.swing.JCheckBox();
        jcbPulido = new javax.swing.JCheckBox();
        jcbChasis = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jcbPañoMicrofibra = new javax.swing.JCheckBox();
        jcbAromatizante = new javax.swing.JCheckBox();
        jcbLimpiaparabrisas = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        txtPrecioFinal = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        txtNumeroOrden = new javax.swing.JTextField();
        btnRegistrarE = new javax.swing.JButton();
        txtPrecioUnitario = new javax.swing.JTextField();
        jcbTipoPago = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComentarios = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        spnHora = new javax.swing.JSpinner();
        spnMinuto = new javax.swing.JSpinner();
        jdcFechaEntrada = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS CLIENTE"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        txtTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder("TELEFONO"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 116;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 11, 0, 0);
        jPanel1.add(txtTelefono, gridBagConstraints);

        btnRellenar.setText("RELLENAR");
        btnRellenar.addActionListener(this::btnRellenarActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 12, 0, 0);
        jPanel1.add(btnRellenar, gridBagConstraints);

        txtMarca.setBorder(javax.swing.BorderFactory.createTitledBorder("MARCA"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 86;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 24, 0, 0);
        jPanel1.add(txtMarca, gridBagConstraints);

        txtModelo.setBorder(javax.swing.BorderFactory.createTitledBorder("MODELO"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 86;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 18, 0, 0);
        jPanel1.add(txtModelo, gridBagConstraints);

        txtColor.setBorder(javax.swing.BorderFactory.createTitledBorder("COLOR"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 66;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 18, 0, 11);
        jPanel1.add(txtColor, gridBagConstraints);

        txtReferencia.setBorder(javax.swing.BorderFactory.createTitledBorder("REFERENCIA"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 707;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 11, 11);
        jPanel1.add(txtReferencia, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("SERVICIO DE LAVADO"));

        jrbExpress.setText("EXPRESS");

        jrbBasico.setText("BASICO");

        jrbDetallado.setText("DETALLADO");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbBasico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbDetallado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jrbExpress)
                        .addGap(12, 12, 12)
                        .addComponent(jrbBasico)
                        .addGap(12, 12, 12)
                        .addComponent(jrbDetallado)))
                .addGap(137, 137, 137))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("SERVICIOS EXTRA"));

        jcbLavadoMotor.setText("LAVADO DE MOTOR");

        jcbNiveles.setText("VERIFICAR NIVELES");

        jcbAire.setText("AIRE PARA LLANTAS");

        jcbPulido.setText("PULIDO Y ENCERADO");

        jcbChasis.setText("LAVADO DE CHASIS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbLavadoMotor)
                    .addComponent(jcbAire)
                    .addComponent(jcbChasis)
                    .addComponent(jcbNiveles)
                    .addComponent(jcbPulido))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbLavadoMotor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbAire)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbChasis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbNiveles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbPulido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("PRODUCTOS ADICIONALES"));

        jcbPañoMicrofibra.setText("PAÑO DE MICROFIBRA");

        jcbAromatizante.setText("AROMATIZANTE");

        jcbLimpiaparabrisas.setText("LIMPIA PARABRISAS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbPañoMicrofibra)
                    .addComponent(jcbAromatizante)
                    .addComponent(jcbLimpiaparabrisas))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbPañoMicrofibra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbAromatizante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbLimpiaparabrisas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("COSTO"));

        txtPrecioFinal.setBorder(javax.swing.BorderFactory.createTitledBorder("PRECIO FINAL"));

        btnRegresar.setBackground(new java.awt.Color(153, 204, 255));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);

        txtNumeroOrden.setBorder(javax.swing.BorderFactory.createTitledBorder("NUMERO DE ORDEN"));

        btnRegistrarE.setBackground(new java.awt.Color(153, 255, 153));
        btnRegistrarE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistrarE.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarE.setText("REGISTRAR ENTRADA");
        btnRegistrarE.addActionListener(this::btnRegistrarEActionPerformed);

        txtPrecioUnitario.setBorder(javax.swing.BorderFactory.createTitledBorder("PRECIO UNITARIO"));

        jcbTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "TARJETA", "TRANFERENCIA" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("TIPO DE PAGO:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumeroOrden)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRegistrarE)
                                    .addComponent(jcbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtPrecioFinal)
                            .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNumeroOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnRegistrarE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("COMENTARIOS / SOLICITUDES"));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        txtComentarios.setColumns(20);
        txtComentarios.setRows(5);
        jScrollPane2.setViewportView(txtComentarios);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 294;
        gridBagConstraints.ipady = 165;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 11, 11, 11);
        jPanel6.add(jScrollPane2, gridBagConstraints);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("ENTRADA"));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(spnHora, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(spnMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jdcFechaEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdcFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 337, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(96, 96, 96)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRellenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRellenarActionPerformed
        // TODO add your handling code here:
        String telefonoBuscar = txtTelefono.getText().trim();
        Auto autoEncontrado = GestorDatos.buscarPorTelefono(telefonoBuscar);

        if (autoEncontrado != null) {
            this.autoActivo = autoEncontrado;
            txtMarca.setText(autoActivo.getMarca());
            txtModelo.setText(autoActivo.getModelo());
            txtColor.setText(autoActivo.getColor());
            
            // La referencia se llena, pero txtComentarios se mantiene libre para el usuario
            txtReferencia.setText(autoActivo.getObservaciones());
            
            JOptionPane.showMessageDialog(this, "Cliente y vehículo localizados con éxito.");
        } else {
            this.autoActivo = null;
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "No se encontró cliente con el teléfono: " + telefonoBuscar);
        }
    }//GEN-LAST:event_btnRellenarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEActionPerformed
        // TODO add your handling code here:
        if (autoActivo == null) {
            JOptionPane.showMessageDialog(this, "Debe buscar y validar un cliente activo primero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Extraer datos y limpiar formato para guardar
            int numOrden = Integer.parseInt(txtNumeroOrden.getText());
            double totalCosto = 0.0;
            
            String textoFinal = txtPrecioFinal.getText().replace("$", "").replace(",", "").trim();
            if (!textoFinal.isEmpty()) {
                totalCosto = Double.parseDouble(textoFinal);
            }
            
            String fechaEntrada = (jdcFechaEntrada.getDate() != null) ? jdcFechaEntrada.getDate().toString() : new Date().toString();

            // Crear el objeto Orden 
            GestorDatos.Orden nuevaOrden = new GestorDatos.Orden(
                numOrden, 
                autoActivo, 
                new ArrayList<>(serviciosActuales), 
                totalCosto, 
                fechaEntrada
            );

            // Registrar en el GestorDatos
            GestorDatos.registrarOrden(nuevaOrden);

            JOptionPane.showMessageDialog(this, "Entrada del vehículo registrada correctamente.");
            btnRegresarActionPerformed(null);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al procesar los datos de la orden. Revise el costo y número de orden.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarEActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntradaVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new EntradaVehiculo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarE;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRellenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox jcbAire;
    private javax.swing.JCheckBox jcbAromatizante;
    private javax.swing.JCheckBox jcbChasis;
    private javax.swing.JCheckBox jcbLavadoMotor;
    private javax.swing.JCheckBox jcbLimpiaparabrisas;
    private javax.swing.JCheckBox jcbNiveles;
    private javax.swing.JCheckBox jcbPañoMicrofibra;
    private javax.swing.JCheckBox jcbPulido;
    private javax.swing.JComboBox<String> jcbTipoPago;
    private com.toedter.calendar.JDateChooser jdcFechaEntrada;
    private javax.swing.JRadioButton jrbBasico;
    private javax.swing.JRadioButton jrbDetallado;
    private javax.swing.JRadioButton jrbExpress;
    private javax.swing.JSpinner spnHora;
    private javax.swing.JSpinner spnMinuto;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextArea txtComentarios;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumeroOrden;
    private javax.swing.JTextField txtPrecioFinal;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}