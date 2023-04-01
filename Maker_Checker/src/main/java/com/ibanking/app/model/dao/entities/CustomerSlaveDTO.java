package com.ibanking.app.model.dao.entities;

import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_slave_table_16787")
public class CustomerSlaveDTO {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @NotNull
    @Column(length = 10, name = "customer_code")
    private String customerCode;

    @NotNull
    @Column(name = "customer_name")
    private String customerName;

    @NotNull
    @Column(name = "customer_address1")
    private String address1;

    @Column(name = "customer_address2")
    private String address2;

    @NotNull
    @Column(name = "customer_pincode")
    private String pinCode;

    @Column(name = "customer_email")
    @Email
    private String email;

    @Column(name = "customer_contact_number")
    private String contactNumber;

    @Column(name = "customer_primary_contact_person")
    private String primaryContactPerson;

    @Column(name = "customer_record_status")
    private String recordStatus;

    @Column(name = "customer_active_inactive_flag")
    private String activeInactive;

    private String createDate;

    private String createdBy;

    private String modifiedDate;

    private String modifiedBy;

    private String authorizedDate;

    private String authorizedBy;

    public CustomerSlaveDTO(String customerCode, String customerName, String address1,
                             String address2, String pinCode, String email,
                             String contactNumber, String primaryContactPerson,
                             String activeInactive) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.address1 = address1;
        this.address2 = address2;
        this.pinCode = pinCode;
        this.email = email;
        this.contactNumber = contactNumber;
        this.primaryContactPerson = primaryContactPerson;
        this.activeInactive = activeInactive;
    }
}
