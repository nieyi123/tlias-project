package com.yjj.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQueryParam {
    private String name;
    private Integer gender;
    private Integer degree;
    private Integer clazzId;
    private Integer page = 1;                                 // 页码
    private Integer pageSize = 5;                            // 每页记录数
}
