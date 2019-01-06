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
 * 切面类
 * @author w1812
 * @EnableAspectJAutoProxy: 开启注解功能
 *
 */
@Aspect
public class LogAspects {
	
	@Pointcut(value="execution(public int com.atguigu.aop.MathCalculator.*(..))")
	public void pointcut(){}
	
	//@Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
	@Before(value="pointcut()")
	public void logStart(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		System.out.println(""+joinPoint.getSignature().getName()+"运行。。。@Before:参数列表是：{"+Arrays.asList(args)+"}");
	}
	
	
	@After("com.atguigu.aop.LogAspects.pointcut()")
	public void logEnd(JoinPoint joinPoint){
		System.out.println(""+joinPoint.getSignature().getName()+"结束。。。@After");
	}
	
	//JoinPoint一定要出现在参数表的第一位
	@AfterReturning(value="pointcut()",returning="result")
	public void logReturn(JoinPoint joinPoint,Object result){
		System.out.println(""+joinPoint.getSignature().getName()+"正常返回。。。@AfterReturning:运行结果：{"+result+"}");
	}
	
	@AfterThrowing(value="pointcut()",throwing="exce")
	public void logExcepion(JoinPoint joinPoint,Exception exce){
		System.out.println(""+joinPoint.getSignature().getName()+"异常。。。异常信息：{"+exce+"}");
	}
	
}
