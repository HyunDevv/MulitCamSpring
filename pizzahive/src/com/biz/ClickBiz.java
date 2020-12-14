package com.biz;

import org.springframework.stereotype.Service;

import com.vo.MemberVO;
@Service
public class ClickBiz implements Click<MemberVO> {

	@Override
	public void itemclick(MemberVO t) {
		System.out.println(t);
	}

}
