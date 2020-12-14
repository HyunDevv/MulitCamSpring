package com.biz;

import org.springframework.stereotype.Service;

@Service
public interface Click<T> {
	public void itemclick(T t);
}
