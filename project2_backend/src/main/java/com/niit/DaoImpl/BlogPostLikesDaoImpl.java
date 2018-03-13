package com.niit.DaoImpl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.BlogPostLikesDao;
import com.niit.Model.Blog;
import com.niit.Model.BlogPostLikes;
import com.niit.Model.User;
@Repository
@Transactional
public class BlogPostLikesDaoImpl implements BlogPostLikesDao
{
	@Autowired
	private SessionFactory sessionF;
	public BlogPostLikes hasUserLikedPost(int blogId, String username)
	{
		Session session=sessionF.getCurrentSession();
		Query query=session.createQuery("from BlogPostLikes where blogId=? and username=?");
		query.setInteger(0, blogId);
		query.setString(1, username);
		BlogPostLikes blogPostLikes=(BlogPostLikes)query.uniqueResult();
		return blogPostLikes;// 1 object / null -> glyphicon color[1 object -blue color  , null - black color]
	}
	 // when user clicks the glyphicon in frontend
	public Blog updateLikes(int blogId, String username) 
	{
		Session session = sessionF.getCurrentSession();
		BlogPostLikes blogPostLikes=hasUserLikedPost(blogId, username);
		//for blogPostlikes [null or 1 object]
		Blog blogPost=(Blog)session.get(Blog.class, blogId);
		//user has not yet liked the blog post, now the user has liked it
		if(blogPostLikes==null){//previous condition- currently glyphicon is in black color 
			//likes  -> [insert and increment the likes]
			BlogPostLikes likes=new BlogPostLikes();//id, blogpost_id, user_email
			User user=(User)session.get(User.class, username);
			likes.setBlogPost(blogPost);
			likes.setUser(user);
			session.save(likes);//insert into blogpostlikes 
			blogPost.setLikes(blogPost.getLikes() + 1); //increment the likes
			session.update(blogPost);//update blogpost set likes=likes +1 where id=?
		}
		else
		{//unlike [previous - liked the blogpost, now user is unliking it]
			session.delete(blogPostLikes);//delete from blogPostLikes where likesid=?
			blogPost.setLikes(blogPost.getLikes() - 1);//decrement the number of likes
			session.update(blogPost);//update blogpost set likes = likes -1 where id=?
		}
		return blogPost;//in frontend we have to display the updated likes
	}

	}


