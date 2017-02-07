package cn.damai.beautiful_article.core.service;

import cn.damai.beautiful_article.common.utils.DataResult;
import cn.damai.beautiful_article.core.vo.UserRegisterLoginVo;
import org.springframework.stereotype.Service;

/**
 * Created by fkk on 2017/2/4.
 */
@Service
public interface LoginService {
   public DataResult login(UserRegisterLoginVo userVo,String cacheVerify);
}
