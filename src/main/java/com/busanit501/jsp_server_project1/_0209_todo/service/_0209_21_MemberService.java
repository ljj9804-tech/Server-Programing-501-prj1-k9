package com.busanit501.jsp_server_project1._0209_todo.service;

import com.busanit501.jsp_server_project1._0209_todo.dao._0209_19_MemberDAO;
import com.busanit501.jsp_server_project1._0209_todo.domain._0209_17_MemberVO;
import com.busanit501.jsp_server_project1._0209_todo.dto._0209_18_MemberDTO;
import com.busanit501.jsp_server_project1._0209_todo.util._0209_4_MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum  _0209_21_MemberService {
    INSTANCE;

    private _0209_19_MemberDAO dao;
    private ModelMapper modelMapper;

    _0209_21_MemberService() {
        dao = new _0209_19_MemberDAO();
        modelMapper = _0209_4_MapperUtil.INSTANCE.get();
    }

    // 로그인 기능 메서드
    public _0209_18_MemberDTO login(String mid, String mpw) throws Exception {
        _0209_17_MemberVO vo = dao.getWithPassword(mid, mpw);
        _0209_18_MemberDTO memberDTO = modelMapper.map(vo,_0209_18_MemberDTO.class);
        return memberDTO;
    }

    // uuid  업데이트 기능 추가
    // 자동로그인 기능 추가 0209, 순서5
    public void updateUuid(String mid, String uuid) throws Exception {
        dao.updateUuid(mid,uuid);
    }

    // 자동로그인 기능 추가 0209, 순서6
    public _0209_18_MemberDTO getByUUID(String uuid) throws Exception {
        _0209_17_MemberVO memberVO = dao.selectUUID(uuid);
        _0209_18_MemberDTO memberDTO = modelMapper.map(memberVO,_0209_18_MemberDTO.class);
        return memberDTO;
    }
}
