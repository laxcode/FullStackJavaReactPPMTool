package io.dhania.ppmtool.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;
    private String projectIdentifier;
    private String projectDescription;
    private Date startDate;
    private Date endDate;

    private Date createdAt;
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
