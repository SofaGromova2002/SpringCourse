package ru.urfu.javaprogramming.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.urfu.javaprogramming.model.SaleInfo;
import ru.urfu.javaprogramming.rest.exceptions.BadGatewayException;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RestController
@RequestMapping("/api")
public class SaleController {

    private final AtomicLong currentId = new AtomicLong(0);

    @GetMapping("/headers")
    public Map<String, String> getHeaders(@RequestHeader Map<String, String> headers) {
        return headers;
    }

    @PostMapping("/registerSale")
    public SaleInfo registerSale(@RequestBody SaleInfo saleInfo) throws BadGatewayException {
        if (saleInfo.getPrice() < 0) {
            throw new BadGatewayException("Цена продажи меньше 0");
        }
        saleInfo.getInfo().setId(currentId.incrementAndGet());
        return saleInfo;
    }
}
