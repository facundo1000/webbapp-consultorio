package edu.unam.webbapp.consultorio.services;

import java.util.List;

public interface PersonaService<T> {
  List<T> findAll();

  T getById(Integer id);

  T save (T t);

  T update(Integer id, T t);

  void deleteById(Integer id);
}
