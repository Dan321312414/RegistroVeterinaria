
package Vista;

import Controlador.MascotaController;
import Modelo.DatabaseConnection;
import Modelo.Mascota;
import Modelo.QRGenerator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VeterinariaVacunasGUI extends javax.swing.JFrame {
    
    private DefaultTableModel model;
    
    public VeterinariaVacunasGUI() {
        initComponents();
         setLocationRelativeTo(null);
       
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{
            "ID", "Nombre", "Tipo de Mascota", "Raza", "Color de Pelaje", "Edad", 
            "Nombre del Dueño", "DNI del Dueño", "Tipo de Servicio", "Enfermedad", "Vacuna", "Hora de Entrada"
        });

        tableVacunas.setModel(model); 

        
        btnMostrarDatos.addActionListener(evt -> cargarDatos());
        
        // Configura el evento de selección de fila en la tabla
        // Agrega un MouseListener a la tabla
    tableVacunas.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tablaMouseClicked(evt);
        }
    });
}
    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {
    int selectedRow = tableVacunas.getSelectedRow();
    if (selectedRow != -1) {
       
        txtNombreMascota.setText(model.getValueAt(selectedRow, 1).toString());
        cbxTipodeMascota.setSelectedItem(model.getValueAt(selectedRow, 2).toString());
        txtRaza.setText(model.getValueAt(selectedRow, 3).toString());
        txtColor.setText(model.getValueAt(selectedRow, 4).toString());
        txtEdad.setText(model.getValueAt(selectedRow, 5).toString());
        txtNombreDueno.setText(model.getValueAt(selectedRow, 6).toString());
        txtDNIDueno.setText(model.getValueAt(selectedRow, 7).toString());
        txtEnfermedad.setText(model.getValueAt(selectedRow, 9).toString());
        cbxVacunas.setSelectedItem(model.getValueAt(selectedRow, 10).toString());
    }
}
    private void cargarDatos() {
      
        model.setRowCount(0);

     
        String query = "SELECT * FROM mascotas WHERE tipoServicio = 'Vacunas'";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

        
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("tipoMascota"),
                    rs.getString("raza"),
                    rs.getString("colorPelaje"),
                    rs.getInt("edad"),
                    rs.getString("nombreDueno"),
                    rs.getString("dniDueno"),
                    rs.getString("tipoServicio"),
                    rs.getString("enfermedad"),
                    rs.getString("vacuna"),
                    rs.getTimestamp("horaEntrada")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage());
        }
    }
    private void limpiarCampos() {
   
    txtNombreMascota.setText("");
    cbxTipodeMascota.setSelectedIndex(0); 
    txtRaza.setText("");
    txtColor.setText("");
    txtEdad.setText("");
    txtNombreDueno.setText("");
    txtDNIDueno.setText("");
    txtEnfermedad.setText("");
    cbxVacunas.setSelectedIndex(0); 
}

   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombreMascota = new javax.swing.JTextField();
        txtRaza = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        cbxTipodeMascota = new javax.swing.JComboBox<>();
        txtColor = new javax.swing.JTextField();
        txtNombreDueno = new javax.swing.JTextField();
        txtDNIDueno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEnfermedad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxVacunas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVacunas = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbxTipoServicio = new javax.swing.JComboBox<>();
        btnMostrarDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        btnRegresar.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(573, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 220, 610));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Microsoft Tai Le", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Guardianes Vet");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(263, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(223, 223, 223))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 100));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel2.setText("NOMBRE DE MASCOTA:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel3.setText("TIPO DE MASCOTA:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel4.setText("RAZA:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel5.setText("EDAD:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel6.setText("COLOR:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel7.setText("NOMBRE DEL DUEÑO:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        jLabel8.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel8.setText("DNI:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        txtNombreMascota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel3.add(txtNombreMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 210, -1));

        txtRaza.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel3.add(txtRaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 210, -1));

        txtEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel3.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 210, -1));

        cbxTipodeMascota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perro", "Gato", "Conejo", "Hamster" }));
        cbxTipodeMascota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel3.add(cbxTipodeMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 210, -1));

        txtColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel3.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 210, -1));

        txtNombreDueno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel3.add(txtNombreDueno, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 210, -1));

        txtDNIDueno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel3.add(txtDNIDueno, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 210, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel9.setText("ENFERMEDAD:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        txtEnfermedad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel3.add(txtEnfermedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 210, -1));

        jLabel10.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel10.setText("VACUNA:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, -1, -1));

        cbxVacunas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vacuna contra el distemper", "Vacuna contra parvovirus", "Vacuna contra la hepatitis infecciosa canina ", "Vacuna contra la leptospirosis", "Vacuna contra la rabia" }));
        cbxVacunas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel3.add(cbxVacunas, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 210, -1));

        tableVacunas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableVacunas);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 790, 200));

        btnRegistrar.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 110, 40));

        btnModificar.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel3.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 120, 50));

        btnEliminar.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 120, 50));

        jLabel11.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel11.setText("TIPO DE SERVICIO:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        cbxTipoServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vacunas" }));
        cbxTipoServicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel3.add(cbxTipoServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 210, 20));

        btnMostrarDatos.setText("Mostrar Datos");
        btnMostrarDatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        btnMostrarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDatosActionPerformed(evt);
            }
        });
        jPanel3.add(btnMostrarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, 100, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 830, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
      // Obtén los datos ingresados en los campos
    String nombre = txtNombreMascota.getText();
    String tipoMascota = (String) cbxTipodeMascota.getSelectedItem();
    String raza = txtRaza.getText();
    String colorPelaje = txtColor.getText();
    int edad = Integer.parseInt(txtEdad.getText());
    String nombreDueno = txtNombreDueno.getText();
    String dniDueno = txtDNIDueno.getText();
    String tipoServicio = "Vacunas";  // Asignar el tipo de servicio basado en el GUI actual
    String enfermedad = txtEnfermedad.getText();
    String vacuna = (String) cbxVacunas.getSelectedItem();

   
    LocalDateTime horaEntrada = LocalDateTime.now();
    LocalDateTime horaSalida;


    if (tipoServicio.equals("Vacunas")) {
        horaSalida = horaEntrada.plusMinutes(30); 
    } else {
        horaSalida = horaEntrada.plusHours(1); 
    }

    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String entradaFormateada = horaEntrada.format(formatter); 
    String salidaFormateada = horaSalida.format(formatter);

   
    try (Connection conn = DatabaseConnection.getConnection()) {
        String query = "INSERT INTO mascotas (nombre, tipoMascota, raza, colorPelaje, edad, nombreDueno, dniDueno, tipoServicio, enfermedad, vacuna, horaEntrada, horaSalida) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, nombre);
        stmt.setString(2, tipoMascota);
        stmt.setString(3, raza);
        stmt.setString(4, colorPelaje);
        stmt.setInt(5, edad);
        stmt.setString(6, nombreDueno);
        stmt.setString(7, dniDueno);
        stmt.setString(8, tipoServicio);
        stmt.setString(9, enfermedad);
        stmt.setString(10, vacuna);
        stmt.setString(11, salidaFormateada); 

        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Registro exitoso.");
            cargarDatos(); 

            
            String qrData = "Nombre: " + nombre + "\n" +
                            "Tipo de Mascota: " + tipoMascota + "\n" +
                            "Raza: " + raza + "\n" +
                            "Color de Pelaje: " + colorPelaje + "\n" +
                            "Edad: " + edad + "\n" +
                            "Nombre del Dueño: " + nombreDueno + "\n" +
                            "DNI del Dueño: " + dniDueno + "\n" +
                            "Tipo de Servicio: " + tipoServicio + "\n" +
                            "Enfermedad: " + enfermedad + "\n" +
                            "Vacuna: " + vacuna + "\n" +
                            "Hora de Entrada: " + entradaFormateada + "\n" + // Añadir hora de entrada
                            "Hora de Salida: " + salidaFormateada;

         
            QRGenerator.generarQRCode(qrData, "QR_Mascota_" + nombre + ".png");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar la mascota.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error en la conexión: " + e.getMessage());
    }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnMostrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDatosActionPerformed
  
        cargarDatos();
    }//GEN-LAST:event_btnMostrarDatosActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int selectedRow = tableVacunas.getSelectedRow();
        if (selectedRow != -1) {
           
            int id = (int) model.getValueAt(selectedRow, 0);

           
            String nombre = txtNombreMascota.getText();
            String tipoMascota = (String) cbxTipodeMascota.getSelectedItem();
            String raza = txtRaza.getText();
            String colorPelaje = txtColor.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String nombreDueno = txtNombreDueno.getText();
            String dniDueno = txtDNIDueno.getText();
            String enfermedad = txtEnfermedad.getText();
            String vacuna = (String) cbxVacunas.getSelectedItem();

           
            try (Connection conn = DatabaseConnection.getConnection()) {
                String query = "UPDATE mascotas SET nombre=?, tipoMascota=?, raza=?, colorPelaje=?, edad=?, nombreDueno=?, dniDueno=?, enfermedad=?, vacuna=? WHERE id=?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, nombre);
                stmt.setString(2, tipoMascota);
                stmt.setString(3, raza);
                stmt.setString(4, colorPelaje);
                stmt.setInt(5, edad);
                stmt.setString(6, nombreDueno);
                stmt.setString(7, dniDueno);
                stmt.setString(8, enfermedad);
                stmt.setString(9, vacuna);
                stmt.setInt(10, id);

                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Modificación exitosa.");
                    cargarDatos(); 
                    limpiarCampos(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Error al modificar la mascota.");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error en la conexión: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una mascota para modificar.");
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         int selectedRow = tableVacunas.getSelectedRow();
        if (selectedRow != -1) {
        
            int id = (int) model.getValueAt(selectedRow, 0);

         
            try (Connection conn = DatabaseConnection.getConnection()) {
                String query = "DELETE FROM mascotas WHERE id=?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, id);

                int rowsDeleted = stmt.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Eliminación exitosa.");
                    cargarDatos(); 
                    limpiarCampos(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar la mascota.");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error en la conexión: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una mascota para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
      
     
    this.setVisible(false); 

   
    ServicioSeleccion servicioSeleccion = new ServicioSeleccion();

 
    servicioSeleccion.setVisible(true);
    
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VeterinariaVacunasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeterinariaVacunasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeterinariaVacunasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeterinariaVacunasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VeterinariaVacunasGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrarDatos;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxTipoServicio;
    private javax.swing.JComboBox<String> cbxTipodeMascota;
    private javax.swing.JComboBox<String> cbxVacunas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableVacunas;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtDNIDueno;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEnfermedad;
    private javax.swing.JTextField txtNombreDueno;
    private javax.swing.JTextField txtNombreMascota;
    private javax.swing.JTextField txtRaza;
    // End of variables declaration//GEN-END:variables
}
