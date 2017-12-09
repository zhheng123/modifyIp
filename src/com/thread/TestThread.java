package com.thread;

import java.util.ArrayList;
import java.util.List;

public class TestThread {
	public static void main(String[] args) {
		Test01 a=new Test01();
//		a.start();
//		Thread b=new Thread(new Test02());
//		b.start();
		new Thread(a).start();
		/* List<Product>list = new ArrayList<Product>();
         Producer pro = new Producer(list);
         Connsumer con = new Connsumer(list);
         for(int i = 0;i<=10;i++){
	        new Thread(pro).start();
	        new Thread(con).start();
          }*/
		
	}

}

class Producer implements Runnable{
	 
    private List<Product> list;
    public Producer(List<Product> list) {
        this.list = list;
    }
    @Override
    public void run() {
        if(list.size()>=10){
            try{
                System.out.println("库存已满，等待消费者消费");
                  synchronized (list) {
                	  System.out.println(list.size()+"========");
                    list.wait();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else{
                list.add(new Product());
                System.out.println("生产者生产一个产品");
                synchronized(list) {
                    list.notify();
                }              
        }  
    }
}
class Connsumer implements Runnable{
	 
    private List<Product> list;
    public Connsumer(List<Product> list) {
        this.list = list;
    }
    @Override
    public void run() {
        if(list.size()== 0){
            try{
                System.out.println("产品被全部消费，等待生产者生产！");
                synchronized(list) {       
                    list.wait();
                }
            }catch (Exception e) {
            e.printStackTrace();
            }
        }else{
            System.out.println("消费者消费一个产品");
            list.remove(0);
        synchronized(list) {
                    list.notify();
        }  
        }
    }
}



class Test01 extends Thread{
	public void run() {
        for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + "运行     " + i+"类型01"); 
        }
	}
}
class Test02 implements Runnable{
	@Override
	public void run() {
		 for (int i = 0; i < 10; i++) {
	        	try {
					Thread.sleep(1000);
					if(i==4){
						notify();
					}
					System.out.println(Thread.currentThread().getName() + "运行     " + i+"类型02"); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        }
		
	}
}