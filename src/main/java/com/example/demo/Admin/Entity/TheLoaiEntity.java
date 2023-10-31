package com.example.demo.Admin.Entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "theloai")
public class TheLoaiEntity implements Serializable{
	@Id
	@NotBlank
	String id_tl;
	
	@NotBlank
	String tentheloai;
	
	@JsonIgnore
	@OneToMany(mappedBy = "theloai")
	List<SanPhamEntity> sanpham;
}