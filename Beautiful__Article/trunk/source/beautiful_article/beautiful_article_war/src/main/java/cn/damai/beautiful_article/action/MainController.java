package cn.damai.beautiful_article.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
@Controller
@RequestMapping("main")
public class MainController extends BaseController{

   @RequestMapping("view")
    public ModelAndView view(Map<String, Object> context){
       context.put("test","test");
       return  toView("main",context);
   }
}
