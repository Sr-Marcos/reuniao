/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cconexao;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcos
 */
public class reuniaoo extends javax.swing.JFrame {

    /**
     * Creates new form reuniaoo
     */
    public reuniaoo() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/cconexao/o.png")));
        initComponents();
        
        asdf();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTable1 = new javax.swing.JTable();
        data = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        reuniao = new javax.swing.JLabel();
        a = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Sala", "Data", "Hora Entrada", "Hora Saida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        getContentPane().add(jTable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 240));

        try {
            data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(data, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 186, 150, 30));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 186, -1, -1));

        reuniao.setText("jLabel2");
        getContentPane().add(reuniao, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));
        getContentPane().add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
      int setor = jTable1.getColumnCount();
    a.setText(jTable1.getModel().getValueAt(setor,1).toString());
    








        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed
 public void recebendo(String recebe,String prioridades){
        data.setText(recebe);
        reuniao.setText(prioridades);
        asdf();
 }
 
 public void asdf(){
            try{
        Connection con =Conexao.fazconexao();
       String sql="select usuarios.nome as nome,alocacao.PRIORIDADE as PRIORIDADE,alocacao.DATAINICIO as DATAINICIO,alocacao.HORAINICIO as HORAINICIO,alocacao.HORAFIM as HORAFIM, alocacao.EQUIPAMENTO as EQUIPAMENTO,alocacao.SALAREUNIAO as SALAREUNIAO,alocacao.ASSUNTO as ASSUNTO from alocacao inner join usuarios on usuarios.idusuario = alocacao.idusuario where DATAINICIO= ? and SALAREUNIAO=?";
       
       PreparedStatement stmt=con.prepareStatement(sql);
                     // stmt.setTime(1,da);
           String dia =data.getText().substring(0,2);
            String mes =data.getText().substring(3,5);
            String ano =data.getText().substring(6);
            String my=ano+"-"+mes+"-"+dia;                          
            stmt.setObject(1,my);
            stmt.setString(2,reuniao.getText());
          
        ResultSet rs = stmt.executeQuery();
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setNumRows(0);
                    
          while (rs.next()){
                modelo.addRow(new Object[]{
                      rs.getString("nome"),rs.getString("SALAREUNIAO"),rs.getString("DATAINICIO"),rs.getString("HORAINICIO"),rs.getString("HORAFIM"),rs.getString("EQUIPAMENTO"),rs.getString("SALAREUNIAO"),rs.getString("ASSUNTO")});
                     
            
            }
           
            rs.close();
            con.close();
                 }catch(SQLException e){
            e.printStackTrace();
        }
        
 }
  
    
    
    
    
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
            java.util.logging.Logger.getLogger(reuniaoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reuniaoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reuniaoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reuniaoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reuniaoo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a;
    private javax.swing.JFormattedTextField data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel reuniao;
    // End of variables declaration//GEN-END:variables
}
