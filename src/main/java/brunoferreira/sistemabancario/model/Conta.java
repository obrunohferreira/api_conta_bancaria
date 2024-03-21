package brunoferreira.sistemabancario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb-contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;

    @Column(nullable = false)
    private Double saldo;

    @Column(nullable = false)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transacao> transacoes;

    public Conta() {
    }

    public Conta(Double saldo, String tipo, Usuario usuario) {
        this.saldo = saldo;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public Conta(Long idConta, Double saldo, String tipo, Usuario usuario, List<Transacao> transacoes) {
        this.idConta = idConta;
        this.saldo = saldo;
        this.tipo = tipo;
        this.usuario = usuario;
        this.transacoes = transacoes;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
