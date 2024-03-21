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


}
