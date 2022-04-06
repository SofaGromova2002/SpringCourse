package ru.urfu.javaprogramming.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.urfu.javaprogramming.model.SaleRequest;
import ru.urfu.javaprogramming.model.SaleResponse;
import ru.urfu.javaprogramming.rest.exceptions.BadGatewayException;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RestController
@RequestMapping("/api")
public class SaleController {

    private final AtomicLong currentId = new AtomicLong(0);

    @PostMapping("/registerSale")
    public SaleResponse registerSale(@RequestBody SaleRequest saleRequest) throws BadGatewayException {
        if (saleRequest.getPrice() < 0) {
            throw new BadGatewayException("Цена продажи меньше 0");
        }
        SaleResponse saleResponse = new SaleResponse(saleRequest);
        saleResponse.getInfo().setId(currentId.incrementAndGet());
        return saleResponse;
    }
}
