package cn.damai.beautiful_article.core.serviceImpl;

import cn.damai.beautiful_article.core.dao.SystemLogMapper;
import cn.damai.beautiful_article.core.domain.SystemLog;
import cn.damai.beautiful_article.core.service.SystemLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
@Service
public class SystemLogServiceImpl implements SystemLogService{
    @Resource
    private SystemLogMapper systemLogMapper;
    @Transactional
    public int saveSystemLog(SystemLog systemLog) {
        return systemLogMapper.save(systemLog);
    }
}
