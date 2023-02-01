package com.backbase.moviesapi.model.paging;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Order {
    @ApiModelProperty(notes = "table column index")
    private Integer column;
    @ApiModelProperty(notes = "order direction ASC or DESC")
    private Direction dir;
}
