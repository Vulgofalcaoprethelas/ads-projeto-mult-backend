package br.com.senaisp.bauru.prjCtrlFinanceiro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senaisp.bauru.prjCtrlFinanceiro.models.Lancamento;
import br.com.senaisp.bauru.prjCtrlFinanceiro.repositories.LancamentoRepository;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    public List<Lancamento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Lancamento> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Lancamento salvar(Lancamento lancamento) {
        return repository.save(lancamento);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}