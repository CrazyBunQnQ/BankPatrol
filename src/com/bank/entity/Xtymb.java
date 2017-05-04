package com.bank.entity;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 子功能（子模块）
 */
public class Xtymb implements Serializable {

	private static final long serialVersionUID = -7558030932728725111L;
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 所属功能（模块）
	 */
	private Function function;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 请求路径
	 */
	private String url;
	/**
	 * 图片路径
	 */
	private String imgPath;

	public Xtymb() {

	}

	public Xtymb(int id, Function function, String name, String url, String imgPath) {
		super();
		this.id = id;
		this.function = function;
		this.name = name;
		this.url = url;
		this.imgPath = imgPath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((function == null) ? 0 : function.hashCode());
		result = prime * result + id;
		result = prime * result + ((imgPath == null) ? 0 : imgPath.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Xtymb other = (Xtymb) obj;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		if (id != other.id)
			return false;
		if (imgPath == null) {
			if (other.imgPath != null)
				return false;
		} else if (!imgPath.equals(other.imgPath))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Xtymb [id=" + id + ", function=" + function + ", name=" + name + ", url=" + url + ", imgPath=" + imgPath
				+ "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
