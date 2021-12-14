package com.cadastroestudantes.controller;

import java.util.List;
import java.util.Optional;

import com.cadastroestudantes.entities.Student;
import com.cadastroestudantes.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/students")
@CrossOrigin

public class StudentController {
    @Autowired

    private StudentRepository repo;

    //endPoint - todos CadastroEstudantesApplicationTests
    @GetMapping
    public List<Student> getStudents(){
        List<Student> lista = repo.findAll();
        return lista;
    }

    //endPoint - devolve um student pelo id
    @GetMapping("{id}")
    public Student getStudent(@PathVariable Long id){
        Optional<Student> op = repo.findById(id);
        Student student = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return student;
    }

    @PostMapping
    public Student salvar(@RequestBody Student student){
        System.out.println(student);
        student = repo.save(student);
        return student;
    }

    @PutMapping("{id}")
    public Student alterar(@RequestBody Student updateStudent, @PathVariable Long id){
        Optional<Student> op = repo.findById(id);
        Student student = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        student.setName(updateStudent.getName());
        student.setRa(updateStudent.getRa());
        student.setAge(updateStudent.getAge());
        student.setSala(updateStudent.getSala());
        student.setParent(updateStudent.getParent());

        repo.save(student);
        return student;
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable Long id){
        Optional<Student> op = repo.findById(id);
        Student student = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repo.delete(student);
    }
}
