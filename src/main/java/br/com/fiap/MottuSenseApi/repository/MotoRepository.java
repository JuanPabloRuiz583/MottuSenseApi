package br.com.fiap.MottuSenseApi.repository;
import br.com.fiap.MottuSenseApi.model.Moto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MotoRepository extends JpaRepository<Moto, Long> {


        Page<Moto> findAll(Pageable pageable);


        @Query("SELECT m FROM Moto m WHERE " +
                "(:placa IS NULL OR m.placa = :placa) AND " +
                "(:modelo IS NULL OR m.modelo = :modelo)")
        Page<Moto> searchByParams(@Param("placa") String placa,
                                  @Param("modelo") String modelo,
                                  Pageable pageable);

}
