package com.apap.tugas1.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugas1.model.ProvinsiModel;

/**
 *  ProvinsiDb
 *  @author Priscilla Tiffany
 */
@Repository
public interface ProvinsiDb extends JpaRepository<ProvinsiModel,Long>{

}
