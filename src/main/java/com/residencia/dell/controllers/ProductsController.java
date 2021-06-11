package com.residencia.dell.controllers;

import com.residencia.dell.entities.Products;
import com.residencia.dell.services.ProductsService;
import com.residencia.dell.vo.ProductsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/{id}")
    public ResponseEntity<Products> findById(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(productsService.findById(id), headers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Products>> findAll(
            @RequestParam(required = false) Integer pagina,
            @RequestParam(required = false) Integer qtdRegistros)
            throws Exception {

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(productsService.findAll(pagina, qtdRegistros), headers, HttpStatus.OK);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<ProductsVO>> findAllVO(
            @RequestParam(required = false) Integer pagina,
            @RequestParam(required = false) Integer qtdRegistros)
            throws Exception {

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(productsService.findAllVO(pagina,
                qtdRegistros), headers, HttpStatus.OK);
    }

    @GetMapping("/count")
    public Long count() {
        return productsService.count();
    }

    @PostMapping
    public ResponseEntity<Products> save(@Valid @RequestBody Products product) {
        HttpHeaders headers = new HttpHeaders();
        Products products = productsService.save(product);
        if (null != products)
            return ResponseEntity.ok().body(products);
        else
            return new ResponseEntity<>(productsService.save(products), headers, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> update(@Valid @RequestBody Products products, @PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();
        Products product = productsService.update(id, products);
                if(null != products) {
                    return ResponseEntity.ok().body(product);
                } else {
                    return new ResponseEntity<>(productsService.update(id, products), headers, HttpStatus.OK);
                }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Products> delete(@PathVariable Integer id) {
        try {
            productsService.delete(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}