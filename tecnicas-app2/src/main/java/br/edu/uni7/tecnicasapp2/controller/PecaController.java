package br.edu.uni7.tecnicasapp2.controller;

import br.edu.uni7.tecnicasapp2.model.Peca;
import br.edu.uni7.tecnicasapp2.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PecaController {

    private final PecaRepository repository;

    @Autowired
    public PecaController(PecaRepository repository) {
        this.repository = repository;
    }

    @ResponseBody
    @RequestMapping(value = "peca", method = RequestMethod.GET)
    public List<Peca> list() {
        return repository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "peca/{id}", method = RequestMethod.GET)
    public Peca findById(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @ResponseBody
    @RequestMapping(value = "peca", method = RequestMethod.POST)
    public Peca create(@RequestBody Peca peca) {
        repository.save(peca);
        return peca;
    }

    @ResponseBody
    @RequestMapping(value = "peca/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Integer id, @RequestBody Peca peca) {
        repository.save(peca);
    }

    @ResponseBody
    @RequestMapping("peca/{id}")
    public void remove(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
