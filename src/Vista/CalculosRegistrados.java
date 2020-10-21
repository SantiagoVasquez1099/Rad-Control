/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Barrera;
import Modelo.Control;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author juanc
 */
public class CalculosRegistrados extends javax.swing.JPanel {
    private Control control;
    private Principal p;
    private Calculo c;
    /**
     * Creates new form CalculosRegistrados
     * @param p
     * @param control
     */
    public CalculosRegistrados(Principal p, Control control, Calculo c) {
        initComponents();
        this.control = control;
        this.p = p;
        this.c = c;
        listeners();
        manejadorJlist mj = new manejadorJlist();
        jList1.setModel(mj);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btnActualizar = new javax.swing.JButton();
        btnOtroCalculo = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();
        btnCopiar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jList1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jList1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/iconfinder_sync_126579.png"))); // NOI18N
        btnActualizar.setToolTipText("Actualizar la lista");

        btnOtroCalculo.setText("Realizar otro calculo");

        btnVer.setText("Ver...");

        btnCopiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/iconfinder_document_file_paper_page-02_2850904.png"))); // NOI18N
        btnCopiar.setToolTipText("Copiar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOtroCalculo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(btnVer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCopiar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnCopiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOtroCalculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCopiar;
    private javax.swing.JButton btnOtroCalculo;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<Object> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
    public class manejadorJlist implements ListModel<Object>{
        
        @Override
        public int getSize() {
            return control.getBarreras().size();
        }

        @Override
        public Object getElementAt(int i) {
            return control.getBarreras().get(i).toString2();
        }

        @Override
        public void addListDataListener(ListDataListener ll) {
            
        }

        @Override
        public void removeListDataListener(ListDataListener ll) {
            
        } 
    }
    
    public void listeners(){
        btnActualizar.addActionListener(f -> {
            jList1.updateUI();
        });
        btnVer.addActionListener(f -> {
            int it = jList1.getSelectedIndex();
            Barrera barrera = control.getBarreras().get(it);
            JOptionPane.showMessageDialog(p, barrera.toString());
        });
        btnOtroCalculo.addActionListener(f -> {
            p.remove(this);
                p.add(c, BorderLayout.CENTER);
                p.pack();
                p.setLocationRelativeTo(null);
                p.invalidate();
                p.revalidate();
                p.repaint();
        });
        btnCopiar.addActionListener(f -> {
            int it = jList1.getSelectedIndex();
            Barrera barrera = control.getBarreras().get(it);
            copiar(barrera.toString());
            JOptionPane.showMessageDialog(p, "Datos de la barrera copiados!");
        });
        
    }
    
    public void copiar(String text){
        StringSelection ss = new StringSelection(text);
        
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        cb.setContents(ss, null);
    }

}
