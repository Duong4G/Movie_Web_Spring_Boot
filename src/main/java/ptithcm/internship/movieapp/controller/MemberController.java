package ptithcm.internship.movieapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.internship.movieapp.entrity.Category;
import ptithcm.internship.movieapp.entrity.Film;
import ptithcm.internship.movieapp.entrity.FilmDetail;
import ptithcm.internship.movieapp.entrity.User;
import ptithcm.internship.movieapp.entrity.Web;
import ptithcm.internship.movieapp.repository.UserRepository;
import ptithcm.internship.movieapp.service.CategoryService;
import ptithcm.internship.movieapp.service.FilmDetailService;
import ptithcm.internship.movieapp.service.FilmService;
import ptithcm.internship.movieapp.service.SendMailService;
import ptithcm.internship.movieapp.service.WebService;
import ptithcm.internship.movieapp.utils.ConstantVariable;

@Controller
public class MemberController {
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private FilmDetailService filmDetailService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SendMailService mailService;
	
	@Autowired
	private WebService webService;
	
	@ModelAttribute("web")
	public Web getWeb(){
	    return webService.findByHasUse();
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);
	
	@Value("${web.domain}")
	private String webDomain;

	
	@RequestMapping("/filmManager")
	public String filmManager(Model model) {
		LOGGER.info("filmManager");
		
		List<Film> listFilmNoDeployOrHasRequest = filmService.findFilmsNoDeployOrHasRequest();
		model.addAttribute("listFilmNoDeployOrHasRequest", listFilmNoDeployOrHasRequest);
		return "film_manager";
	}
	
	@RequestMapping("/review-has-role/{id}")
	public String getFilmInfoWithRole(Model model,@PathVariable("id") int id) {
		LOGGER.info("getFilmInfoWithRole: " + "id=" + id);
		
		Film film = filmService.findFilmById(id);
		if(film.getFdeploy() == 0 || film.getFrequest() == 1) {
			List<Category> listCategory = categoryService.findAllCategoryByFid(id);
			String categories = "";
			for (Category c : listCategory) {
				categories = categories + "/ " + c.getCname();
			}
			categories = categories.substring(1);
			model.addAttribute("categories", categories);
			model.addAttribute("film", film);
			return "review_film_role";
		}
		return "403";
	}
	
	@RequestMapping("/watch-has-role/{id}")
	public String getFilmToWatchWithRole(Model model,@PathVariable("id") int id) {
		LOGGER.info("getFilmToWatchWithRole: " + "id=" + id);
		
		Film film = filmService.findFilmById(id);
		List<FilmDetail> listFilmDetail = filmDetailService.findAllByFid(id);
		if(film.getFdeploy() == 0 || film.getFrequest() == 1) {
			model.addAttribute("webDomain", webDomain);
			model.addAttribute("film", film);
			model.addAttribute("filmDetail", listFilmDetail.get(0));
			model.addAttribute("listFilmDetail", listFilmDetail);
			return "watch_film";
		}
		return "403";
	}
	
	@RequestMapping("accept-film-request/{fid}")
	public String acceptFilmRequest(Model model,@PathVariable("fid") int fid, @ModelAttribute("message") String message, Authentication auth) {
		LOGGER.info("acceptFilmRequest: " + "fid=" + fid + " message=" + message + "mailService=" + mailService);
		
		String email = auth.getName();
		User user = userRepository.findByEmail(email);
		
		Film film = filmService.findFilmById(fid);
		
		if (film.getFdeploy() == 0) {
			film.setFdeploy(1);
			film.setAcceptAccount(user.getUname());
			if (film.getFstatus() == 1) {
				List<FilmDetail> listFilmDetails = filmDetailService.findAllByFid(fid);
				for (FilmDetail fd : listFilmDetails) {
					fd.setFddeploy(1);
					fd.setAcceptAccount(user.getUname());
					filmDetailService.save(fd);
				}
			}
			mailService.sendEmail(film.getRequestEmail(), "[" + film.getFname() + "]" + ConstantVariable.ACCEPT_MAIL_SUBJECT, ConstantVariable.ACCEPT_MAIL_BODY);
		}else {
			if (film.getFrequest() == 1) {
				List<FilmDetail> listFilmDetails = filmDetailService.findAllByFidNoDeploy(fid);
				String emailSend = "";
				for (FilmDetail fd : listFilmDetails) {
					fd.setFddeploy(1);
					fd.setAcceptAccount(user.getUname());
					filmDetailService.save(fd);
					emailSend = fd.getRequestEmail();
				}
				film.setFrequest(0);
				filmService.save(film);
				mailService.sendEmail(emailSend, "[" + film.getFname() + "]" + ConstantVariable.ACCEPT_EPISODE_MAIL_SUBJECT, ConstantVariable.ACCEPT_EPISODE_MAIL_BODY);
			}
			
		}
		
		filmService.save(film);
		model.addAttribute("message", "Accept request OK!");
		model.addAttribute("film", film);
		return "review_film_role";
	}
	
	@RequestMapping("delete-film-request/{fid}")
	public String deleteFilmRequest(Model model,@PathVariable("fid") int fid, @ModelAttribute("message") String message) {
		LOGGER.info("deleteFilmRequest: " + "fid=" + fid + " message=" + message + "mailService=" + mailService);
		
		Film film = filmService.findFilmById(fid);
		if (film.getFdeploy() == 0) {
			filmService.delete(film);
			mailService.sendEmail(film.getRequestEmail(), "[" + film.getFname() + "]" + ConstantVariable.DELETE_MAIL_SUBJECT, ConstantVariable.DELETE_MAIL_BODY);
		}
		
		if (film.getFdeploy() == 1 && film.getFrequest() == 1) {
			List<FilmDetail> listFilmDetails = filmDetailService.findAllByFidNoDeploy(fid);
			String emailSend = "";
			for (FilmDetail fd : listFilmDetails) {
				emailSend = fd.getRequestEmail();
				filmDetailService.delete(fd);
			}
			film.setFrequest(0);
			filmService.save(film);
			mailService.sendEmail(emailSend, "[" + film.getFname() + "]" + ConstantVariable.DELETE_EPISODE_MAIL_SUBJECT, ConstantVariable.DELETE_EPISODE_MAIL_BODY);
		}
		return "redirect:/filmManager";
	}
}
