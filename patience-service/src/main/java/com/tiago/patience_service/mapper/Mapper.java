package com.tiago.patience_service.mapper;

public interface Mapper<Entity, Request, Response> {

    public Response toDto(Entity a);
    
    public Entity toEntity(Request b);
}
