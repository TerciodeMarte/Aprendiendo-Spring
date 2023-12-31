package com.cafeconpalito.patrones.structural.decorator.decoradores;


import com.example.springpatterns.patterns.structural.decorator.Photo;

public class EffectVintage extends PhotoDecorator{

	public EffectVintage(Photo photo) {
		super(photo);
	}

	@Override
	public String show() {
		System.out.println("Ejecutando método show de Decorador EffectVintage");
		// decorar la foto
		this.photo.setBrightness(90);
		this.photo.setContrast(20);
		this.photo.setBlur(5);
		return this.photo.show() + " + Vintage";
	}
	
	@Override
	public double cost() {
		return this.photo.cost() + 15;
	}

}
