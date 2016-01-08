package com.youxigu.ee.dbunit.testdbunit2;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月8日 下午4:57:02
*/
public class MemberDao extends HibernateDaoSupport implements IMemberDao {

	public List<Member> listAllMember() {
		return this.getHibernateTemplate().find("select * from member");
	}

	public Member findMemberById(long id) {
		return null;
	}

	public boolean insertMember(Member member) {
		return false;
	}

}
