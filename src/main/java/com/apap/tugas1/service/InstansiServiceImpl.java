package com.apap.tugas1.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.repository.InstansiDb;

/**
 *  InstansiServiceImpl
 *  @author Priscilla Tiffany
 */
@Service
@Transactional
public class InstansiServiceImpl implements InstansiService{
	@Autowired
	private InstansiDb instansiDb;

	@Override
	public List<InstansiModel> viewAll() {
		return instansiDb.findAll();
	}

	@Override
	public InstansiModel findInstansiById(BigInteger id) {
		return instansiDb.findById(id);
	}
}
