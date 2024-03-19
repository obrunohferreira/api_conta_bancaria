package brunoferreira.sistemabancario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb-transacao")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransacao;

    @ManyToOne
    @JoinColumn(name = "id_conta")
    private Conta conta;

    @Column(nullable = false)
    private Double valor;

    public Transacao() {
    }

    public Transacao(Long idTransacao, Conta conta, Double valor) {
        this.idTransacao = idTransacao;
        this.conta = conta;
        this.valor = valor;
    }

    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
