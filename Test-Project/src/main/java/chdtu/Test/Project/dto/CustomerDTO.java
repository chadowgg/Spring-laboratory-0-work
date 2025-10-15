package chdtu.Test.Project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long id;

    private String fullName;

    private String phoneNumber;

    private String email;

    private String deliveryAddress;

    private String dateRegistration;
}
