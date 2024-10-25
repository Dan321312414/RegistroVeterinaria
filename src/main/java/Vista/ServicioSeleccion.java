
package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServicioSeleccion extends javax.swing.JFrame {
        
    private JButton btnBanio;
    private JButton btnVacunas;
    private JLabel lblMensaje;
   
   
    public ServicioSeleccion() {
        initComponents();
     
        setTitle("GUARDIANES VET");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(0, 102, 102)); 

        // Configuración del JLabel
        lblMensaje = new JLabel("SELECCIONE EL SERVICIO");
        lblMensaje.setForeground(Color.WHITE);
        lblMensaje.setFont(new Font("Microsoft Tai Le", Font.BOLD, 22)); 
        addComponent(lblMensaje, 0, 0, 2, 1);

        
        btnBanio = new JButton("Baño");
        btnBanio.setBackground(Color.WHITE);
        btnBanio.setForeground(new Color(0, 102, 102)); 
        btnBanio.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18)); 
        btnBanio.setPreferredSize(new Dimension(150, 50)); 
        btnBanio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                new VeterinariaBañoGUI().setVisible(true);
                dispose(); 
            }
        });
        addComponent(btnBanio, 0, 1, 1, 1);

     
        btnVacunas = new JButton("Vacunas");
        btnVacunas.setBackground(Color.WHITE);
        btnVacunas.setForeground(new Color(0, 102, 102)); // Color del texto
        btnVacunas.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18)); 
        btnVacunas.setPreferredSize(new Dimension(150, 50)); 
        btnVacunas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                new VeterinariaVacunasGUI().setVisible(true);
                dispose(); 
            }
        });
        addComponent(btnVacunas, 1, 1, 1, 1);

        setVisible(true); // Mostrar la ventana
    }

    private void addComponent(Component component, int gridx, int gridy, int gridwidth, int gridheight) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10); // Espacio entre componentes
        add(component, gbc);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ServicioSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServicioSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServicioSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServicioSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServicioSeleccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
