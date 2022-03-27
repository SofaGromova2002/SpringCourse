package ru.urfu.javaprogramming.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleInfo {

    private Double price;

    private AdditionalSaleInfo info;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AdditionalSaleInfo {

        private Long id;

        private Date date;
    }
}
