package com.hxt.juc001;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Juc001ApplicationTests {

	@Test
	void contextLoads() {
//		Thread thread = new Thread(){
//			public void run() {
//				System.out.println("哈哈哈");
//			}
//		};
//		thread.start();
// 创建任务对象
		Runnable task2 = new Runnable() {
			@Override
			public void run() {
//				log.debug("hello");
			}
		};

// 参数1 是任务对象; 参数2 是线程名字，推荐
		Thread t2 = new Thread(task2, "t2");
		t2.start();
	}

}
