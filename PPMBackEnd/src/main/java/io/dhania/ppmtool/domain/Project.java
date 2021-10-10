package io.dhania.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Project Name should not be blank")
    private String projectName;
    @NotBlank(message = "Project Name should not be blank")
    @Size(min = 4,max = 5,message = "Project identifier should be 4 or 5 character")
    @Column(updatable = false,unique = true)
    private String projectIdentifier;
    @Size(max = 100,message = "Project description character should be maximum 100 ")
    private String projectDescription;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected  void createdAt(){
        this.createdAt=new Date();
    }

    @PreUpdate
    protected void updatedAt(){
        this.endDate= new Date();
    }

}
