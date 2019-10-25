package com.win.dfbp.factory;

import com.win.dfbp.cal.ISecurityCalculation;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

public class SpiFactory {

	public static ISecurityCalculation getSecurityAlgorithm(String algorithmType){
		ISecurityCalculation securityCalculation = null ;
		try {
			synchronized (ISecurityCalculation.class) {
				List<ISecurityCalculation> iss = SpringFactoriesLoader.loadFactories(ISecurityCalculation.class, null);
				for (ISecurityCalculation is :iss) {
					if (is.isAlgorithmSupported(algorithmType)){
						securityCalculation = is;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return securityCalculation;
	}
}
