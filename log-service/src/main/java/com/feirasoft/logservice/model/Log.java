package com.feirasoft.logservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Log {
    @Id
    private String id;
    private String data;

    @CreatedDate
    private Date created_at;
}
