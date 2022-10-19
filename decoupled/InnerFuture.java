package it.unipr.informatica.exam.giugno7.decoupled;

class InnerFuture<T> implements Future<T> {
	private T value;
	
	private Throwable throwable;
	
	private Object lock;
	
	InnerFuture() {
		this.value = null;
		
		this.throwable = null;
		
		this.lock = new Object();
	}
	
	@Override
	public T get() throws Throwable {
		synchronized(lock) {
			while (value == null && throwable == null)
				lock.wait();
			
			if (throwable != null)
				throw throwable;
			
			return value;
		}
	}
	
	void set(T value) {
		synchronized(lock) {
			this.value = value;
			
			lock.notifyAll();
		}
	}

	
	@SuppressWarnings("unused")
	private void set(Throwable throwable) {
		synchronized(lock) {
			this.throwable = throwable;
			
			lock.notifyAll();
		}
	}
}