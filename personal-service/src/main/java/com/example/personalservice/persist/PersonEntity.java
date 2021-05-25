package com.example.personalservice.persist;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PersonEntity {
    @Id
    private long personalNumber;
    private String name;
    private String surname;
    private String department;
}
