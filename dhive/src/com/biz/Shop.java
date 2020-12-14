package com.biz;

import org.springframework.stereotype.Service;

@Service
public interface Shop<T> {
	public void itemclick(T t);
}
