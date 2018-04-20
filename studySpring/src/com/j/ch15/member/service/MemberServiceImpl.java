/*
MemberService 구현객체
 */

package com.j.ch15.member.service;

import com.j.ch15.model.Member;

public class MemberServiceImpl implements MemberService {
    @Override
    public void regist(Member member) {
        System.out.println("MemberServiceImp : regist Method ...");
    }

    @Override
    public boolean update(String memberId, UpdateInfo info) {
        System.out.println("MemberServiceImp : update Method ...");
        return memberId != null ? true :false;
    }
}
