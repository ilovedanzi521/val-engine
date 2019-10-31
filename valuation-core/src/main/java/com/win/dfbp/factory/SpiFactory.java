package com.win.dfbp.factory;

import com.win.dfbp.cal.ISecurityCalculation;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

public class SpiFactory {
	/**
	 * @Title: getSecurityAlgorithm
	 * @Description 动态获取算法模块
	 * @param algorithmType
	 * @return com.win.dfbp.cal.ISecurityCalculation
	 * @throws
	 * @author wanglei
	 * @Date 2019/10/31/14:27
	 */
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
