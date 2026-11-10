package br.com.senaisp.bauru.prjCtrlFinanceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senaisp.bauru.prjCtrlFinanceiro.models.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {

}