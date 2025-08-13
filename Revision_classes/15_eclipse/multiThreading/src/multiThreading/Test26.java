package multiThreading;

	class Factory{
		private int items;
		private boolean itemsavailable;
		public synchronized void produce(int items) {
			if(itemsavailable) {
				try {
					wait();
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.items = this.items + items;
			System.out.println("items produced" + items);
			itemsavailable = true;
			notify();
		}
		public synchronized void consume(int items) {
			if(!itemsavailable) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.items = this.items - items;
			System.out.println("items consumed" + items);
			itemsavailable = false;
			notify();
		}
	}
	class ProducerThread extends Thread{
		private Factory factory;
	    public ProducerThread(Factory factory) {
	    	this.factory = factory;
	    }
		@Override
		public void run() {
			for(int i = 1; i<= 10; i++) {
				factory.produce(i);
			}
		}
	}
	class ConsumerThread extends Thread{
	    private Factory factory;
	    public ConsumerThread(Factory factory) {
	    	this.factory = factory;
	    }
		@Override
		public void run() {
			for(int i = 1; i<= 10; i++) {
				factory.consume(i);
			}
		}
	}
	public class Test26{
		public static void main(String[] args) {
			Factory f = new Factory();
			ProducerThread pt = new ProducerThread(f);
			ConsumerThread ct = new ConsumerThread(f);
			pt.start();
			ct.start();
		}
}
