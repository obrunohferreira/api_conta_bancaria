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

    @Column(nullable = false)
    private String descricao;

    public Transacao() {
    }

    public Transacao(Long idTransacao, Conta conta, Double valor, String descricao) {
        this.idTransacao = idTransacao;
        this.conta = conta;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Long getIdTransacao() {
        return idTransacao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
