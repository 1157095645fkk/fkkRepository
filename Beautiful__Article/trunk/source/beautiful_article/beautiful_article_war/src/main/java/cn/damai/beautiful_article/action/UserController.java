package cn.damai.beautiful_article.action;

import cn.damai.beautiful_article.core.domain.Member;
import cn.damai.beautiful_article.core.redis.MemberDao;
import cn.damai.beautiful_article.core.service.MyBaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

/**
 * Created by Administrator on 2016/10/8 0008.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Resource
    private MyBaseService myBaseService;

    @Resource
    private MemberDao memberDao;

    @RequestMapping(value = "/test", method = { RequestMethod.POST, RequestMethod.GET }, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getData(){
        Member member = new Member();
        member.setId("12");
        member.setNickname("11111");
       memberDao.add(member);
        memberDao.get("12");
        System.out.println( memberDao.get("12"));
        System.out.println("getServletPath"+request.getServletPath());
        Cookie cookie = new Cookie("aaa","123");
        response.addCookie(cookie);
        return memberDao.get("12").getNickname();
    }
    @RequestMapping(value = "/redirect", method = { RequestMethod.POST, RequestMethod.GET }, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelAndView redirect(){
        Cookie[] cookies =request.getCookies();
        if(cookies!=null&&cookies.length>0) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("aaa")) {
                    System.out.println("cookie值：" + cookies[i].getValue());
                }
            }
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "xxx");
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
