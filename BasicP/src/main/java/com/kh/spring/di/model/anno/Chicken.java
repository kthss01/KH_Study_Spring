package com.kh.spring.di.model.anno;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("chicken")
public class Chicken implements Food {

	@Override
	public void eat(String foodName) {
		System.out.println("집에서 " + foodName + " 치킨을 먹는 중 !~");
	}

}
