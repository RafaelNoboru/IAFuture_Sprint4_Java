package br.com.fiap.iafuture.conta;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    public void create(Conta conta) {
        contaRepository.save(conta);
    }

    public void delete(UUID id) {
        contaRepository.deleteById(id);
    }
}
