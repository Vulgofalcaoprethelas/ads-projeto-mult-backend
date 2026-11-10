package br.com.senaisp.bauru.prjCtrlFinanceiro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senaisp.bauru.prjCtrlFinanceiro.models.Lancamento;
import br.com.senaisp.bauru.prjCtrlFinanceiro.repositories.CategoriaRepository;
import br.com.senaisp.bauru.prjCtrlFinanceiro.repositories.LancamentoRepository;
import br.com.senaisp.bauru.prjCtrlFinanceiro.repositories.UsuarioRepository;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Lancamento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Lancamento> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Lancamento salvar(Lancamento lancamento) {

        if (lancamento.getCategoria() != null) {
            lancamento.setCategoria(
                categoriaRepository.findById(lancamento.getCategoria().getId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"))
            );
        }

        if (lancamento.getUsuario() != null) {
            lancamento.setUsuario(
                usuarioRepository.findById(lancamento.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"))
            );
        }

        return repository.save(lancamento);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}