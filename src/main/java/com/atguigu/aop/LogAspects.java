package com.atguigu.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ������
 * @author w1812
 * @EnableAspectJAutoProxy: ����ע�⹦��
 *
 */
@Aspect
public class LogAspects {
	
	@Pointcut(value="execution(public int com.atguigu.aop.MathCalculator.*(..))")
	public void pointcut(){}
	
	//@Before��Ŀ�귽��֮ǰ���룻�������ʽ��ָ�����ĸ��������룩
	@Before(value="pointcut()")
	public void logStart(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		System.out.println(""+joinPoint.getSignature().getName()+"���С�����@Before:�����б��ǣ�{"+Arrays.asList(args)+"}");
	}
	
	
	@After("com.atguigu.aop.LogAspects.pointcut()")
	public void logEnd(JoinPoint joinPoint){
		System.out.println(""+joinPoint.getSignature().getName()+"����������@After");
	}
	
	//JoinPointһ��Ҫ�����ڲ�����ĵ�һλ
	@AfterReturning(value="pointcut()",returning="result")
	public void logReturn(JoinPoint joinPoint,Object result){
		System.out.println(""+joinPoint.getSignature().getName()+"�������ء�����@AfterReturning:���н����{"+result+"}");
	}
	
	@AfterThrowing(value="pointcut()",throwing="exce")
	public void logExcepion(JoinPoint joinPoint,Exception exce){
		System.out.println(""+joinPoint.getSignature().getName()+"�쳣�������쳣��Ϣ��{"+exce+"}");
	}
	
}
