package com.backbase.moviesapi.model.paging;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageArray<T> {
    private List<T> data;
    private int recordsFiltered;
    private int recordsTotal;
    private int draw;
}
