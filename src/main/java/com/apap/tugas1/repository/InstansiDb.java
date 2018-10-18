package com.apap.tugas1.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tugas1.model.InstansiModel;

/**
 *  InstansiDB
 *  @author Priscilla Tiffany
 */
@Repository
public interface InstansiDb extends JpaRepository<InstansiModel, Long>{
	InstansiModel findById(BigInteger id);
}