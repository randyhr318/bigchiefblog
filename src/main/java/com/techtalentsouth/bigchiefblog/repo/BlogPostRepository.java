package com.techtalentsouth.bigchiefblog.repo;

import com.techtalentsouth.bigchiefblog.model.BlogPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Long is a type
//its a wrapper class that represents your Id
// anything in the diamond is known as a generic or type parameters.
@Repository
public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {

}
