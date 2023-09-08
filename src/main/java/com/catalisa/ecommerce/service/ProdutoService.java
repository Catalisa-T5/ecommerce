package com.catalisa.ecommerce.service;

import com.catalisa.ecommerce.model.ProdutoModel;
import com.catalisa.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<ProdutoModel> buscaProduto(){
        return produtoRepository.findAll();
    }

    public ProdutoModel cadastraProduto(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }
}
