package com.it.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.MemberVO;
import com.it.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member/")
public class MemberController {

	@Setter(onMethod_ = @Autowired)
	private MemberService service;

	@GetMapping("/list")
	public void list(Model model) { // Controller에서 VO객체를 저장해서 jsp 파일로 전송 (반드시선언, 쓰던 안쓰던 상관없음)
		// list.jsp 에 데이터를 전달해야 함
		model.addAttribute("list", service.getList()); // getList로 조회한 모든 내용을 list변수로
		// 전달
	}

	@GetMapping("/insert")
	public void insert() {
		// 페이지를 호출만함
	}

	@PostMapping("/insert")
	public String insert(MemberVO member) {
		log.info("=================시작===============");
		log.info(member);
		// 테이블입력
		service.insert(member);
		log.info("===============완료=================");
		// 리스트로 이동
		return "redirect:/member/list"; // controller 를 통해서 이동

	}

	@GetMapping("/view")
	public void view(MemberVO member, Model model) {
		log.info("===========읽기전=========");
		log.info(member);
		member = service.read(member);
		log.info("==========읽은후==========");
		log.info(member);
		model.addAttribute("member", member);
	}

	@GetMapping("/update")
	public void update(MemberVO member, Model model) {
		log.info("===========업데이트를 위한 번호===========");
		log.info(member);
		member = service.read(member); // 번호만 사용하여 조회
		log.info("===========업데이트를 위한 데이터===========");
		log.info(member);
		model.addAttribute("member", member);

	}

	@PostMapping("/update")
	public String update(MemberVO member) {
		log.info("==============업데이트 데이터======================");
		log.info(member);
		service.update(member); // 업데이트
		return "redirect:/member/view?m_id=" + member.getM_id();
	}

	@GetMapping("/delete")
	public String delete(MemberVO member) {
		log.info("==============업데이트 삭제======================");
		service.delete(member);
		return "redirect:/member/list";
	}

	@GetMapping("/login")
	public void login() {
		// 로그인페이지호출
		
	}

	@PostMapping("/login")
	public String login(MemberVO member, HttpSession session) {
		log.info(member);
		boolean chk = service.auth(member);
		if (chk == true) {
			member = service.read(member);
			session.setAttribute("m_id", member.getM_id());// 세션변수 생성
			session.setAttribute("m_name", member.getM_name());
			log.info("인증성공");
		} else {
			log.info("인증실패");
		}
		return "redirect:/member/list";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 끊기
		return "redirect:/";
	}
}
