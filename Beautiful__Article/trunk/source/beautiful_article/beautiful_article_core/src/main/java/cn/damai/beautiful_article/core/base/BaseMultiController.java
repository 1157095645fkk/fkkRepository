package cn.damai.beautiful_article.core.base;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class BaseMultiController {
    protected ModelAndView toView(final String url,final Map<String,Object> map)
    {
        ModelAndView  view = new ModelAndView(url,map);
        return view;
    }
}