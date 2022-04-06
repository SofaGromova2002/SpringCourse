package ru.urfu.javaprogramming.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
public class SaleResponse {

    public SaleResponse(SaleRequest saleRequest) {
        this.price = saleRequest.getPrice();
        this.info = new AdditionalSaleInfoResponse(saleRequest.getInfo());
    }

    private final Double price;

    private final AdditionalSaleInfoResponse info;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AdditionalSaleInfoResponse {

        public AdditionalSaleInfoResponse(SaleRequest.AdditionalSaleInfoRequest additionalSaleInfoRequest) {
            this.date = additionalSaleInfoRequest.getDate();
        }

        private Long id;

        private Date date;
    }
}
