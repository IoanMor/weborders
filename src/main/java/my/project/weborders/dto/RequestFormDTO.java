package my.project.weborders.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestFormDTO {


    @NotBlank(message = "Имя обязательно")
    @Size(max = 20)
    private String name;

    @NotBlank
    @Pattern(
            regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$",
            message = "Некорректный номер телефона"
    )
    private String tNumber;

    @NotBlank
    @Size(max = 2000, message = "Описание слишком длинное")
    private String description;


}
