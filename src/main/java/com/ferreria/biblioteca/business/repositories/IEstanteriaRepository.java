/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ferreria.biblioteca.business.repositories;

/**
 *
 * @author oriol
 */

import com.ferreria.biblioteca.business.models.EstanteriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface IEstanteriaRepository extends JpaRepository<EstanteriaModel, Integer>{
    
}
