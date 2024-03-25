package com.syj.memo.post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.syj.memo.post.domain.Post;

@Mapper
public interface PostRepository {

	public int insertPost(
			@Param("userId") int userId
			, @Param("title") String title
			, @Param("contents") String contents
			, @Param("imagePath") String imagePath);
	
	public List<Post> selectPostList(@Param("userId") int userId);
	
	public Post selectPost(@Param("id") int id);
	
}
