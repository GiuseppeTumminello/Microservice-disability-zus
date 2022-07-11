package com.acoustic.controller;


import com.acoustic.entity.DisabilityZus;
import com.acoustic.repository.DisabilityZusRepository;
import com.acoustic.service.SalaryCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Map;


@RestController
@RequestMapping("/disabilityZus")
@RequiredArgsConstructor
@Validated
@CrossOrigin
public class DisabilityZusController {

    public static final String DESCRIPTION = "description";
    public static final String VALUE = "value";
    private final DisabilityZusRepository disabilityZusRepository;
    private final SalaryCalculatorService salaryCalculatorService;


    @PostMapping("/getDisabilityZus/{grossMonthlySalary}")
    public Map<String, String> calculateDisabilityZus(@PathVariable @Min(2000) BigDecimal grossMonthlySalary) {
        var disabilityZus = salaryCalculatorService.apply(grossMonthlySalary);
        this.disabilityZusRepository.save(DisabilityZus.builder().disabilityZusAmount(disabilityZus).build());
        return Map.of(DESCRIPTION, salaryCalculatorService.getDescription(), VALUE, String.valueOf(disabilityZus));
    }
}
