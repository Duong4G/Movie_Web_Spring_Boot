package ptithcm.internship.movieapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.internship.movieapp.entrity.Category;
import ptithcm.internship.movieapp.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	public Optional<Category> findCategoryById(String cid) {
		return categoryRepository.findById(cid);
	}
	
	public Category findByCategoryId(String cid) {
		return categoryRepository.findByCategoryId(cid);
	}
	
	public List<Category> findAllCategory(){
		return categoryRepository.findAll();
	}
	
	public List<Category> findAllCategoryByFid(int fid){
		return categoryRepository.findCategoriesByFid(fid);
	}
	
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	
	public void delete(Category category) {
		categoryRepository.delete(category);
	}
}
