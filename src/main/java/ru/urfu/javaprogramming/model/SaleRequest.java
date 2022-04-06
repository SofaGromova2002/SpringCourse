package ru.urfu.javaprogramming.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequest {

    private Double price;

    private AdditionalSaleInfoRequest info;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AdditionalSaleInfoRequest {

        private Date date;
    }
}
