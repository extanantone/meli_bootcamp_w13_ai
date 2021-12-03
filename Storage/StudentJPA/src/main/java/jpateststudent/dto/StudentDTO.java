package jpateststudent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO
{
    private Long id;
    private String dni;
    private String name;
    private String lastName;
}
