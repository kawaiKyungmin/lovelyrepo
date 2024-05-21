package com.gdsc.signin.controller;

import com.gdsc.signin.domain.CalculatorDomain;
import com.gdsc.signin.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaclulatorController {
    CalculatorService calculatorService;

    @Autowired
    public CaclulatorController(CalculatorService calculatorService) {

        this.calculatorService = calculatorService;

    }



    @GetMapping("/gob")
    int gob(@RequestParam int num1,@RequestParam int num2){
        CalculatorDomain calculatorDomain = new CalculatorDomain(num1, num2);
        return calculatorService.gobhagui(calculatorDomain);
    }

    @GetMapping("/nanu")
    int nanu(@RequestParam int num1,@RequestParam int num2){
        CalculatorDomain calculatorDomain = new CalculatorDomain(num1, num2);
        return calculatorService.nanugui(calculatorDomain);
    }

    @GetMapping("/bbegui")
    int bbegui(@RequestParam int num1,@RequestParam int num2){
        CalculatorDomain calculatorDomain = new CalculatorDomain(num1, num2);
        return calculatorService.bbegui(calculatorDomain);
    }

    @GetMapping("/duhagui")
    int duhagui(@RequestParam int num1,@RequestParam int num2){
        CalculatorDomain calculatorDomain = new CalculatorDomain(num1, num2);
        return calculatorService.dudgui(calculatorDomain);
    }


}