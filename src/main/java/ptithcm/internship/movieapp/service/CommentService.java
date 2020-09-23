package ptithcm.internship.movieapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ptithcm.internship.movieapp.entrity.Comment;
import ptithcm.internship.movieapp.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentService.class);
	
	public Comment findByCmid(int cmid) {
		LOGGER.info("findByCmid: " + "cmid=" + cmid);
		
		return commentRepository.findByCmid(cmid);
	}
	
	public List<Comment> findAll(){
		LOGGER.info("findByCmid");
		
		return commentRepository.findAll();
	}
	
	public List<Comment> findAllByFid(int fid){
		LOGGER.info("findAllByFid: " + "fid=" + fid);
		
		return commentRepository.findAllByFid(fid);
	} 
	
	public List<Comment> findAllByFidWithFirstAndLast(int fid, Pageable pageable) {
		return commentRepository.findAllByFidWithFirstAndLast(fid, pageable);
	}
	
	public Comment save(Comment comment) {
		LOGGER.info("save: " + "comment=" + comment);
		
		return commentRepository.save(comment);
	}
	
	public void delete(Comment comment) {
		LOGGER.info("delete: " + "comment=" + comment);
		
		commentRepository.delete(comment);
	}
}
