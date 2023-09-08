package com.catalisa.ecommerce.controller;

import com.catalisa.ecommerce.model.ProdutoModel;
import com.catalisa.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping
    public List<ProdutoModel> buscaProdutos(){
        return produtoService.buscaProduto();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ProdutoModel cadastraProduto(@RequestBody ProdutoModel produtoModel){
        return produtoService.cadastraProduto(produtoModel);
    }
}
