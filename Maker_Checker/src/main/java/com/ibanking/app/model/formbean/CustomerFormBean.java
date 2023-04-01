package com.ibanking.app.model.formbean;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CustomerFormBean {

    private Integer id;

    @NotEmpty(message = "Customer code cannot be empty")
    private String customerCode;

    @NotEmpty(message = "Name cannot be empty")
    private String customerName;

    @NotEmpty(message = "Address Line 1 cannot be empty")
    private String address1;

    private String address2;

    @NotEmpty(message = "Pin code cannot be blank")
    private String pinCode;

    @NotEmpty(message = "cannot be empty")
    @Email(message = "wrong format")
    private String email;

    private String contactNumber;

    @NotEmpty(message = "primaryContactPerson cannot be empty")
    private String primaryContactPerson;

    private String recordStatus;

    @NotEmpty(message = "cannot be empty")
    private String activeInactive;

    private String createDate;

    private String createdBy;

    private String modifiedDate;

    private String modifiedBy;

    private String authorizedDate;

    private String authorizedBy;

    public CustomerFormBean(String customerCode, String customerName,
                            String address1, String address2, String pinCode,
                            String email, String contactNumber, String primaryContactPerson,
                            String recordStatus, String activeInactive) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.address1 = address1;
        this.address2 = address2;
        this.pinCode = pinCode;
        this.email = email;
        this.contactNumber = contactNumber;
        this.primaryContactPerson = primaryContactPerson;
        this.recordStatus = recordStatus;
        this.activeInactive = activeInactive;
    }
}
