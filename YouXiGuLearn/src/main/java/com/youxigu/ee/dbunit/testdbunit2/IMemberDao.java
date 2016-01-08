package com.youxigu.ee.dbunit.testdbunit2;

import java.util.List;

/**
 * @Description
 * @author Spontaneously
 * @time 2016年1月8日 下午4:49:58
 */
public interface IMemberDao {

	public List<Member> listAllMember(); // list all Members.

	public Member findMemberById(long id); // find a Member by Id.

	public boolean insertMember(Member member); // insert a member record.
}
