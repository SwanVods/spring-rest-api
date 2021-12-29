package com.feirasoft.postservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "categories")
public class Category {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    @CreatedDate
    private Date created_at;

    @LastModifiedDate
    private Date updated_at;
}
