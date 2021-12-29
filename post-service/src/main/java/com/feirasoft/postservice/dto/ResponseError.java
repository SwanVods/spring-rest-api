package com.feirasoft.postservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Created by Arpit Khandelwal
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ResponseError {
    private Date timestamp;
    private String message;
    private String details;
}
