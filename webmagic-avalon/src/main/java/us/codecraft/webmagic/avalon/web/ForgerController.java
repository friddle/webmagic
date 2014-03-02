package us.codecraft.webmagic.avalon.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import us.codecraft.forger.Forger;
import us.codecraft.forger.ForgerFactory;
import us.codecraft.forger.compiler.GroovyForgerCompiler;
import us.codecraft.forger.property.AnnotationPropertyLoader;

/**
 * @author code4crafter@gmail.com
 */
@Controller
@RequestMapping("forge")
public class ForgerController {

    private ForgerFactory forgerFactory = new ForgerFactory(new AnnotationPropertyLoader(), new GroovyForgerCompiler());

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView map = new ModelAndView("forge/index");
        return map;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("source") String source) {
        Forger<Object> forger = forgerFactory.compile(source);
        ModelAndView map = new ModelAndView("forge/create");
        map.addObject("map", forger.getPropertyNames());
        return map;
    }


}
