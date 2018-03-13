package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class BlogPostLikes
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int likesId;//PK
	@ManyToOne
	private Blog blogPost;//FK  blog_id
		@ManyToOne
	private User user;//FK  user name
		public int getLikesId() {
			return likesId;
		}
		public void setLikesId(int likesId) {
			this.likesId = likesId;
		}
		public Blog getBlogPost() {
			return blogPost;
		}
		public void setBlogPost(Blog blogPost) {
			this.blogPost = blogPost;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		
}
