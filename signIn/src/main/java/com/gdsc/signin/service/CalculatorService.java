package com.gdsc.signin.service;

import com.gdsc.signin.domain.CalculatorDomain;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements Interface{

    @Override
    public int gobhagui(CalculatorDomain calculatorDomain) {
        return calculatorDomain.getNum1()*calculatorDomain.getNum2();
    }

    @Override
    public int nanugui(CalculatorDomain calculatorDomain) {
        if((calculatorDomain.getNum1() != 0)&&(calculatorDomain.getNum2()!=0)){
            return calculatorDomain.getNum1()/calculatorDomain.getNum2();
        }else{
            return -1;

        }

    }

    @Override
    public int dudgui(CalculatorDomain calculatorDomain) {
        return calculatorDomain.getNum1()+calculatorDomain.getNum2();
    }

    @Override
    public int bbegui(CalculatorDomain calculatorDomain) {
        return calculatorDomain.getNum1() - calculatorDomain.getNum2();
    }
}
