package Visual;
import DAO.ConectaBanco;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils; //Para utilizar a biblioteca de listagem

/**
 *
 * @author nadia
 */
public class TelaCadastroUsuarios extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public TelaCadastroUsuarios() throws ClassNotFoundException {
        initComponents();
        this.setLocation(500, 200);
        con = ConectaBanco.conectabanco();
        listarUsuarios();
        
    }
    
    public void listarUsuarios()
    {
        String sql = "select * from funcionario order by idfuncionario Asc";
        
        try{
            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            tblUser.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        
        catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, error);
        }
    }
   
    public void cadastrarUsuarios()
    {
        String sql = "insert into funcionario(nome,cargo,cpf) values(?,?,?)";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,txtNome.getText());
            pst.setString(2,txtCargo.getText());
            pst.setString(3,txtCpf.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!","Cadastrado com sucesso",JOptionPane.INFORMATION_MESSAGE);
            listarUsuarios();
        }
        
        catch(SQLException error){
            
            JOptionPane.showMessageDialog(null,error);
        }
            
    }
    
    public void pesquisarUsuarios()
    {
        String sql = "select * from funcionario where nome like ?";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,txtPesquisar.getText()+"%");
            rs = pst.executeQuery();
            tblUser.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
        catch(SQLException error){
            
            JOptionPane.showMessageDialog(null,error);
        }
        
    }
    
    public void mostraItens()
    {
        int seleciona = tblUser.getSelectedRow();
        txtCodigo.setText(tblUser.getModel().getValueAt(seleciona, 0).toString());
        txtNome.setText(tblUser.getModel().getValueAt(seleciona, 1).toString());
        txtCpf.setText(tblUser.getModel().getValueAt(seleciona, 3).toString());
        txtCargo.setText(tblUser.getModel().getValueAt(seleciona, 2).toString());
    }
    
    public void editarUsuarios()
    {
        String sql = "update funcionario set nome = ?, cargo = ?, cpf = ? where idfuncionario = ?";
        
        try{
             pst = con.prepareStatement(sql);
             pst.setString(1,txtNome.getText());
             pst.setString(2,txtCargo.getText());
             pst.setString(3,txtCpf.getText());
             pst.setInt(4,Integer.parseInt(txtCodigo.getText()));
             
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Cadastro Atualizado com sucesso!");
             listarUsuarios();
        }
        
        catch(SQLException error){
            
            JOptionPane.showMessageDialog(null,error);
        }
    }
    
    public void deletar(){
        
         String sql = "delete from funcionario where idfuncionario = ?";
         
         try{
              pst = con.prepareStatement(sql);
              pst.setInt(1,Integer.parseInt(txtCodigo.getText()));
              pst.execute();
              
              listarUsuarios();
              
         }
         
         catch(SQLException error){
            
            JOptionPane.showMessageDialog(null,error);
        }
         
    }
    public void limparCampos()
    {
        txtCodigo.setText("");
        txtNome.setText("");
        txtCargo.setText("");
        txtCpf.setText("");

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new java.awt.TextField();
        jLabel3 = new javax.swing.JLabel();
        txtCpf = new java.awt.TextField();
        jLabel4 = new javax.swing.JLabel();
        txtCargo = new java.awt.TextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtPesquisar = new java.awt.TextField();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
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
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);
        tblUser.getAccessibleContext().setAccessibleName("");

        jLabel1.setText("Código:");

        txtCodigo.setBackground(java.awt.Color.gray);
        txtCodigo.setEnabled(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel3.setText("Cpf:");

        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        jLabel4.setText("Cargo:");

        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Deletar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cadastrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Limpar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        jLabel5.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(55, 55, 55))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       editarUsuarios();
    }//GEN-LAST:event_jButton1ActionPerformed

    //Botão de deletar
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        deletar();
    }//GEN-LAST:event_jButton2ActionPerformed

    //Botão de Cadastrar
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        cadastrarUsuarios();
    }//GEN-LAST:event_jButton3ActionPerformed

    //Botão de Limpar os campos
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        limparCampos();
    }//GEN-LAST:event_jButton4ActionPerformed
    
    //Quando o usuário começar a digitar
    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        pesquisarUsuarios();
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        
        mostraItens();
    }//GEN-LAST:event_tblUserMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUser;
    private java.awt.TextField txtCargo;
    private java.awt.TextField txtCodigo;
    private java.awt.TextField txtCpf;
    private java.awt.TextField txtNome;
    private java.awt.TextField txtPesquisar;
    // End of variables declaration//GEN-END:variables

    private void JOptionPane(Object object, SQLException error) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
