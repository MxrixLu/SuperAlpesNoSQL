package uniandes.edu.co.demo.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.demo.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query(value= "SELECT id, codigo, nombre, descripcion, caracteristicas_almacenamiento FROM categorias", nativeQuery = true)
    Collection<Categoria> darCategorias();

    @Query(value= "SELECT * FROM categorias WHERE id = :id", nativeQuery = true)
    Categoria darCategoria(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO categorias (id, codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES (superandes_sequence.nextval, :codigo, :nombre, :descripcion, :caracteristicas_almacenamiento)", nativeQuery = true)
    void insertarCategoria(@Param("codigo") int codigo, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("caracteristicas_almacenamiento") String caracteristicas_almacenamiento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE categorias SET codigo = :codigo, nombre = :nombre, descripcion = :descripcion, caracteristicas_almacenamiento = :caracteristicas_almacenamiento WHERE id = :id", nativeQuery = true)
    void actualizarCategoria(@Param("id") int id, @Param("codigo") int codigo, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("caracteristicas_almacenamiento") String caracteristicas_almacenamiento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM categorias WHERE id = :id", nativeQuery = true)
    void borrarCategoria(@Param("id") int id);
}
