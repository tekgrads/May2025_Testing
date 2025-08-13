package multiThreading;
	import java.util.concurrent.Callable;
	import java.util.concurrent.ExecutorService;
	import java.util.concurrent.Executors;
	import java.util.concurrent.Future;
	import java.util.concurrent.ExecutionException;

	class MyRunnable implements Runnable {
		@Override 
		public void run(){
			String name = Thread.currentThread().getName();
			System.out.println("MR run  is executed in "+ name);

		}
	}

	class MyCallable implements Callable<Integer> {
		@Override
		public Integer call() {
			String name = Thread.currentThread().getName();
			System.out.println("MC call is executed in "+ name);
			return 7;
		}
	}

	public class Test29{   //Callable_ExecutorFramework 
		public static void main(String[] args) {
			System.out.println("main start");

			MyRunnable mr = new MyRunnable();
			//Thread th1 = new Thread(mr);
			//th1.start();
	
			MyCallable mc = new MyCallable();
		//	Thread th2 = new Thread(mc); //CE:
			//th2.start();

		//	ExecutorService service = Executors.newSingleThreadExecutor();
		//	ExecutorService service = Executors.newFixedThreadPool(3);
			ExecutorService service = Executors.newCachedThreadPool();
//			service.submit(mr);
//			service.submit(mc);
//			service.submit(mr);
//			service.submit(mc);
//			service.submit(mr);
//			service.submit(mc);
//			service.submit(mc);
//			service.submit(mc);

			for(int i=1; i<=100; i++){
				service.submit(mc);
			}
			
			service.shutdown();

			ExecutorService service2 = Executors.newSingleThreadExecutor();
			Future<Integer> future = service2.submit(mc);
			try{
				int res = future.get();
				System.out.println("Callable return value: " +res);
			}catch(InterruptedException e){
				e.printStackTrace();
			}catch(ExecutionException e){
				e.printStackTrace();
			}
			service2.shutdown();

			ExecutorService service3 = Executors.newSingleThreadExecutor();
			Future<Integer> future2 = service3.submit(
										new Callable<Integer>() {
											@Override
											public Integer call() throws Exception{
												System.out.println("AIC call");
												return 20;
												//throw new Exception("For fun");
											}
										}
									);
			try{
				Integer res = future2.get();
				System.out.println("res: "+ res);
			}catch(InterruptedException e){
				e.printStackTrace();
			}catch(ExecutionException e){
				//e.printStackTrace();
				Throwable t = e.getCause();
				t.printStackTrace();
			}
			service3.shutdown();

			ExecutorService service4 = Executors.newSingleThreadExecutor();
			service4.submit(mr);
			service4.submit(mr);
			service4.submit(mr);
			service4.submit(mr);
			service4.submit(mr);

			service4.shutdown();
		//	service4.shutdownNow();

			System.out.println("main end");


		
		}
}
