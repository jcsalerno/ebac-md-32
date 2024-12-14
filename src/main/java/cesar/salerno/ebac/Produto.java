package cesar.salerno.ebac;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private Long id;

    @Column(nullable = false, length = 100) // Nome do produto com limite de 100 caracteres
    private String nome;

    @Column(nullable = false) // Valor é obrigatório
    private BigDecimal valor;

    @Column(length = 255) // Descrição opcional com limite de 255 caracteres
    private String descricao;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
