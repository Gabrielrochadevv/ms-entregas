package br.com.fiap.entregas.repository;

import br.com.fiap.entregas.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
