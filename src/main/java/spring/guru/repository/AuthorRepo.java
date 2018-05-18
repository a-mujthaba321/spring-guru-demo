/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.guru.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring.guru.model.Author;

/**
 *
 * @author Ali Mujthaba
 */
public interface AuthorRepo extends PagingAndSortingRepository<Author, Long>{
    
}
