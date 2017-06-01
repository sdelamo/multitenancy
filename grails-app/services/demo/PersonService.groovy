package demo

import grails.gorm.services.Service
import groovy.transform.CompileStatic

@Service(Person)
@CompileStatic
abstract class PersonService {

    abstract List<Person> findAll()

    abstract Person save(String name)

    abstract void delete(Serializable id)
}