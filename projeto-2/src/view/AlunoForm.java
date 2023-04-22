package view;

import dao.AlunoJpaController;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import model.Aluno;
import util.EntityManagerUtil;




public class AlunoForm extends javax.swing.JDialog {
    private boolean isNovoAluno;
    private AlunoJpaController  alunoDao = new AlunoJpaController(EntityManagerUtil.getEntityManagerFactory());
    private Aluno aluno;
    
    
    
    
    private Aluno findByIdAluno(int alunoId){
        return this.alunoDao.findAluno(alunoId);
    }

    
    
    public AlunoForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.isNovoAluno = true;
        
        this.aluno = new Aluno();
    }

    
    
   public AlunoForm(java.awt.Frame parent, boolean modal, int alunoId) {
        super(parent, modal);
        initComponents();
        this.isNovoAluno = false;
        
        aluno = this.findByIdAluno(alunoId);
        
        this.idAluno.setText(String.valueOf(this.aluno.getIdAluno()));
        this.cpf.setText(this.aluno.getCpf());
        this.nome.setText(this.aluno.getNome());
        this.turma.setText(this.aluno.getTurma());
        this.telefone.setText(this.aluno.getTelefone());
        this.endereco.setText(this.aluno.getEndereco());
       
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idAluno = new javax.swing.JTextField();
        cpf = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        turma = new javax.swing.JTextField();
        telefone = new javax.swing.JTextField();
        endereco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");
        setEnabled(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id_Aluno:");
        jLabel1.setEnabled(false);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cpf:");
        jLabel2.setEnabled(false);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome:");
        jLabel3.setEnabled(false);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Turma:");
        jLabel4.setEnabled(false);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefone:");
        jLabel5.setEnabled(false);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Endereço:");
        jLabel6.setEnabled(false);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 110, -1));

        idAluno.setEditable(false);
        idAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        idAluno.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        idAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idAlunoActionPerformed(evt);
            }
        });
        getContentPane().add(idAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 65, -1));

        cpf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cpf.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfActionPerformed(evt);
            }
        });
        getContentPane().add(cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 130, -1));

        nome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nome.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });
        getContentPane().add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 154, -1));

        turma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        turma.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        turma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turmaActionPerformed(evt);
            }
        });
        getContentPane().add(turma, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 89, -1));

        telefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        telefone.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneActionPerformed(evt);
            }
        });
        getContentPane().add(telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 130, -1));

        endereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        endereco.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enderecoActionPerformed(evt);
            }
        });
        getContentPane().add(endereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 170, -1));

        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 110, -1));

        jButton2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton2.setText("Limpar");
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 110, -1));

        jButton3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton3.setText("Cadastrar");
        jButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idAlunoActionPerformed

    private void cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfActionPerformed

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void turmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_turmaActionPerformed

    private void telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneActionPerformed

    private void enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enderecoActionPerformed

    
    
    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.idAluno.setText("");
        this.cpf.setText("");
        this.nome.setText("");
        this.turma.setText("");
        this.telefone.setText("");
        this.endereco.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
         this.aluno.setCpf(this.cpf.getText());
         this.aluno.setNome(this.nome.getText());
         this.aluno.setTurma(this.turma.getText());
         this.aluno.setTelefone(this.telefone.getText());
         this.aluno.setEndereco(this.endereco.getText());
                     
         if(this.isNovoAluno){
            try {
                this.alunoDao.create(aluno);
            } catch (Exception ex) {
                Logger.getLogger(AlunoForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            try {
                this.alunoDao.edit(aluno);
            } catch (Exception ex) {
                Logger.getLogger(AlunoForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
        dispose();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AlunoForm dialog = new AlunoForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpf;
    private javax.swing.JTextField endereco;
    private javax.swing.JTextField idAluno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField telefone;
    private javax.swing.JTextField turma;
    // End of variables declaration//GEN-END:variables
}
