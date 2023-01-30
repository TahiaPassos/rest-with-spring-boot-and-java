package com.tahiana.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tahiana.exceptions.UnsupportedMathOperationException;
import com.tahiana.utils.MathConversionAndValidation;
import com.tahiana.utils.MathOperations;

@RestController
public class MathController {


	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception{
		
			if (!MathConversionAndValidation.isNumeric(numberOne) || !MathConversionAndValidation.isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Coloque apenas valores numéricos!");
			}
		return MathOperations.sum(MathConversionAndValidation.convertToDouble(numberOne), MathConversionAndValidation.convertToDouble(numberOne));
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception{
		
			if (!MathConversionAndValidation.isNumeric(numberOne) || !MathConversionAndValidation.isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Coloque apenas valores numéricos!");
			}
		return MathOperations.subtraction(MathConversionAndValidation.convertToDouble(numberOne), MathConversionAndValidation.convertToDouble(numberOne));
	}
	
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception{
		
			if (!MathConversionAndValidation.isNumeric(numberOne) || !MathConversionAndValidation.isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Coloque apenas valores numéricos!");
			}
		return MathOperations.multiplication(MathConversionAndValidation.convertToDouble(numberOne), MathConversionAndValidation.convertToDouble(numberOne));
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception{
		
		if (!MathConversionAndValidation.isNumeric(numberOne) || !MathConversionAndValidation.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Coloque apenas valores numéricos!");
		}
		return MathOperations.division(MathConversionAndValidation.convertToDouble(numberOne), MathConversionAndValidation.convertToDouble(numberOne));
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception{
		
			if (!MathConversionAndValidation.isNumeric(numberOne) || !MathConversionAndValidation.isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Coloque apenas valores numéricos!");
			}
		return MathOperations.mean(MathConversionAndValidation.convertToDouble(numberOne), MathConversionAndValidation.convertToDouble(numberOne));
	}
	
	@RequestMapping(value = "/squareRoot/{numberOne}", method=RequestMethod.GET)
	public Double squareRoot(
			@PathVariable(value = "numberOne") String number) throws Exception{
		
		if (!MathConversionAndValidation.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Coloque apenas valores numéricos!");
		}
		return MathOperations.squareRoot(MathConversionAndValidation.convertToDouble(number));
	
	}	
}
