package it.unipr.informatica.exam.giugno7.decoupled;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.*;

@SuppressWarnings({ "unused"})
public class DecoupledAspect2{
	
	public static <T> T attach(T target) {
		if(target==null)
			throw new IllegalArgumentException("target is null");
		
		Class<?> targetClass = target.getClass();
		
		Class<?>[] targetInterfaces = targetClass.getInterfaces(); 
		
		Object proxy = Proxy.newProxyInstance(targetClass.getClassLoader(),
				targetInterfaces, 
				new InnerInvocationHandler(target)
				); 
		
		@SuppressWarnings("unchecked")
		T result = (T)proxy;
		
		return result; 
	}
	
	public static void log() {
		System.out.println("proxy has intercepted call!"); 
	}
	
	
	
	private static class InnerInvocationHandler implements InvocationHandler {
		
		private Object target; 
		private Object lock; 
		long timeout = 5; 
		
		private InnerInvocationHandler(Object target) {
			this.target = target; 
		}
		
		@Override 
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			
			InnerFuture<Object> f = new InnerFuture<Object>(); 
			
			Thread t = new Thread(()->{
				try {
					log(); 
					Object r = method.invoke(target, args);
					f.set(r); 					
				}catch(Throwable thro) {
					thro.printStackTrace();
				}
			});  
			t.start();
			return f.get();   
		}	
	}
}
