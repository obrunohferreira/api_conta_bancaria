package brunoferreira.sistemabancario.model;

import jakarta.persistence.*;

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
    private List<Transacao> transacoes;


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

    public Usuario getUsuario() {
        return usuario;
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
