package my.project.weborders.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.project.weborders.util.StatusEnum;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestFormDTO {

    private String name;
    private String tNumber;
    private String description;
    private StatusEnum status;


}
