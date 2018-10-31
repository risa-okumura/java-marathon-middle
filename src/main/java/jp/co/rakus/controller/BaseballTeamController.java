package jp.co.rakus.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.BaseballTeam;
import jp.co.rakus.repository.BaseBallRepository;

/**
 * プロ野球チームを表示するコントローラー.
 * 
 * @author risa.okumura
 *
 */
@Controller
@Transactional
@RequestMapping("/baseballTeam")
public class BaseballTeamController {

	@Autowired
	private ServletContext application;

	@Autowired
	private BaseBallRepository repository;

	/**
	 * プロ野球チームの名前を一覧で表示する.
	 * 
	 * @return チーム名表示画面
	 */
	@RequestMapping("/toBaseballTeamList")
	public String toBaseballTeamList() {

		List<BaseballTeam> baseballTeamList = repository.findAll();

		application.setAttribute("baseballTeamList", baseballTeamList);

		return "baseballTeamList";

	}

	/**
	 * プロ野球チームの情報を表示する.
	 * 
	 * @param id
	 * @return チーム情報表示画面
	 */
	@RequestMapping("/baseballTeamInfo")
	public String baseballTeamInfo(int id) {
		BaseballTeam baseballTeam = repository.load(id);

		application.setAttribute("baseballTeam", baseballTeam);

		return "baseballTeamInfo";
	}

}
