package com.example.model;

import com.example.validator.PhoneNumberConstraint;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @NotBlank
    @Column(name = "name")
    private String name;
    @NotBlank
    @PhoneNumberConstraint
    @Column(name = "phoneNumber")
    private String phoneNumber;
}
