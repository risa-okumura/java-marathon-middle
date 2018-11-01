package jp.co.rakus.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.Clothes;
import jp.co.rakus.form.ClothesForm;
import jp.co.rakus.repository.ClothesRepository;

/**
 * 洋服の検索情報を表示するコントローラー.
 * 
 * @author risa.okumura
 *
 */
@Controller
@Transactional
@RequestMapping("/clothes")
public class ClothesController {

	@Autowired
	private ClothesRepository repository;

	@ModelAttribute
	public ClothesForm setUpForm() {
		return new ClothesForm();
	}

	/**
	 * 検索画面を表示する.
	 * 
	 * @return 検索画面
	 */
	@RequestMapping("/toClothes")
	public String toClothes(Model model) {

		Map<String, String> colorMap = new LinkedHashMap<>();
		colorMap.put("赤", "赤");
		colorMap.put("青", "青");
		colorMap.put("黄色", "黄色");
		colorMap.put("白", "白");

		model.addAttribute("colorMap", colorMap);

		// List<Clothes> clothesList =
		// (List<Clothes>)application.getAttribute("clothesList");

		// if (clothesList == null) {
		// clothesList = new ArrayList<>();
		// }

		// application.setAttribute("clothesList", clothesList);

		return "clothesSearch";
	}

	/**
	 * 検索結果を表示する.
	 * 
	 * @param gender
	 *            性別
	 * @param color
	 *            色
	 * @return 検索結果画面
	 */
	@RequestMapping("/clothesInfo")
	public String clothesInfo(ClothesForm form,Model model) {

		List<Clothes> clothesList = repository.findByGenderAndColor(form.getIntGender(), form.getColor());
		model.addAttribute("clothesList", clothesList);

		return toClothes(model);
	}
	

}
