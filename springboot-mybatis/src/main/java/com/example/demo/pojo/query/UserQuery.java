package com.example.demo.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQuery {
    private Integer pageNum = 1;
    private Integer pageSize = 3;
    private String name;
}
