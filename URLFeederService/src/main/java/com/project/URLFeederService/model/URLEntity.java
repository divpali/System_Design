package com.project.URLFeederService.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="url_feeder")
public class URLEntity {

    @Id
    private String id;
    
    private String url;

    @CreatedDate
    @Column(name="created_date")
    private Timestamp createdDate;

}
