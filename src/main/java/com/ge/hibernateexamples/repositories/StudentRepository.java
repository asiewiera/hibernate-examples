package com.ge.hibernateexamples.repositories;

import com.ge.hibernateexamples.entities.Backpack;
import com.ge.hibernateexamples.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

/*    @Query(value="SELECT st.id, st.name, bp.brand  " +
            "from students st " +
            "join backpacks bp on st.fk_backpack=bp.id" +
            "where st.name=?1 ")
    List<Student> getStudent(String name);*/
}
