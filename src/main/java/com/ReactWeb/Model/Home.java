package com.ReactWeb.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("home")
@Data
public class Home {
    @Id
    private Long id;

    private String name;

    private String email;
    private String password;

    @Column("mobilenumber")
    private String mobileNumber;


}
