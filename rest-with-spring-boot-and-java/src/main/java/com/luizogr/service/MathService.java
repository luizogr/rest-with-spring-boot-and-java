package com.luizogr.service;

import com.luizogr.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MathService {
    private Double convertToDouble(String strNum) throws IllegalArgumentException {
        if(strNum == null || strNum.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value");
        String num = strNum.replace(",", ".");
        return Double.parseDouble(num);
    }

    private boolean isNumeric(String strNum){
        if(strNum == null || strNum.isEmpty()) return false;
        String num = strNum.replace(",", ".");
        return num.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public Double sum(String num1, String num2) throws Exception{
        if(!isNumeric(num1) || !isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return convertToDouble(num1) + convertToDouble(num2);
    }

    public Double subtraction(String num1, String num2) throws Exception{
        if(!isNumeric(num1) || !isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return convertToDouble(num1) - convertToDouble(num2);
    }

    public Double multiplication(String num1, String num2) throws Exception{
        if (!isNumeric(num1) || !isNumeric(num2))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(num1) * convertToDouble(num2);
    }

    public Double division(String num1, String num2) throws Exception{
        if (!isNumeric(num1) || !isNumeric(num2))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(num1) / convertToDouble(num2);
    }

    public Double mean(String num1, String num2) throws Exception{
        if (!isNumeric(num1) || !isNumeric(num2))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return (convertToDouble(num1) + convertToDouble(num2)) / 2;
    }

    public Double squareRoot(String num) throws Exception{
        if (!isNumeric(num))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return Math.sqrt(convertToDouble(num));
    }
}
