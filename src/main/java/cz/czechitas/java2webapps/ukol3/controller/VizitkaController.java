package cz.czechitas.java2webapps.ukol3.controller;
import entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
  private final List<Vizitka> seznamVizitka = List.of(
          new Vizitka("Petr", "Novy", "ABC,s.r.o.", "Pivonkova 100", "Brno 63700", "petr.novy@seznam.cz", "+420777800900", "https://cs.wikipedia.org/wiki/Petr_Nov%C3%BD"),
          new Vizitka("Jana", "Stara", "Haf, a. s.", "Serikova 712/10", "Ostrava 70030", "jana.stara@email.cz", null, "https://kppp.pedf.cuni.cz/index.php/lide-na-katedre/jana-stara/"),
          new Vizitka("Greta", "Hrabalova", "Mnau", "Tresnova 1261/5", "Trest 58901", "mnau@gmail.com", "+420606122900", null)
  );

  @GetMapping("/")
  public ModelAndView seznam() {
  ModelAndView modelAndView = new ModelAndView("/seznam");
  modelAndView.addObject("seznamVsechVizitek", seznamVizitka);
  return modelAndView;
}

  @GetMapping("/detail")
  public ModelAndView detail(@PathVariable int id) {
    ModelAndView modelAndView = new ModelAndView("/detail");
    modelAndView.addObject("detailVizitka", seznamVizitka.get(id));
    return modelAndView;
  }
}