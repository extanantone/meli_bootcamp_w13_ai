package com.mercadolibre.sportsclub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class MemberDTO {

    private Long id;
    @NotBlank(message = "Member name value must not be empty.")
    @Pattern(regexp="[A-Z]\\w*.*", message = "Member name value must start with uppercase.")
    @Size(min = 0, max = 60, message = "Member name max length is 60 characters.")
    private String memberName;
    private String message;
    private Double totalFee;
    @Valid
    @NotEmpty(message = "Activities list must not be empty.")
    private List<ActivityDTO> activities;

}
