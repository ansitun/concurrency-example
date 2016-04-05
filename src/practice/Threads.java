package practice;

public class Threads implements Runnable  {

	private Thread t1, t2;
	
	private int count = 0;

	public void run() {
		
		System.out.println("started");
		
		while(this.count < 10 ) {
			try {
				
				synchronized(this) {
					System.out.println(this.count + "--------" + Thread.currentThread().getName());
					Thread.sleep(500);
					this.count++;
					}
				
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
		
		System.out.println("ended");
		
		return;
	}
	
	public void start() {
		t1 = new Thread(this, "t1 thread");
		t1.start();
		
		t2 = new Thread(this, "t2 thread");
		t2.start();
	}
}