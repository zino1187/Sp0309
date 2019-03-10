package com.itbank.aop;

import org.apache.log4j.Logger;

public class Bell {
	Logger logger=Logger.getLogger(this.getClass().getName());
	
	public void ding() {
		logger.warn("¢Ý¢Ý¢Ýµùµ¿´ó¢Ý~~");
	}
	public void trump() {
		logger.warn("»£ºü¶ó¢Ý~~");
	}
}
