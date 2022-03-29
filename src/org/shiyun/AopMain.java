package org.shiyun;

import org.shiyun.service.FactoryService;
import org.shiyun.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//		// getBean("bean name", class name) without casting ShapeService before ctx.getBean
//		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
//		// same as ShapeService shapeService = (ShapeService) ctx.getBean("shapeService");
//		
//		System.out.println(shapeService.getCircle().getName());
//		System.out.println();
//		System.out.println(shapeService.getTriangle().getName());
//		shapeService.getCircle().setName("Dummy name");
//		shapeService.getCircle().setNameAndReturn("Dummy name2");
//		shapeService.getCircle();
		
		FactoryService factoryService = new FactoryService();
		ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");
		shapeService.getCircle();
	}

}
