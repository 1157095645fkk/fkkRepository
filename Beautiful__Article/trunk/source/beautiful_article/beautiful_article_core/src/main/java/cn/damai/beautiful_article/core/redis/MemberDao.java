package cn.damai.beautiful_article.core.redis;

import cn.damai.beautiful_article.core.domain.Member;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public interface MemberDao {
    boolean add(Member member);

    public boolean addObjectAndTime(String mykey, Object value,long time);

    boolean addAndTime(Member member,long time);

    abstract boolean add(List<Member> list);

    void delete(String key);

    Member get(String keyId);

}
