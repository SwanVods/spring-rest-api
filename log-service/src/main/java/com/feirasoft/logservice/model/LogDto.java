package com.feirasoft.logservice.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LogDto {
    private String data;
}
