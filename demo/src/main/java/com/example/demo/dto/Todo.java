package com.example.demo.dto;

import lombok.Data;
import java.util.Date;

@Data
public class Todo {
    private Long id;               // ID
    private Long userId;           // USER_ID
    private String content;        // CONTENT
    private String completed;      // COMPLETED ('Y' or 'N')
    private Date createdAt;        // CREATED_AT (기본값 SYSDATE)
}

