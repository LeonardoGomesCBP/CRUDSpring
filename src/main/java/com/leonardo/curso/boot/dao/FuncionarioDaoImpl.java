package com.leonardo.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.leonardo.curso.boot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

}
