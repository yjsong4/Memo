package com.syj.memo.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostController {

	@GetMapping("/list-view")
	public String memoList() {
		
		return "post/list";
	}
	
	@GetMapping("/input-view")
	public String memoInput() {
		
		return "post/input";
	}
	
	@GetMapping("/show-view")
	public String memoShow() {
		
		return "post/show";
	}
	
}
