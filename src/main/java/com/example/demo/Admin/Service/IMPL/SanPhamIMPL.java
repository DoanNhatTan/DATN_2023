package com.example.demo.Admin.Service.IMPL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Admin.Dao.SanPhamDao;
import com.example.demo.Admin.Entity.SanPhamEntity;
import com.example.demo.Admin.Entity.TheLoaiEntity;
import com.example.demo.Admin.Service.SanPhamService;
import com.example.demo.Admin.Service.TheLoaiService;

@Service
public class SanPhamIMPL implements SanPhamService{
	@Autowired
	SanPhamDao SPDao;
	
	@Autowired
	TheLoaiService TLService;

	@Override
	public List<SanPhamEntity> findAll() {
		// TODO Auto-generated method stub
		return SPDao.findAll();
	}

	@Override
	public SanPhamEntity findById(String id) {
		// TODO Auto-generated method stub
		return SPDao.findById(id).get();
	}

	@Override
	public SanPhamEntity create(SanPhamEntity SPEntity) throws Exception {
		// TODO Auto-generated method stub
//		TheLoaiEntity TLEntity = new TheLoaiEntity();
//		TLEntity.setId_tl(SPEntity.getTheloai().getId_tl());
//		TLEntity.setTentheloai(SPEntity.getTheloai().getTentheloai());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String formattedDateAsString = dateFormat.format(SPEntity.getNgayxuatban());
		Date formattedDateAsDate = dateFormat.parse(formattedDateAsString);
		SPEntity.setNgayxuatban(formattedDateAsDate);
		
		TLService.create(SPEntity.getTheloai());
		
		return SPDao.save(SPEntity);
	}

//	@Override
//	public SanPhamEntity update(SanPhamEntity SPEntity) {
//		// TODO Auto-generated method stub
//		
//		
//		return SPDao.save(SPEntity);
//	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		SPDao.deleteById(id);
	}

	@Override
	public Integer countAllProduct() {
		// TODO Auto-generated method stub
		return  SPDao.countAllProduct();
	}

	@Override
	public Page<SanPhamEntity> findAll(Integer page, Integer limit) {
		Pageable pageable = PageRequest.of(page, limit);
		return SPDao.findAll(pageable);
	}
}