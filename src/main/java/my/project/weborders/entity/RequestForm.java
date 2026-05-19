package my.project.weborders.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Forms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_name")
    private String name;

    @Column(name = "t_number")
    private String tNumber;

    @Column(name = "description")
    private String description;

}
