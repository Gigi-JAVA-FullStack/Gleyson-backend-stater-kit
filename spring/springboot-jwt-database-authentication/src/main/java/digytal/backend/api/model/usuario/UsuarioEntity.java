package digytal.backend.api.model.usuario;

import digytal.backend.api.enums.Sexo;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tab_usuario")
@Data
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 15, nullable = false)
    private String cpf;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "renda_mensal", nullable = false, length = 9, precision = 2)
    private Double rendaMensal;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Sexo sexo;

}
