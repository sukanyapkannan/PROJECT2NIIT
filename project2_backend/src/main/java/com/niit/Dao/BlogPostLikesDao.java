package com.niit.Dao;

import com.niit.Model.Blog;
import com.niit.Model.BlogPostLikes;

public interface BlogPostLikesDao
{
	BlogPostLikes hasUserLikedPost(int blogId,String username);
	Blog updateLikes(int blogId,String username);
}
