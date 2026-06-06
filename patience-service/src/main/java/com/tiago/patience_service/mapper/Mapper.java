package com.tiago.patience_service.mapper;

public interface Mapper<U, V> {

    public V toDto(U u);
    
    public U toEntity(V v);
}
