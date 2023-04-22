package view;

import dao.AlunoJpaController;
import dao.exceptions.NonexistentEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Aluno;
import util.EntityManagerUtil;

public class AlunoList extends javax.swing.JFrame {
    
     AlunoJpaController  alunoDao = new AlunoJpaController(EntityManagerUtil.getEntityManagerFactory());
    //  chamando  o Jtable 
     
     
    String col[] = {"Id_Aluno","Cpf","Nome","Turma","Telefone","Endereço"};
    DefaultTableModel tableModel = new DefaultTableModel(col, 0){
        
        
        //  nao permite ateracoes no coteudo 
        @Override
        public boolean isCellEditable(int row, int column) {
            
           return false;
        }
    };
    
    
    
    public AlunoList() {
        initComponents();
        this.jTable1.setModel(tableModel);
        this.findAllAluno();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listagem");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id_Aluno", "Cpf", "Nome", "Turma", "Telefone ", "Endereço "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setName(""); // NOI18N
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 780, 140));

        jButton1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton1.setText("REMOVER ALUNOS");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 210, -1));

        jButton2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton2.setText("NOVO ALUNO");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 200, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/teste-padrão-da-escola-no-fundo-azul-do-quadro-75722790.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    
    
    //Create  
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AlunoForm alunoForm = new AlunoForm(this, true);
       alunoForm.setVisible(true);

        this.findAllAluno();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    //remover 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        
        //opcao
        int opcao = JOptionPane.showConfirmDialog(null, " Tem certeza que deseja excluir os filmes selecionados? ");
        
        if (opcao == JOptionPane.YES_OPTION) {
            
            int indices[] = this.jTable1.getSelectedRows();
      
            for (int i= indices.length - 1; i >= 0; i--) {
            
                int idAlunoAserRemovido = (int) this.tableModel.getValueAt(indices[i], 0);
                try {
                    this.alunoDao.destroy(idAlunoAserRemovido);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(AlunoList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            this.findAllAluno();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
   


//mouse
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {   
            
            int row = ((JTable)evt.getSource()).getSelectedRow(); 
            int alunoId = (int) this.tableModel.getValueAt(row, 0);
            
            AlunoForm alunoForm = new AlunoForm(this, true);
            alunoForm.setVisible(true);
            
            this.findAllAluno();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlunoList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    
    
    
    
    
    ///recuperar todos alunos do banco e adicionar na tabela 
    
    private void findAllAluno() {
        for (int i = this.tableModel.getRowCount() - 1; i >= 0; i--) {
            this.tableModel.removeRow(i);
        }
        /// adiciona atualizando 
        for(Aluno alunoRecuperado: this.alunoDao.findAllAluno()){
            Object[] alunoAserAdicionado = {
                alunoRecuperado.getIdAluno(), 
                alunoRecuperado.getCpf(), 
                alunoRecuperado.getNome(),
                alunoRecuperado.getTurma(),
                alunoRecuperado.getTelefone(),
                alunoRecuperado.getEndereco()
            };
            
            this.tableModel.addRow(alunoAserAdicionado);
    }
    }
}
