package it.unipr.informatica.exam.giugno7.decoupled;

public interface Future<T> {

	public T get() throws Throwable;

}
