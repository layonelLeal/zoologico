/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package zoologico.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author barah
 */
public class VerAnimales extends javax.swing.JPanel {

    /**
     * Creates new form VerAnimales
     */
    VentanaViewAnimals vva;
    DefaultTableModel tm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Todas las celdas no son editables
            }            
        };;
    
    public void changeVentana(){
        vva.setVisible(false);
        VentanaPricipal vp = new VentanaPricipal();
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
    }
    
    
    public VerAnimales(VentanaViewAnimals vva) {
        this.vva = vva;
        initComponents();
        String ids[] = new String[]{"Nombre", "Alimentado", "Habitat", "Altura", "Ancho", "Largo"};
        tm.setColumnIdentifiers(ids);
        AnimalsTable.setModel(tm);
        AnimalsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Integer seleccionFila = AnimalsTable.getSelectedRow();
                    System.out.println("La fila numero #"+ seleccionFila.toString() + " fue seleccionada papá");
                    JButton btnAlimentar = new JButton("Alimentar");
                    btnAlimentar.setLocation(0, 0);
                    btnAlimentar.setSize(100, 25);
                    btnAlimentar.setVisible(true);
                    contentButton.add(btnAlimentar);
                    contentButton.setVisible(true);
                    contentButton.repaint();                    
                }
            }
        });
        addDemoValue();
        
        AnimalsTable.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 8){
                    System.out.println("Regresando...");
                    changeVentana();
                }
                System.out.println("Tecla presionada: " + e.getKeyCode());
            }
        });
    }
    
    public void addDemoValue (){
        tm.addRow(new Object[]{"León", "Sí", "Pradera", 10, 10, 30, });
        tm.addRow(new Object[]{"Gato", "No", "Casa", 10, 10, 30, });
        tm.addRow(new Object[]{"Perro", "Sí", "Casa", 10, 10, 30, });
        tm.addRow(new Object[]{"Tigre", "Sí", "Pradera", 10, 10, 30, });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AnimalsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        contentButton = new javax.swing.JPanel();

        jTextField1.setText("jTextField1");

        AnimalsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Alimentado", "Habitat", "Altura", "Ancho", "Largo", "Alimentar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(AnimalsTable);
        if (AnimalsTable.getColumnModel().getColumnCount() > 0) {
            AnimalsTable.getColumnModel().getColumn(1).setPreferredWidth(60);
        }

        javax.swing.GroupLayout contentButtonLayout = new javax.swing.GroupLayout(contentButton);
        contentButton.setLayout(contentButtonLayout);
        contentButtonLayout.setHorizontalGroup(
            contentButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );
        contentButtonLayout.setVerticalGroup(
            contentButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(contentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AnimalsTable;
    private javax.swing.JPanel contentButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
