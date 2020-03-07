package com.utes.spring.web.app.service;

public interface IParsable<T, E> {

	public void convertirDtoToEntity(T objectDTO, E objectEntity);

	public T convertirEntityToDto(E objectEntity, boolean loadOneR, boolean loadAllList);

}
