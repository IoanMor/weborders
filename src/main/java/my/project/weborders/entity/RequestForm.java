package my.project.weborders.entity;

import jakarta.persistence.*;
import lombok.*;
import my.project.weborders.util.StatusEnum;

@Entity
@Table(name = "Forms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    @Builder.Default  private StatusEnum status = StatusEnum.RECEIVED;

}
