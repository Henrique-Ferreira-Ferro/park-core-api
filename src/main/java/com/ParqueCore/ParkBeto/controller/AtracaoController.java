package com.ParqueCore.ParkBeto.controller;
import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.service.impl.AtracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.HttpStatus.BAD_REQUEST;


@RestController
@RequestMapping("/atracoes")
public class AtracaoController {

    @Autowired
    private AtracaoService atracaoService;

    //Listar todas as atracoes
    @GetMapping
    public ResponseEntity<List<Atracao>> listaAtracoes(){
        List<Atracao> atracoes = atracaoService.listaAtracoes();
        return new ResponseEntity<>(atracoes, HttpStatus.OK);
    }
    //Busca por Id
    @GetMapping("/{id}")
    public ResponseEntity<Atracao> buscarPorId(@PathVariable Long id){
        var atracao = atracaoService.buscarPorId(id);
        return new ResponseEntity<>(atracao, HttpStatus.OK);
    }
    //Busca por nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Atracao> buscarPorNome(@PathVariable String nome){
        var atracao = atracaoService.buscarPorNome(nome);
        return new ResponseEntity<>(atracao, HttpStatus.OK);
    }
    //Busca por tipo


    @PostMapping
    public ResponseEntity<Atracao> createAtracao(@RequestBody Atracao atracao) {
        Atracao newAtracao = atracaoService.createAtracao(atracao);
        return new ResponseEntity<>(newAtracao, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAtracao(@PathVariable Long id) {
        atracaoService.deleteAtracao(id);
        return new ResponseEntity<>(BAD_REQUEST);

    }
}
