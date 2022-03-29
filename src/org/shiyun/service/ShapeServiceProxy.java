package org.shiyun.service;

import org.shiyun.aspect.LoggingAspect;
import org.shiyun.model.Circle;

public class ShapeServiceProxy extends ShapeService {
	
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}

}
