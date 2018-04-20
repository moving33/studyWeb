package com.j.ch15.member.service;

import com.j.ch15.model.Member;

public interface MemberService {
    //등록
    void regist(Member member);
    //정보수정
    boolean update(String memberId, UpdateInfo info);
}
