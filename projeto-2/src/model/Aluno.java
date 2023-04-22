
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Alunos")
public class Aluno implements Serializable {
    
    @Id
    @Column(name="idaluno")
    private int idAluno;
    
    @Column(name="cpf")
    private String cpf;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="turma")
    private String turma;
    
    @Column(name="telefone")
    private String telefone;
    
    @Column(name="endereco")
    private String endereco;

    public Aluno(int idAluno, String cpf, String nome, String turma, String telefone, String endereco) {
        this.idAluno = idAluno;
        this.cpf = cpf;
        this.nome = nome;
        this.turma = turma;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
    public Aluno (){}

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Aluno{" + "idAluno=" + idAluno + ", cpf=" + cpf + ", nome=" + nome + ", turma=" + turma + ", telefone=" + telefone + ", endereco=" + endereco + '}';
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
