package com.seveninterval.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Pet", description = "Benim Pet")
public class Pet {
    @ApiModelProperty(value = "Pet nesnesinin tekil Id alanı")
    private int id;
    @ApiModelProperty(value = "Pet nesnesinin tekil name alanı")
    private String name;
    @ApiModelProperty(value = "Pet nesnesinin tekil date alanı")
    private Date date;
}
