//package com.residencia.dell.services;
//
//import com.residencia.dell.entities.Categories;
//import com.residencia.dell.entities.Orders;
//import com.residencia.dell.repositories.CategoriesRepository;
//import com.residencia.dell.vo.CategoriesVO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class CategoriesService {
//
//    @Autowired
//    public CategoriesRepository categoriesRepository;
//
//
//    public Categories findById(Integer id) {
//        return categoriesRepository.findById(id).get();
//    }
//
//    public List<Categories> findAll(){
//        return categoriesRepository.findAll();
//    }
//
//    public List<Categories> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
//        Pageable page = null;
//        List<Categories> listCategories = null;
//        List<Categories> listCategoriesComPaginacao = null;
//
//        try {
//            if (null != pagina && null != qtdRegistros) {
//                page = PageRequest.of(pagina, qtdRegistros);
//                listCategoriesComPaginacao = categoriesRepository.findAll(page).getContent();
//
//                return listCategoriesComPaginacao;
//            } else {
//                listCategories = categoriesRepository.findAll();
//
//                return listCategories;
//            }
//        } catch (Exception e) {
//            throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
//        }
//    }
//
//    public List<CategoriesVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
//        PageRequest page = null;
//        List<Categories> listCategories = null;
//        List<Categories> listCategoriesComPaginacao = null;
//        List<CategoriesVO> listCategoriesVO = new ArrayList<>();
//
//        try {
//            if (null != pagina && null != qtdRegistros) {
//
//                page = PageRequest.of(pagina, qtdRegistros);
//                listCategoriesComPaginacao = categoriesRepository.findAll(page).getContent();
//
//                for (Categories lCategories : listCategoriesComPaginacao) {
//                    listCategoriesVO.add(convertEntidadeParaVO(lCategories));
//                }
//
//            } else {
//                listCategories = categoriesRepository.findAll();
//
//                for (Categories lCategories : listCategories) {
//                    listCategoriesVO.add(convertEntidadeParaVO(lCategories));
//                }
//
//            }
//        } catch (Exception e) {
//            throw new Exception("Não foi possível recuperar a lista de categorias ::" + e.getMessage());
//        }
//
//        return listCategoriesVO;
//    }
//
//    private CategoriesVO convertEntidadeParaVO(Categories categories) {
//        CategoriesVO categoriesVO = new CategoriesVO();
//
//        categoriesVO.setCategory(categories.getCategory());
//        categoriesVO.setCategoryName(categories.getCategoryName());
//
//        return categoriesVO;
//    }
//
//    public long count(){
//        return categoriesRepository.count();
//    }
//
//    public Categories save(Categories categories){
//        if(categoriesRepository.save(categories).getCategory() != null){
//            return categoriesRepository.save(categories);
//        } else{
//            return null;
//        }
//    }
//
////    public Categories update(Categories categories){
////        return categoriesRepository.save(categories);
////    }
//
//    public Categories update(Integer id, Categories categories) {
//        Categories newCategories = categoriesRepository.findById(id).get();
//        updateDados(newCategories, categories);
//        return categoriesRepository.save(newCategories);
//    }
//
//    private void updateDados(Categories newCategories, Categories categories) {
//        newCategories.setCategoryName(categories.getCategoryName());
//    }
//
//    public boolean delete(Integer id){
//        if(id != null){
//            categoriesRepository.deleteById(id);
//            return true;
//        }else{
//            return false;
//        }
//    }
//}
