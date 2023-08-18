package com.example.demo;

public class Member {
	private int id;
	private String name;
	private Address addr;
	
	public Member(int id, String name, Address addr) {
		// super();		// 상속받은 것이 없어서 삭제
		this.id = id;
		this.name = name;
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "ID=" + id + ", Name=" + name + ", Address=" + addr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	
}
