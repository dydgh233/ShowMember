package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.domain.MemberVO;
import com.it.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;

	@Override
	public MemberVO read(MemberVO member) {
		return mapper.read(member);
	}

	@Override
	public boolean auth(MemberVO member) {
		MemberVO tmp = new MemberVO();
		tmp = mapper.read(member);// 아이디, 암호를 이용해서 모든 필드정보 획득,아이디가 틀리면 null반환
		if (tmp != null) {// 아이디가 틀린 경우
			if (member.getM_passwd().equals(tmp.getM_passwd())) {
				log.info(tmp);
				log.info("인증성공");
				return true;
			} else {

				log.info(tmp);
				log.info(member);
				log.info("아이디는 동일하나 암호가 틀림");
				return false;
			}
		} else {
			log.info(tmp);
			log.info("아이디가 존재x");
			return false;
		}
	}

	@Override
	public void insert(MemberVO member) {
		mapper.insert(member);
	}

	@Override
	public List<MemberVO> getList() {
		return mapper.getList();
	}

	@Override
	public void update(MemberVO member) {
		mapper.update(member);
	}

	@Override
	public void delete(MemberVO member) {
		mapper.delete(member);

	}

}
